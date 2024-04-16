<template>
    <div class="card">
        <h5 class="card-header posterName">{{ message.posterFirstName + " " + message.posterLastName }}</h5>
        <div class="card-body">
            <h5 class="card-title">{{ message.messageTitle }}</h5>
            <p class="card-text">{{ message.messageContent }}</p>
            <p class="card-text fst-italic">{{ messageTime }}</p>
        </div>
    </div>
</template>

<script>
export default {
    props: ['message'],
    computed: {
        messageTime() {
            const date = new Date(this.message.dateTimePosted);
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
    }
}
</script>

<style scoped>
.posterName {
    font-size: .9rem;
}
</style>