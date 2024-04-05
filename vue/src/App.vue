<template>
  <div id="capstone-app">
    <header id="header">
      <nav id="nav" class="navbar">
        <router-link class="nav-link" :to="{ name: 'home' }">Home</router-link>
        <router-link class="nav-link" :to="{ name: 'register' }" v-if="$store.state.token == ''">Register</router-link>
        <router-link class="nav-link" :to="{ name: 'login' }" v-if="$store.state.token == ''">Login</router-link>
        <router-link class="nav-link" :to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
      </nav>
    </header>
    <router-view />
  </div>
</template>

<style>
@import url('https://fonts.googleapis.com/css2?family=Luckiest+Guy&family=McLaren&display=swap');
</style>
