<template>
    <div class="container d-flex justify-content-between">
        <div class="alert alert-success alert-dismissible fade show w-50" role="alert" v-if="registrationSuccessful">
            <strong>Get Ready to Play!</strong> Your dog has been registered for the play date!
            <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
        </div>
        <section class="d-flex flex-column w-30 flex-grow-1 pe-5">
            <h1 class="mb-5">Welcome, {{ $store.state.owner.firstName }}!</h1>
            <div>
                <div>
                    <h2 class="mb-3">Your Play Dates</h2>
                    <CreatePlayDateButton class="mb-3" />
                    <div class="d-flex flex-wrap flex-row justify-content-center">
                        <PlayDateCards class="w-100 playDateCards" v-for="playdate in playDates" :key="playdate.id"
                            :playdate="playdate" @registration="registrationSuccessful = true" />
                    </div>
                </div>

            </div>
        </section>
        <div class="d-flex flex-column align-items-center">
            <h2>Your Pets</h2>
            <RegisteredPets />
        </div>
    </div>
</template>

<script>
import PlayDateService from "../services/PlayDateService";
import PlayDateCards from "../components/PlayDateCards.vue";
import LocationService from "../services/LocationService";
import CreatePlayDateButton from "../components/CreatePlayDateButton.vue";
import PetService from "../services/PetService";
import RegisteredPets from "../components/RegisteredPets.vue";

export default {
    data() {
        return {
            showModal: false,
            registrationSuccessful: false,
            playDates: []
        }
    },
    components: {
        CreatePlayDateButton, PlayDateCards, RegisteredPets
    },
    created() {
        LocationService.getLocations()
            .then(response => {
                this.$store.state.locations = response.data;
                PetService.getUserPets(this.$store.state.user.id)
                    .then(response => {
                        this.$store.state.pets = response.data
                    });
                PlayDateService.getUserPlayDates(this.$store.state.user.id)
                    .then(response => {
                        this.playDates = response.data;
                    })
            })
    }
}

</script>

<style scoped>
i {
    font-size: 5rem;
}

.playDateCards {
    /* max-width: 100%; */
    flex-basis: 0;
    max-width: 40%;
    min-width: 35%;
}

section {
    max-width: 80%;
}
</style>