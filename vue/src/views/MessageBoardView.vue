<template>
    <div class="container">
        <h1 class="mb-1">Announcements</h1>
        <p class="mb-3">See what everyone is barkin' about!</p>
        <CreateMessageButton />
        <div id="messageCardDiv">
            <MessageCard class="mb-4" v-for="message in messages" :key="message.messageId" :message="message" />
        </div>
    </div>
</template>

<script>
import MessageService from '../services/MessageService';
import MessageCard from '../components/MessageCard.vue';
import CreateMessageButton from '../components/CreateMessageButton.vue';

export default {
    components: { MessageCard, CreateMessageButton },
    data() {
        return {
            messages: [],
        }
    },
    created() {
        MessageService.getMessages().then(response => {
            this.messages = response.data;
        })
    }
}
</script>

<style scoped></style>