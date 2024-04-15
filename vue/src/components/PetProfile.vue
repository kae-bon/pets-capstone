<template>
    <div>
        <div class="text-center">
            <img :src="petPic" alt="pic of registered pet">
            <h2>Name</h2>
            <p class="mb-4">{{ pet.name }}</p>
            <h2>Breed</h2>
            <p class="mb-4">{{ pet.breed }}</p>
            <h2>Size</h2>
            <p class="mb-4">{{ pet.size }}</p>
            <h2>Birthday</h2>
            <p>{{ pet.birthdate }}</p>
        </div>
    </div>
</template>

<script>
export default {
    props: ['pet'],
    computed: {
        petPic() {
            return this.pet.profilePic;
        }
    }
}
</script>

<style scoped>
h2 {
    font-size: 1.2rem;
}

img {
    width: 200px;
    height: auto;
}
</style>