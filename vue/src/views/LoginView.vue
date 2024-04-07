<template>
  <div id="login" class="d-flex flex-column text-center align-items-center">
    <form v-on:submit.prevent="login" class="col-4">
      <h1 class="mb-4">Please Sign In</h1>
      <div role="alert" v-if="invalidCredentials">
        Invalid username and password!
      </div>
      <div role="alert" v-if="this.$route.query.registration">
        Thank you for registering, please sign in.
      </div>

      <div class="form-input-group form-floating">
        <input class="form-control" type="text" id="username" v-model="user.username" placeholder="username" required
          autofocus />
        <label class="form-label" for="username">Username</label>
      </div>
      <div class="form-input-group form-floating">
        <input class="form-control" type="password" id="password" v-model="user.password" placeholder="password"
          required />
        <label class="form-label" for="password">Password</label>
      </div>

      <button type="submit" class="btn btn-primary mt-2 mb-2">Sign in</button>
      <p>
        <router-link v-bind:to="{ name: 'register' }">Need an account? Sign up.</router-link>
      </p>
    </form>
  </div>
</template>

<script>
import authService from "../services/AuthService";

export default {
  components: {},
  data() {
    return {
      user: {
        username: "",
        password: ""
      },
      invalidCredentials: false
    };
  },
  methods: {
    login() {
      authService
        .login(this.user)
        .then(response => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            this.$router.push("/");
          }
        })
        .catch(error => {
          const response = error.response;

          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    }
  }
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