<template>
    <div class="container">
        <h1 class="text-center mb-4">Upcoming Play Dates</h1>
        <div class="alert alert-success alert-dismissible fade show w-50" role="alert" v-if="registrationSuccessful">
            <strong>Get Ready to Play!</strong> Your dog has been registered for the play date!
            <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
        </div>

        <CreatePlayDateButton />
        <div class="play-date-filter">
            <input type="search" id="pd-filter" v-model="filter" placeholder="Title or description">
        </div>

        <div class="play-date-filter">
            choose a playdate time:
            <select>
                <option value="All"> All </option>
                <option value="Morning"> Morning </option>
                <option value="Afternoon"> Afternoon </option>
                <option value="Evening"> Evening </option>
            </select>
        </div>

        <div class="play-date-filter">
            choose a playdate city:
            <select>
                <option value="All"> All </option>
                <option v-for="location in locations" v-bind:key="location"> {{ location }} </option>
                <!-- <option value="Blue Ash"> Blue Ash </option>
                <option value="Cincinnati"> Cincinnati </option>
                <option value="Fairfield"> Fairfield </option>
                <option value="Florence"> Florence </option>
                <option value="Fort-Thomas"> Fort Thomas </option>
                <option value="Hamilton"> Hamilton </option>
                <option value="Loveland"> Loveland </option>
                <option value="Newport"> Newport </option> -->
            </select>
        </div>

        <div class="d-flex flex-wrap flex-row justify-content-center">
            <PlayDateCards class="w-100 playDateCards" v-for="playdate in filteredList" :key="playdate.id"
                :playdate="playdate" />
        </div>

    </div>
</template>

<script>
import PlayDateService from "../services/PlayDateService";
import PlayDateCards from "../components/PlayDateCards.vue";
import LocationService from "../services/LocationService";
import CreatePlayDateButton from "../components/CreatePlayDateButton.vue";
import PetService from "../services/PetService";
import _default from "vuex";


export default {
    data() {
        return {
            showModal: false,
            registrationSuccessful: false,
            playDates: [],
            times: [],
            filter: "",

        }
    },
    components: {
        PlayDateCards, CreatePlayDateButton
    },
    created() {
        LocationService.getLocations()
            .then(response => {
                this.$store.state.locations = response.data;
                PetService.getUserPets(this.$store.state.user.id)
                    .then(response => {
                        this.$store.state.pets = response.data
                    });
                PlayDateService.getUpcomingPlayDates()
                    .then(response => {
                        this.playDates = response.data;
                    });
            })
    },
    computed: {
        filteredList() {
            let filteredPlayDates = this.playDates;
            if (this.filter != "") {
                filteredPlayDates = filteredPlayDates.filter((playDate) =>
                    playDate.title.toLowerCase().includes(this.filter.toLowerCase()) ||
                    playDate.description.toLowerCase().includes(this.filter.toLowerCase())
                )
            }
            return filteredPlayDates;
        },
        locations() {
            let playDateCity = this.$store.state.locations;
            let counter = -1;
            let output = [];
            playDateCity.forEach((city) => {
                if (!output.includes(city.city)) {
                    output.push(city.city)
                    console.log(output)
                }
            })
            // playDateCity = playDateCity.filter((city) => {
            //     console.log(counter)
            //     return playDateCity.indexOf(city) == counter;
            // });

            return output.sort();
        }

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
    max-width: 30%;
    min-width: 30%;
}
</style>