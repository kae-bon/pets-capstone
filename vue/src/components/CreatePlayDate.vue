<template>
    <div class="modal-dialog modal-dialog-centered flex-column">
        <div class="alert alert-danger" role="alert" v-if="submitFailed">
            There was an error processing your Play Date request, please try again later!
        </div>
        <div class="modal-content">
            <div class="modal-header">
                <h1 class="modal-title fs-5" id="playDateModal">Create Play Date</h1>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <form v-on:submit="submitForm">
                    <div class="form-floating mb-3">
                        <input type="text" class="form-control" id="title" placeholder="title" maxlength="100"
                            v-model="newPlayDate.title" required>
                        <label for="title">Title</label>
                    </div>
                    <div class="form-floating mb-3">
                        <textarea class="form-control" id="description" placeholder="description" maxlength="300"
                            v-model="newPlayDate.description" required>
                                </textarea>
                        <label for="description">Description</label>
                    </div>
                    <div class="form-floating mb-3">
                        <input type="datetime-local" class="form-control" id="date" placeholder="date"
                            v-model="newPlayDate.dateTime" required :min="minimumDate">
                        <label for="date">Date & Start Time</label>
                    </div>
                    <div class="form-floating mb-3">
                        <label for="durationRange" class="form-label">Play Date Duration: {{ duration }} hours</label>
                        <input type="range" class="form-range" min="0.5" max="4" step="0.5" id="durationRange"
                            v-model="duration">
                    </div>

                    <!--                    <div class="form-floating mb-3">-->
                    <!--                        <input type="datetime-local" class="form-control" id="date" placeholder="date"-->
                    <!--                            v-model="newPlayDate.endDateTime" required :min="minimumDate">-->
                    <!--                        <label for="date">Date & End Time</label>-->
                    <!--                    </div>-->

                    <div class="form-floating mb-3">
                        <select class="form-select" id="floatingSelect" aria-label="Floating label select example"
                            v-model="newPlayDate.locationId" required>
                            <option selected>---</option>
                            <option v-for="location in locations" v-bind:key="location.id" :value="location.id">
                                {{ location.name + ", " + location.city + ", " +
                                    location.stateAbbreviation }}
                            </option>
                        </select>
                        <label for="floatingSelect">Select a Location</label>
                    </div>

                    <div class="modal-footer pt-3">
                        <button id="closeModal" type="button" class="btn btn-danger" data-bs-dismiss="modal"
                            @click="submitFailed = false">Close</button>
                        <button type="submit" class="btn btn-primary">Create Play Date</button>
                    </div>
                </form>
            </div>

        </div>
    </div>
</template>

<script>
import playDateService from "../services/PlayDateService";
import locationService from "../services/LocationService";

export default {
    data() {
        return {
            newPlayDate: {
                title: "",
                description: "",
                dateTime: "",
                endDateTime: "",
                locationId: 0,
                publicDate: true
            },
            locations: [],
            submitFailed: false,
            duration: 0.5
        }
    },
    computed: {
        minimumDate() {
            let today = new Date();
            today.setDate(today.getDate() + 1);
            today.setHours(today.getHours() - today.getTimezoneOffset() / 60);
            today = today.toISOString().substring(0, 16);
            return today;
        },



    },
    methods: {
        submitForm() {
            this.calculateEndDate();
            playDateService.createPlayDate(this.newPlayDate)
                .then(response => {
                    if (response.status == 201) {
                        this.confirmSuccess();
                        this.closeModal();
                        this.newPlayDate = {};
                    }
                })
                .catch(error => {
                    // this.handleErrorResponse(error, 'creating');
                    this.submitFailed = true;
                })
        },
        closeModal() {
            const modal = document.getElementById('closeModal');
            modal.click();
        },
        confirmSuccess() {
            this.$emit('registration', 'success');
        },
        calculateEndDate() {
            let endTime = new Date(this.newPlayDate.dateTime);
            if (this.newPlayDate.dateTime == null) endTime ? Date.now() : this.newPlayDate.dateTime;
            endTime.setTime(endTime.getTime() + (this.duration * 60 * 60 * 1000));
            endTime.setHours(endTime.getHours() - endTime.getTimezoneOffset() / 60);
            this.newPlayDate.endDateTime = endTime.toISOString().substring(0, 16);
            console.log(this.newPlayDate.endDateTime)
        }

    },
    created() {
        locationService.getLocations().then(response => {
            this.locations = response.data;
        }).catch(error => {
            this.submitFailed = true;
        })
    }
}
</script>

<style scoped>
.form-label {
    height: auto;
}

.modal-footer {
    justify-content: space-between;
}

#description {
    height: 175px;
}
</style>