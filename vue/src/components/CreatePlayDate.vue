<template>
    <div>
        <div class="modal-dialog modal-dialog-centered">
            <div class="modal-content">
                <div class="modal-header">
                    <h1 class="modal-title fs-5" id="playDateModal">Create Play Date</h1>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <form v-on:submit.prevent="submitForm">
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
                            <label for="date">Date & Time</label>
                        </div>
                        <div class="form-floating mb-3">
                            <select class="form-select" id="floatingSelect" aria-label="Floating label select example"
                                v-model="newPlayDate.location" required>
                                <option selected>---</option>
                                <option value="1">placeholder</option>
                                <option value="2">placeholder2</option>
                                <option value="3">placeholder3</option>
                            </select>
                            <label for="floatingSelect">Select a Location</label>
                        </div>
                        <div class="form-check">
                            <input class="form-check-input" type="radio" value="true" name="flexRadioDefault"
                                id="radiopublic" v-model="newPlayDate.isPublic" checked required>
                            <label class="form-check-label" for="radiopublic">
                                Public - anyone can join!
                            </label>
                        </div>
                        <div class="form-check mb-3">
                            <input class="form-check-input" type="radio" value="false" name="flexRadioDefault"
                                id="radioprivate" v-model="newPlayDate.isPublic">
                            <label class="form-check-label" for="radioprivate">
                                Private - you approve who comes!
                            </label>
                        </div>
                        <div class="modal-footer pt-3">
                            <button id="closeModal" type="button" class="btn btn-danger"
                                data-bs-dismiss="modal">Close</button>
                            <button type="submit" class="btn btn-primary">Create Play Date</button>
                        </div>
                    </form>
                </div>

            </div>
        </div>
    </div>
</template>

<script>
import playDateService from "../services/PlayDateService";
export default {
    data() {
        return {
            newPlayDate: {
                title: "",
                description: "",
                dateTime: "",
                location: "",
                isPublic: true
            }
        }
    },
    computed: {
        minimumDate() {
            let today = new Date();
            today.setDate(today.getDate() + 1);
            console.log(today.toString() + "T08:00");
            today = today.toISOString().substring(0, 16);
            return today;
        }
    },
    methods: {
        submitForm() {
            playDateService.createPlayDate(this.newPlayDate)
                .then(response => {
                    if (response.status == 201) {
                        this.closeModal();
                        this.$store.commit('SET_NOTIFICATION', 'Play Date created successfully!');
                        this.$router.push({ name: 'user-home' });
                    }
                })
                .catch(error => {
                    this.handleErrorResponse(error, 'creating');
                })
        },
        closeModal() {
            const modal = document.getElementById('closeModal');
            modal.click();
        },
        handleErrorResponse(error, verb) {
            if (error.response) {
                if (error.response.status == 404) {
                    this.$router.push({ name: 'woofr' });
                } else {
                    this.$store.commit('SET_NOTIFICATION',
                        `Error ${verb} topic. Response received was "${error.response.statusText}".`);
                }
            } else if (error.request) {
                this.$store.commit('SET_NOTIFICATION', `Error ${verb} Pet Play Date. Server could not be reached.`);
            } else {
                this.$store.commit('SET_NOTIFICATION', `Error ${verb} Pet Play Date. Request could not be created.`);
            }
        }

    }
}
</script>

<style scoped>
.modal-footer {
    justify-content: space-between;
}

#description {
    height: 175px;
}
</style>