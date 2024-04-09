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
  }
};
</script>
