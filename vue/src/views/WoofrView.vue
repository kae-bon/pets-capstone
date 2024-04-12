<template>
  <div class="home">
    <HomeAbout />
    <CustomerTestimonials />
    <FeatureList />
    <ReadyToPlay />
  </div>
</template>

<script>
import HomeAbout from '../components/HomeAbout.vue';
import CustomerTestimonials from '../components/CustomerTestimonials.vue';
import FeatureList from '../components/FeatureList.vue';
import ReadyToPlay from '../components/ReadyToPlay.vue'
export default {
  components: {
    HomeAbout, CustomerTestimonials, FeatureList, ReadyToPlay
  },
  created() {
    if (this.$store.state.user.id > 0) { //TODO: This causes a security issue where a user who was logged in can access it after server is reset. Fix before prod deploy.
      this.$router.push({ name: `user-home` });

    }
  }
};
</script>
