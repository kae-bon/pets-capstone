<template>
    <div v-for="pet in $store.state.pets" :key="pet.id">
        <PetProfile :pet="pet" />
    </div>
</template>

<script>
import PetProfile from './PetProfile.vue';
export default {
    components: { PetProfile }
}
</script>

<style lang="scss" scoped></style>