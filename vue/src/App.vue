<template>
  <div id="capstone-app" class="d-flex flex-column justify-content-between">
    <header id="header" class="mb-3">
      <nav id="nav" class="navbar justify-content-between">
        <router-link class="hero-link" :to="{ name: 'woofr' }" v-if="$store.state.token == ''">
          <img class="navbar-brand" src="@/assets/nav-logo.png" alt="woofr">
        </router-link>
        <router-link class="hero-link" :to="{ name: 'user-home' }" v-else>
          <img class="navbar-brand" src="@/assets/nav-logo.png" alt="woofr">
        </router-link>
        <div class="router-links">
          <router-link class="nav-link" :to="{ name: 'woofr' }" v-if="$store.state.token == ''">Home</router-link>
          <router-link class="nav-link" :to="{ name: 'user-home' }" v-else>Home</router-link>
          <router-link class="nav-link" :to="{ name: 'register' }" v-if="$store.state.token == ''">Register</router-link>
          <router-link class="nav-link" :to="{ name: 'login' }" v-if="$store.state.token == ''">Sign In</router-link>
          <router-link class="nav-link" :to="{ name: 'logout' }" v-if="$store.state.token != ''">Sign out</router-link>
        </div>
      </nav>
    </header>

    <div class="alert alert-success" role="alert" v-bind:class="notificationClass" v-show="notification"
      v-on:click="clearNotification">
      {{ notification?.message }}
    </div>

    <router-view />
    <footer class="d-flex align-items-center justify-content-center p-2 mt-5">
      <p>&copy; Luna & Marley Co.</p>
    </footer>
  </div>
</template>

<script>
export default {
  computed: {
    notification() {
      return this.$store.state.notification;
    },
    notificationClass() {
      return {
        'status-message': true,
        error: this.notification?.type?.toLowerCase() === 'error',
        success: this.notification?.type?.toLowerCase() === 'success'
      };
    }
  },
  methods: {
    clearNotification() {
      this.$store.commit('CLEAR_NOTIFICATION');
    }
  }
}
</script>

<style scoped>
img {
  height: 100%;
  width: auto;
  margin-left: 20px;
}

.hero-link {
  height: 100%;
  width: auto;
}

.navbar {
  height: 100%;
}

#capstone-app {
  height: 100vh;
}
</style>
