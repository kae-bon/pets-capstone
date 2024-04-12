<template>
    <div>
        <RegisterOwner v-if="showRegisterOwner" @ownerRegistered="toggleForms" />
        <EditPetInfo v-if="showRegisterPet" />
    </div>
</template>

<script>
import RegisterOwner from '../components/RegisterOwner.vue';
import EditPetInfo from '../components/EditPetInfo.vue';


export default {
    data() {
        return {
            showRegisterPet: true,
            showRegisterOwner: true,
        }
    },
    components: {
        RegisterOwner, EditPetInfo
    },
    methods: {
        toggleForms() {
            this.showRegisterOwner = !this.showRegisterOwner;
            this.showRegisterPet = !this.showRegisterPet;
        }
    }

}
</script>

<style scoped></style>