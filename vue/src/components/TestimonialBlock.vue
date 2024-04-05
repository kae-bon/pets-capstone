<template>
    <article class="testimonial d-flex flex-column align-items-center justify-content-between mb-2">
        <img v-bind:src="image" alt="" class="mb-3 flex-shrink-1">
        <p>{{ testimonial.text }}</p>
        <p>{{ testimonial.author }}</p>
    </article>
</template>

<script>
export default {
    props: ['testimonial'],
    computed: {
        image() {
            return this.testimonial.image;
        }
    }
}
</script>

<style scoped>
article {
    font-size: .9rem;
    text-align: center;
    border-radius: 10px;
    padding: 1rem;
    width: 30%;
}

img {
    max-width: 100%;
    /* max-height: 250px; */
    border-radius: 10px;
}
</style>