<template>
    <div>
        <h2>{{ currentPlayDate.title }}</h2>
        <h3>{{ playDateLocation }}</h3>
        <p>{{ currentPlayDate.description }}</p>
        <h3>{{ playDateTime }}</h3>
        <p> to </p>
        <h3>{{ playDateEndTime }}</h3>
        <div>
            <p>Attendees: </p>
            <article v-for="pet in currentPlayDate.attendingPets" :key="pet.id">
                {{ pet.name }}
                <!-- we can add the owner name here later if Carly really wants it -->
            </article>
        </div>

    </div>
</template>

<script>
import PlayDateService from '../services/PlayDateService';
import LocationService from '../services/LocationService';
import OwnerService from '../services/OwnerService';
export default {
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
            return date.toDateString() + " at " + time;
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
            return date.toDateString() + " at " + time;
        },

    }


}
</script>

<style scoped></style>