<template>
    <div class="container d-flex flex-column align-items-center mt-5">
        <h2 class="pb-2">Testimonials</h2>
        <div class="d-flex column-gap-3 flex-wrap justify-content-center">
            <TestimonialBlock v-for="testimonial in getTestimonials" :key="testimonial" :testimonial="testimonial" />
        </div>
    </div>
</template>

<script>
import TestimonialBlock from './TestimonialBlock.vue';
export default {
    components: {
        TestimonialBlock
    },
    computed: {
        getTestimonials() {
            return this.$store.state.testimonials;
        }
    }
}
</script>

<style scoped></style>