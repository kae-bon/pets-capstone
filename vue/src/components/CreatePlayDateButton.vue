<template>
    <div>
        <div class="d-flex justify-content-center align-items-center flex-row pb-3">
            <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#staticBackdrop">
                <i class="fa-solid fa-dog" style="color: #2ab7ca;"></i>
            </button>
            <p>Click the Dog to Register a new Play Date!</p>
        </div>

        <div class="modal fade" id="staticBackdrop" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1"
            aria-labelledby="staticBackdropLabel" aria-hidden="true">
            <CreatePlayDate class="createPlayDate" @registration="registrationSuccessful = true" />
        </div>
    </div>
</template>

<script>
import CreatePlayDate from "../components/CreatePlayDate.vue";

export default {
    data() {
        return {
            showModal: false,
            registrationSuccessful: false,
        }
    },
    components: {
        CreatePlayDate,
    }
}
</script>

<style scoped>
/* .btn {
    font-size: 1rem;
} */

i {
    font-size: 3rem;
}

.createPlayDate {
    height: 80%;
}
</style>