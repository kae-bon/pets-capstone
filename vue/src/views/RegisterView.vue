<template>
  <div id="register" class="d-flex flex-column text-center align-items-center">
    <form v-on:submit.prevent="register" class="col-4">
      <h1>Create Account</h1>
      <div role="alert" v-if="registrationErrors">
        {{ registrationErrorMsg }}
      </div>

      <div class="form-input-group form-floating">
        <input class="form-control" type="email" id="username" v-model="user.username" placeholder="username" required
          autofocus />
        <label class="form-label" for="username">Username</label>
      </div>


      <div class="form-input-group form-floating">
        <input class="form-control" type="password" id="password" v-model="user.password" placeholder="password"
          required />
        <label class="form-label" for="password">Password</label>
      </div>

      <div class="form-input-group form-floating">
        <input class="form-control" type="password" id="confirmPassword" v-model="user.confirmPassword"
          placeholder="password" required />
        <label class="form-label" for="confirmPassword">Confirm Password</label>
      </div>

      <button type="submit" class="btn btn-primary mt-2 mb-2">Create Account</button>
      <p><router-link v-bind:to="{ name: 'login' }">Already have an account? Log in.</router-link></p>
    </form>
  </div>
</template>

<script>
import authService from '../services/AuthService';

export default {
  data() {
    return {
      user: {
        username: '',
        password: '',
        confirmPassword: '',
        role: 'user',
      },
      registrationErrors: false,
      registrationErrorMsg: 'There were problems registering this user.',
    };
  },
  methods: {
    register() {
      if (this.user.password != this.user.confirmPassword) {
        this.registrationErrors = true;
        this.registrationErrorMsg = 'Password & Confirm Password do not match.';
      } else {
        authService
          .register(this.user)
          .then((response) => {
            if (response.status == 201) {
              this.$router.push({
                path: '/login',
                query: { registration: 'success' },
              });
            }
          })
          .catch((error) => {
            const response = error.response;
            this.registrationErrors = true;
            if (response.status === 400) {
              this.registrationErrorMsg = 'Bad Request: Validation Errors';
            }
          });
      }
    },
    clearErrors() {
      this.registrationErrors = false;
      this.registrationErrorMsg = 'There were problems registering this user.';
    },
  },
};
</script>

<style scoped>
.form-input-group {
  margin-bottom: 1rem;
}

label {
  margin-right: 0.5rem;
}
</style>
