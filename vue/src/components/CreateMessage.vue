<template>
    <div class="modal-dialog modal-dialog-centered flex-column">
        <div class="alert alert-danger" role="alert" v-if="submitFailed">
            There was an error processing your Message request, please try again later!
        </div>
        <div class="modal-content">
            <div class="modal-header">
                <h1 class="modal-title fs-5" id="messageModal">Create Message</h1>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <form v-on:submit="submitForm">
                    <div class="form-floating mb-3">
                        <input type="text" class="form-control" id="title" placeholder="title" maxlength="100"
                            v-model="newMessage.messageTitle" required>
                        <label for="title">Title</label>
                    </div>
                    <div class="form-floating mb-3">
                        <textarea class="form-control" id="message" placeholder="message" maxlength="500"
                            v-model="newMessage.messageContent" required>
                                </textarea>
                        <label for="message">Message</label>
                    </div>

                    <div class="modal-footer pt-3">
                        <button id="closeModal" type="button" class="btn btn-danger" data-bs-dismiss="modal"
                            @click="submitFailed = false">Close</button>
                        <button type="submit" class="btn btn-primary">Create Message</button>
                    </div>
                </form>
            </div>

        </div>
    </div>
</template>

<script>
import MessageService from '../services/MessageService';

export default {
    data() {
        return {
            newMessage: {
                messageTitle: "",
                messageContent: "",
                messageDateTime: "",
                posterId: this.$store.state.user.id,
            },
            submitFailed: false,
        }
    },
    methods: {
        submitForm() {
            let today = new Date();
            today.setDate(today.getDate());
            today.setHours(today.getHours() - today.getTimezoneOffset() / 60);
            this.newMessage.messageDateTime = today;

            MessageService.createMessage(this.newMessage)
                .then(response => {
                    if (response.status == 201) {
                        this.closeModal();
                        this.newMessage = {};
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

    }
}
</script>

<style scoped>
.modal-footer {
    justify-content: space-between;
}

#message {
    height: 350px;
}
</style>