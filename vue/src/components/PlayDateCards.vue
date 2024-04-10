<template>
    <div>
        <article>
            <p>{{ playdate.host_id }}</p>
            <p>{{ playdate.title }}</p>
            <p>{{ playdate.description }}</p>
            <p>{{ playdate.date_time }}</p>
            <p>{{ playDateLocation }}</p>
        </article>
    </div>
</template>


<script>
export default {
    props: ['playdate'],
    computed: {
        playDateLocation() {
            const location = this.$store.state.locations
                .find(location => location.id === this.playdate.locationId)
            return location.name
        }
    }
}
</script>

<style scoped></style>