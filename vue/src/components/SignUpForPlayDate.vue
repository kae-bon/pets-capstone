<template>
    <div>
        <div class="modal-dialog modal-dialog-centered">
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
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                    <button type="button" class="btn btn-primary">Understood</button>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
export default {
    props: ['playDateId'],
    data() {
        return {
            dogArray: [],
        }
    },
    computed: {
        userPets() {
            return this.$store.state.pets;
        }
    }

}
</script>

<style scoped></style>