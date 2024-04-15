<template>
    <div>
        <div class="card text-center" style="width: 12rem;">
            <img :src="petPic" class="card-img-top" alt="...">
            <div class="card-body">
                <h5 class="card-title">{{ pet.name }}</h5>
            </div>
            <ul class="list-group list-group-flush">
                <li class="list-group-item">{{ pet.breed }}</li>
                <li class="list-group-item">{{ pet.size }}</li>
                <li class="list-group-item">{{ birthday }}</li>
            </ul>
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
        birthday() {
            let birthday = this.pet.birthdate;
            let date = new Date(birthday);
            return date.toLocaleDateString();
        }
    }
}
</script>

<style scoped>
h5 {
    font-size: 1.1rem;
}

li {
    font-size: .9rem;
}

img {
    max-width: 100%;
}
</style>