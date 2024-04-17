<template>
    <div class="container">
        <h1 class="mb-4">Upcoming Play Dates</h1>
        <div class="alert alert-success alert-dismissible fade show w-50" role="alert" v-if="registrationSuccessful">
            <strong>Get Ready to Play!</strong> Your dog has been registered for the play date!
            <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
        </div>

        <div class="d-flex justify-content-between align-items-center mb-4">
            <CreatePlayDateButton />

            <div class="d-flex column-gap-5 align-items-end">
                <div class="play-date-filter">
                    <label for="pd-filter">search by title or description</label>
                    <input class="form-control" type="search" id="pd-filter" v-model="filter">
                </div>

                <div class="play-date-filter">
                    <label for="time">filter by time</label>
                    <select @change="filterPlayDates" class="form-select" id="time" v-model="filterTime">
                        <option value=""></option>
                        <option value="Morning"> Morning </option>
                        <option value="Afternoon"> Afternoon </option>
                        <option value="Evening"> Evening </option>
                    </select>
                </div>

                <div class="play-date-filter">
                    <label for="city">filter by city</label>
                    <select @change="filterPlayDates" id="city" class="form-select" v-model="filterCity">
                        <option value=""></option>
                        <option v-for="location in locations" v-bind:key="location"> {{ location }} </option>
                    </select>
                </div>
            </div>
        </div>

        <div class="d-flex flex-wrap flex-row justify-content-center">
            <PlayDateCards class="w-100 playDateCards" v-for="playdate in filteredList" :key="playdate.id"
                :playdate="playdate" />
            <div v-if="playDates.length === 0">Sorry, No Play Dates found</div>
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
            filterCity: "",
            filterTime: ""
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
                PlayDateService.getAllUpcomingPlayDates()
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
                    // console.log(output)
                }
            })
            // playDateCity = playDateCity.filter((city) => {
            //     console.log(counter)
            //     return playDateCity.indexOf(city) == counter;
            // });

            return output.sort();
        }
    },
    methods: {
        filterPlayDates() {
            if (this.filterCity === "" && this.filterTime === "") {
                PlayDateService.getAllUpcomingPlayDates().then(response => {
                    this.playDates = response.data

                })
            } else if (this.filterCity !== "" && this.filterTime === "") {
                PlayDateService.getLocationFilteredUpcomingPlayDates(this.filterCity).then(response => {
                    this.playDates = response.data


                })
            } else if (this.filterCity === "" && this.filterTime !== "") {
                PlayDateService.getTimeFilteredUpcomingPlayDates(this.filterTime).then(response => {
                    this.playDates = response.data


                })
            } else {
                PlayDateService.getFilteredUpcomingPlayDates(this.filterTime, this.filterCity).then(response => {
                    this.playDates = response.data


                })
            }
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