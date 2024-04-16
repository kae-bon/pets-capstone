<template>
    <div class="container">
        <h1>Woofr Forum</h1>
        <p class="mb-5">See what everyone is barkin' about!</p>

        <CreateMessageButton />

        <MessageCard class="mb-4" v-for="message in messages" :key="message.messageId" :message="message" />
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