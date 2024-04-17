<template>
    <div class="container d-flex flex-column align-items-center h-100">
        <h2 class="mb-4">{{ currentPlayDate.title }}</h2>
        <h3>{{ playDateLocation }}</h3>
        <p>{{ currentPlayDate.description }}</p>
        <p class="fst-italic">{{ playDateTime }} to {{ playDateEndTime }}</p>
        <h3 class="mt-4 mb-4">Play Date Roster!</h3>
        <div class="d-flex column-gap-2 flex-wrap petCardList">
            <SimplePetCard v-for="pet in currentPlayDate.attendingPets" :key="pet.id" :pet="pet" />
        </div>

    </div>
</template>

<script>
import PlayDateService from '../services/PlayDateService';
import LocationService from '../services/LocationService';
import OwnerService from '../services/OwnerService';
import SimplePetCard from '../components/SimplePetCard.vue';

export default {
    components: { SimplePetCard },
    data() {
        return {
            currentPlayDate: {}
        }
    },
    created() {
        // this can be done in a better way so I can come back and do said better way but eh it works for now
        LocationService.getLocations()
            .then(response => {
                this.$store.state.locations = response.data;

            })
        PlayDateService.getPlayDateById(this.$route.params.playDateId)
            .then(response => {
                this.currentPlayDate = response.data;

            })


    },
    computed: {
        playDateLocation() {
            // might need a refactor
            const location = this.$store.state.locations
                .find(location => location.id === this.currentPlayDate.locationId);
            return location?.name;
        },
        playDateTime() {
            const date = new Date(this.currentPlayDate.dateTime);
            let time = "";
            if (date.getHours() < 10) {
                time = date.toLocaleTimeString().substring(0, 4) + " AM";
            } else if (date.getHours() < 12) {
                time = date.toLocaleTimeString().substring(0, 5) + " AM";
            } else if (date.getHours() === 12 || date.getHours() >= 22) {
                time = date.toLocaleTimeString().substring(0, 5) + " PM";
            } else if (date.getHours() < 22) {
                time = date.toLocaleTimeString().substring(0, 4) + " PM";
            }
            return date.toDateString() + ", " + time;
        },
        playDateEndTime() {
            const date = new Date(this.currentPlayDate.endDateTime);
            let time = "";
            if (date.getHours() < 10) {
                time = date.toLocaleTimeString().substring(0, 4) + " AM";
            } else if (date.getHours() < 12) {
                time = date.toLocaleTimeString().substring(0, 5) + " AM";
            } else if (date.getHours() === 12 || date.getHours() >= 22) {
                time = date.toLocaleTimeString().substring(0, 5) + " PM";
            } else if (date.getHours() < 22) {
                time = date.toLocaleTimeString().substring(0, 4) + " PM";
            }
            return time;
        },

    }


}
</script>

<style scoped>
h2 {
    font-size: 3rem;
}

.petCardList {
    max-width: 80%;
}
</style>