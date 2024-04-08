<template>
    <article class="testimonial card text-center">
        <img v-bind:src="image" alt="" class="card-img-top testimonial-img">
        <p class="card-body">{{ testimonial.text }}</p>
        <p class="testimonial-author">{{ testimonial.author }}</p>
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
    font-size: .8rem;
    max-width: 30%;
}

img {
    max-width: 100%;
    max-height: 50%;
}

.testimonial-author {
    font-style: italic;
}
</style>