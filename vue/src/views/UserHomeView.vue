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
    </div>
</template>

<script>
import CreatePlayDate from "../components/CreatePlayDate.vue";

export default {
    data() {
        return {
            showModal: false,
            registrationSuccessful: false
        }
    },
    components: {
        CreatePlayDate
    },
    methods: {
        // clearNotification() {
        //     this.$store.commit('CLEAR_NOTIFICATION');
        // }
    },
    computed: {
        // notification() {
        //     return this.$store.state.notification;
        // },
        // notificationClass() {
        //     return {
        //         'status-message': true,
        //         error: this.notification?.type?.toLowerCase() === 'error',
        //         success: this.notification?.type?.toLowerCase() === 'success'
        //     };
        // }
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