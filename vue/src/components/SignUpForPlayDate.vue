<template>
    <div>
        <div class="modal-dialog modal-dialog-centered d-flex flex-column">
            <div class="alert alert-danger" role="alert" v-if="addPetFailed">
                Your pet is already signed up for this play date!
            </div>
            <div class="modal-content">
                <div class="modal-header">
                    <h1 class="modal-title fs-5" id="staticBackdropLabel">Ready to Play?</h1>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">

                    <div class="form-check mb-3" v-for="pet in userPets" :key="pet.id">
                        <input class="form-check-input" type="checkbox"
                            :value="{ 'petId': pet.id, 'playDateId': playDateId }" name="flexCheckDefault" :id="pet.id"
                            v-model="dogArray">
                        <label class="form-check-label" :for="pet.id">
                            {{ pet.name }}
                        </label>
                    </div>



                </div>
                <div class="modal-footer">
                    <button :id="closeModalId" type="button" class="btn btn-secondary" data-bs-dismiss="modal"
                        @click="closeModal">Close</button>
                    <button type="button" class="btn btn-primary" @click="submitPets">Understood</button>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
import PlayDateService from '../services/PlayDateService';
export default {
    props: ['playDateId'],
    data() {
        return {
            dogArray: [],
            addPetFailed: false,
        }
    },
    computed: {
        userPets() {
            return this.$store.state.pets;
        },
        closeModalId() {
            return "closePetsModal" + this.playDateId
        }
    },
    methods: {
        submitPets() {
            PlayDateService.addPetsToPlayDate(this.dogArray)
                .then(response => {
                    if (response.status == 202) {
                        this.confirmSuccess();
                        this.closeModal();
                    }
                })
                .catch(error => {
                    this.addPetFailed = true;
                })
        },
        closeModal() {
            this.addPetFailed = false;
            this.dogArray = [];
            const modal = document.getElementById((this.closeModalId));
            modal.click();
        },
        confirmSuccess() {
            this.$emit('registration', 'success');
        },
    }

}
</script>

<style scoped></style>