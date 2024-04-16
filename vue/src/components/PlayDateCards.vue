<template>
    <article class="card text-center col m-3">
        <p>{{ playdate.host_id }}</p>
        <div class="card-body d-flex flex-column justify-content-between">
            <h2 class="card-title">{{ playdate.title }}</h2>
            <p class="card-subtitle mb-3">{{ playDateLocation }}</p>
            <p class="card-text">{{ playdate.description }}</p>
            <p class="time">{{ playDateTime }}</p>
            <p> to </p>
            <p class="time">{{ playDateEndTime }}</p>

        </div>
        <div class="card-footer d-flex justify-content-around">
            <button type="button" class="btn btn-primary" data-bs-toggle="modal" :data-bs-target="modalTarget">
                RSVP
            </button>
            <router-link class="btn btn-primary"
                v-bind:to="{ name: 'play-date-details', params: { playDateId: this.playdate.playDateId } }">
                More Info
            </router-link>
        </div>
        <div class="modal fade" :id="modalId" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1"
            aria-labelledby="staticBackdropLabel" aria-hidden="true">
            <SignUpForPlayDate :playDateId="playdate.playDateId" :filteredPetIds="filteredPetIds" />
        </div>
    </article>
</template>

<script>
import SignUpForPlayDate from './SignUpForPlayDate.vue';

export default {
    props: ['playdate'],
    components: { SignUpForPlayDate },
    computed: {
        playDateLocation() {
            const location = this.$store.state.locations
                .find(location => location.id === this.playdate.locationId)
            return location.name
        },
        playDateTime() {
            const date = new Date(this.playdate.dateTime);
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
            const date = new Date(this.playdate.endDateTime);
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
        modalId() {
            return "sign-up-play-date-" + this.playdate.playDateId;
        },
        modalTarget() {
            return "#sign-up-play-date-" + this.playdate.playDateId;
        },
        filteredPetIds() {
            let petIds = [];
            let attendingPetIds = this.playdate.attendingPets.map(pet => pet.id);

            this.$store.state.pets.forEach((pet) => {
                if (attendingPetIds.includes(pet.id)) {
                    petIds.push(pet.id)
                }
            })
            return petIds
        }
    },
}
</script>

<style scoped>
.card-title {
    font-size: 1.5rem;
    color: #003049;
}

.card-subtitle {
    font-size: 1rem;
    font-style: italic;
}

.time {
    font-weight: bold;
}
</style>