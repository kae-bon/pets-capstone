<template>
    <div>
        <div class="modal-dialog modal-dialog-centered d-flex flex-column">
            <div class="alert alert-danger" role="alert" v-if="addPetFailed">
                Your pet is already signed up for this play date!
            </div>
            <div class="modal-content">
                <form @submit.prevent="submitPets">


                    <div class="modal-header">
                        <h1 class="modal-title fs-5" id="staticBackdropLabel">Ready to Play?</h1>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">

                        <div class="form-check mb-3" v-for="pet in userPets" :key="pet.id">
                            <input class="form-check-input" type="checkbox" :value="pet.id" name="flexCheckDefault"
                                :id="pet.id" v-model="dogArray">
                            <label class="form-check-label" :for="pet.id">
                                {{ pet.name }}
                            </label>
                        </div>
                        <div>
                            Your Attending Pets: <div class="badge bg-info" v-for="pet in attendingPets" :key="pet.id">
                                {{ pet.name }}
                            </div>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button :id="closeModalId" type="button" class="btn btn-secondary" data-bs-dismiss="modal"
                            @click="closeModal">Close</button>
                        <button type="submit" class="btn btn-primary">Understood</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</template>

<script>
import PlayDateService from '../services/PlayDateService';
export default {
    props: {
        playDateId: {
            type: Number,
            required: true
        },

        attendingPets: {
            type: Array,
            required: true
        }
    },
    data() {
        return {
            dogArray: [],
            addPetFailed: false,
        }
    },
    // watch: {
    //     // it looks like the prop is being updated after the component is created
    //     filteredPetIds: {
    //         immediate: true,
    //         handler(n, o) {
    //             this.dogArray = this.filteredPetIds == null ? [] : [...this.filteredPetIds];
    //         }
    //     }
    // },
    computed: {

        userPets() {
            return this.$store.state.pets;
        },
        userPetIds() {
            return this.userPets.map(pet => pet.id)
        },
        closeModalId() {
            return "closePetsModal" + this.playDateId
        }
    },
    methods: {
        submitPets() {
            let petMap = [];
            this.dogArray.forEach((petId) => {
                petMap.push({ petId: petId, playDateId: this.playDateId })
            })

            PlayDateService.addPetsToPlayDate(petMap)
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
            const modal = document.getElementById((this.closeModalId));
            this.dogArray = [];
            modal.click();
        },
        confirmSuccess() {
            this.$emit('registration', 'success');
        },
    },

}
</script>

<style scoped></style>