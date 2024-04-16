<template>
    <div class="d-flex align-items-center column-gap-3 mb-4">
        <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#messageModal">
            <i class="fa-solid fa-message" style="color: #2ab7ca;"></i>
        </button>
        <p class="m-0">Click to Create a new message!</p>
    </div>

    <div class="modal fade" id="messageModal" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1"
        aria-labelledby="staticBackdropLabel" aria-hidden="true">
        <CreateMessage class="createMessage" />
    </div>
</template>

<script>
import CreateMessage from './CreateMessage.vue';

export default {
    data() {
        return {
            showModal: false,
        }
    },
    components: {
        CreateMessage,
    }
}
</script>

<style scoped>
i {
    font-size: 2rem;
}

.createMessage {
    height: 80%;
}
</style>