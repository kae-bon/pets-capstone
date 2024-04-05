<template>
  <div class="home">
    <HomeAbout />
    <CustomerTestimonials />
  </div>
</template>

<script>
import HomeAbout from '../components/HomeAbout.vue';
import CustomerTestimonials from '../components/CustomerTestimonials.vue';

export default {
  components: {
    HomeAbout, CustomerTestimonials
  }
};
</script>
