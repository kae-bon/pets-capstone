<template>
    <div>
        <div class="card text-center" style="width: 8rem;">
            <img :src="petPic" class="card-img-top" alt="...">
            <div class="card-body">
                <h5 class="card-title">{{ pet.name }}</h5>
            </div>
        </div>
    </div>
</template>

<script>
export default {
    props: ['pet'],
    computed: {
        petPic() {
            if (this.pet.profilePic == "") {
                return this.$store.state.defaultPetPic;
            } else return this.pet.profilePic;
        },
    }
}
</script>

<style scoped></style>