<template>
  <div id="capstone-app" class="d-flex flex-column justify-content-between">
    <header id="header">
      <nav id="nav" class="navbar justify-content-between">
        <img class="navbar-brand" src="@/assets/nav-logo.png" alt="woofr">
        <div class="router-links">

          <router-link class="nav-link border-start border-light" :to="{ name: 'woofr' }"
            v-if="$store.state.token == ''">Home</router-link>
          <router-link class="nav-link border-start border-light" :to="{ name: 'user-home' }" v-else>Home</router-link>

          <router-link class="nav-link border-start border-light" :to="{ name: 'upcoming' }"
            v-if="!$store.state.token == ''">Upcoming</router-link>
          <router-link class="nav-link border-start border-light" :to="{ name: 'register' }"
            v-if="$store.state.token == ''">Register</router-link>


          <router-link class="nav-link border border-top-0 border-bottom-0 border-light" :to="{ name: 'login' }"
            v-if="$store.state.token == ''">Sign In</router-link>
          <router-link class="nav-link border border-top-0 border-bottom-0 border-light" :to="{ name: 'logout' }"
            v-if="$store.state.token != ''">Sign out</router-link>
          <router-link class="nav-link pl-0" :to="{ name: 'profile' }" v-if="$store.state.token == ''"><img
              class="img-thumbnail pic rounded-circle" :src="$store.state.defaultPetPic"></router-link>
          <router-link class="nav-link" :to="{ name: 'profile' }" v-else><img class="img-thumbnail pic rounded-circle"
              :src="profilePic"></router-link>

        </div>
      </nav>
    </header>

    <!-- <div class="alert alert-success" role="alert" v-bind:class="notificationClass" v-show="notification"
      v-on:click="clearNotification">
      {{ notification?.message }}
    </div> -->

    <router-view />
    <footer class="d-flex align-items-center justify-content-center p-2 mt-5">
      <p>&copy; Luna & Marley Co.</p>
    </footer>
  </div>
</template>

<script>
import OwnerService from './services/OwnerService';

export default {
  computed: {
    profilePic() {
      if (this.$store.state.owner.profilePic == "") {
        return this.$store.state.defaultOwnerPic;
      }
      return this.$store.state.owner.profilePic;
    }

  },
  methods: {
  },
  created() {
    // OwnerService.getOwner(this.$store.state.user.id)
    //   .then(response => {
    //     this.$store.commit("SET_OWNER", response.data);
    //   })
  },
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

#header {
  margin-bottom: 5rem;
}

#capstone-app {
  height: 100vh;
}

.pic {
  height: 60px;
  width: auto;
  margin: 0;
  border: none;
}
</style>
