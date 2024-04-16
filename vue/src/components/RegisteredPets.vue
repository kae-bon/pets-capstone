<template>
    <div v-if="$route.name == 'profile'" class="d-flex column-gap-2 row-gap-3 flex-wrap justify-content-start">
        <PetProfile v-for="pet in $store.state.pets" :key="pet.id" :pet="pet" />
    </div>

    <div v-else>
        <SimplePetCard class="mb-3" v-for="pet in $store.state.pets" :key="pet.id" :pet="pet" />
    </div>
</template>

<script>
import PetProfile from './PetProfile.vue';
import SimplePetCard from './SimplePetCard.vue';


export default {
    components: { PetProfile, SimplePetCard },

}
</script>

<style scoped></style>