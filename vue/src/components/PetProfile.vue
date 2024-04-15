<template>
    <div>
        <img :src="petPic" alt="pet picture">
        <h3>{{ pet.petName }}</h3>
        <h4>Breed:</h4>
        <p>{{ pet.breed }}</p>
        <h4>Size:</h4>
        <p>{{ pet.size }}</p>
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

<style scoped></style>