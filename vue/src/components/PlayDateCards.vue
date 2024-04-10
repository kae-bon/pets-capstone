<template>
    <article class="card text-center  col-sm-3 m-3">
        <p>{{ playdate.host_id }}</p>
        <p>{{ playdate.title }}</p>
        <p>{{ playdate.description }}</p>
        <p>{{ playDateTime }}</p>
        <p>{{ playDateLocation }}</p>
    </article>
</template>


<script>
export default {
    props: ['playdate'],
    computed: {
        playDateLocation() {
            const location = this.$store.state.locations
                .find(location => location.id === this.playdate.locationId)
            return location.name
        },
        playDateTime() {
            const date = new Date(this.playdate.dateTime);
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
        }
    }
}
</script>

<style scoped></style>