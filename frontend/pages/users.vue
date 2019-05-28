<template>
  <div class="dataview">
    <el-table
      :data="users"
      style="width: 100%">
      <el-table-column
        prop="id"
        label="ID"
        width="50">
      </el-table-column>
      <el-table-column
        prop="firstName"
        label="First Name">
      </el-table-column>
      <el-table-column
        prop="lastName"
        label="Last Name">
      </el-table-column>
    </el-table>

    <div class="button-bar">
      <el-button @click="addUserVisible = true">Add user</el-button>
    </div>

    <el-dialog title="Add a user" :visible.sync="addUserVisible">
      <el-form ref="userForm" :model="user" :rules="userRules" label-width="200px">
        <el-form-item label="First name" prop="firstName">
          <el-input v-model="user.firstName"></el-input>
        </el-form-item>
        <el-form-item label="Last name" prop="lastName">
          <el-input v-model="user.lastName"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="addUser('userForm')">Add</el-button>
          <el-button @click="addUserVisible = false">Cancel</el-button>
        </el-form-item>
      </el-form>
    </el-dialog>
  </div>
</template>

<script>
export default {
  name: 'users',

  layout: 'with-navbar',

  data() {
    return {
      addUserVisible: false,
      user: {
        firstName: '',
        lastName: ''
      },
      userRules: {
        firstName: [
          { required: true, message: 'Please set a first name', trigger: 'blur' }
        ],
        lastName: [
          { required: true, message: 'Please set a last name', trigger: 'blur' }
        ]
      },
      users: []
    }
  },

  mounted() {
    this.loadUsers()
  },

  methods: {
    loadUsers() {
      this.$axios.$get('/api/user')
        .then(data => {
          this.users = data
        })
    },

    addUser(formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          this.addUserVisible = false
          this.$axios.$post('/api/user?firstName=' + this.user.firstName + '&lastName=' + this.user.lastName)
            .then (resp => {
              this.$message({
                type: 'success',
                message: 'User added with success'
              })
              this.user = { firstName: '', lastName: '' }
              this.loadUsers()
            })
            .catch (err => {
              this.$message({
                type: 'error',
                message: 'An error occured: ' + err
              })
            })
        }
        return valid
      })
    }
  }
}
</script>
