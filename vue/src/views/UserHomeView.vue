<template>
    <div>
        <div class="alert alert-success alert-dismissible fade show w-50" role="alert" v-if="registrationSuccessful">
            <strong>Get Ready to Play!</strong> Your play date has been registered!
            <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
        </div>
        <div>
            <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#staticBackdrop">
                <i class="fa-solid fa-dog" style="color: #2ab7ca;"></i>
            </button>
            <p>Click the Dog to Register a new Play Date!</p>

            <div class="modal fade" id="staticBackdrop" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1"
                aria-labelledby="staticBackdropLabel" aria-hidden="true">
                <CreatePlayDate class="createPlayDate" @registration="registrationSuccessful = true" />
            </div>
        </div>
        <div>
            <PlayDateCards v-for="playdate in playDates" :key="playdate.id" :playdate="playdate" />
        </div>
    </div>
</template>

<script>
import CreatePlayDate from "../components/CreatePlayDate.vue";
import PlayDateService from "../services/PlayDateService";
import PlayDateCards from "../components/PlayDateCards.vue";
import LocationService from "../services/LocationService";
export default {
    data() {
        return {
            showModal: false,
            registrationSuccessful: false,
            playDates: []
        }
    },
    components: {
        CreatePlayDate, PlayDateCards
    },
    created() {
        PlayDateService.getUpcomingPlayDates()
            .then(response => {
                this.playDates = response.data;
            }),
            LocationService.getLocations()
                .then(response => {
                    this.$store.state.locations = response.data;
                })
    }

}
</script>

<style scoped>
i {
    font-size: 5rem;
}

.createPlayDate {
    height: 80%;
}
</style>