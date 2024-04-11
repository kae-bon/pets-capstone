<template>
    <div>
        <div class="alert alert-success alert-dismissible fade show w-50" role="alert" v-if="registrationSuccessful">
            <strong>Get Ready to Play!</strong> Your play date has been registered!
            <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
        </div>
        <CreatePlayDateButton />
        <div class="d-flex flex-wrap flex-row justify-content-center ">
            <PlayDateCards v-for="playdate in playDates" :key="playdate.id" :playdate="playdate" />
        </div>
    </div>
</template>

<script>
import PlayDateService from "../services/PlayDateService";
import PlayDateCards from "../components/PlayDateCards.vue";
import LocationService from "../services/LocationService";
import CreatePlayDateButton from "../components/CreatePlayDateButton.vue";

export default {
    data() {
        return {
            showModal: false,
            registrationSuccessful: false,
            playDates: []
        }
    },
    components: {
        CreatePlayDateButton, PlayDateCards
    },
    created() {
        LocationService.getLocations()
            .then(response => {
                this.$store.state.locations = response.data;
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
</style>