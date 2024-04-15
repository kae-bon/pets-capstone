<template>
    <div>
        <RegisterOwner v-if="showRegisterOwner" @ownerRegistered="toggleForms" />
        <RegisterPet v-if="showRegisterPet" />
    </div>
</template>

<script>
import RegisterOwner from '../components/RegisterOwner.vue';
import RegisterPet from '../components/RegisterPet.vue';


export default {
    data() {
        return {
            showRegisterPet: false,
            showRegisterOwner: true,
        }
    },
    components: {
        RegisterOwner, RegisterPet
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