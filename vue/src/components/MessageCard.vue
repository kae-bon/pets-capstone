<template>
    <div class="card message-card">
        <div class="card-header d-flex justify-content-between align-items-center">
            <h5 class="posterName mb-0">{{ message.posterFirstName + " " + message.posterLastName }}</h5>
            <div>
                <p class="card-text fst-italic dateTime">{{ messageDate }}&nbsp;&nbsp; <i
                        class="fa-solid fa-bone"></i>&nbsp;&nbsp; {{ messageTime
                        }}</p>
            </div>
        </div>
        <div class="card-body p-4">
            <h5 class="card-title messageTitle">{{ message.messageTitle }}</h5>
            <p class="card-text">{{ message.messageContent }}</p>


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
            return time;
        },
        messageDate() {
            const date = new Date(this.message.dateTimePosted);
            return date.toDateString();
        }
    }
}
</script>

<style scoped>
.posterName,
.dateTime {
    font-size: .9rem;
}
</style>