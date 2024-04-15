<template>
  <div id="capstone-app" class="d-flex flex-column justify-content-between">
    <WoofrHeader />

    <router-view />
    <footer class="d-flex align-items-center justify-content-center p-2 mt-5">
      <p>&copy; Luna & Marley Co.</p>
    </footer>
  </div>
</template>

<script>
import OwnerService from './services/OwnerService';
import WoofrHeader from './components/WoofrHeader.vue';

export default {
  components: { WoofrHeader },
  computed: {

  },
  methods: {
  },
  created() {
    OwnerService.getOwner(this.$store.state.user.id)
      .then(response => {
        this.$store.commit("SET_OWNER", response.data);
      }).catch(error => {
        if (error.status === 404) {
          this.$store.commit("SET_OWNER", {});
        }
      })
  },
}
</script>

<style scoped>
#capstone-app {
  height: 100vh;
}
</style>
