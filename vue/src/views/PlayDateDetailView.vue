<template>
    <div>
        <h2>{{ currentPlayDate.title }}</h2>
        <h3>{{ playDateLocation }}</h3>
        <p>{{ currentPlayDate.description }}</p>
        <h3>{{ playDateTime }}</h3>


    </div>
</template>

<script>
import PlayDateService from '../services/PlayDateService';
import LocationService from '../services/LocationService';
export default {
    data() {
        return {
            currentPlayDate: {},
        }
    },
    computed: {
        playDateLocation() {
            const location = this.$store.state.locations
                .find(location => location.id === this.currentPlayDate.locationId);
            console.log(location);
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

    }

}
</script>

<style scoped></style>