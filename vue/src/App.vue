<template>
  <div id="capstone-app">
    <header id="header" class="mb-5">
      <nav id="nav" class="navbar justify-content-between">
        <img class="navbar-brand" src="@/assets/nav-logo.png" alt="woofr">
        <div class="router-links">
          <router-link class="nav-link" :to="{ name: 'home' }">Home</router-link>
          <router-link class="nav-link" :to="{ name: 'register' }" v-if="$store.state.token == ''">Register</router-link>
          <router-link class="nav-link" :to="{ name: 'login' }" v-if="$store.state.token == ''">Login</router-link>
          <router-link class="nav-link" :to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
        </div>
      </nav>
    </header>
    <router-view />
  </div>
</template>

<style scoped>
img {
  height: 100%;
  width: auto;
  margin-left: 20px;
}

.navbar {
  height: 100%;
}
</style>
