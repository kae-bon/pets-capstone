<template>
    <article class="testimonial d-flex flex-column align-items-center justify-content-between">
        <img v-bind:src="image" alt="" class="mb-3">
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
    width: 33%;
}

img {
    max-width: 150px;
    max-height: 150px;
}
</style>