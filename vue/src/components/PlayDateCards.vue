<template>
    <div>
        <article>
            <p>{{ playdate.host_id }}</p>
            <p>{{ playdate.title }}</p>
            <p>{{ playdate.description }}</p>
            <p>{{ playdate.date_time }}</p>
            <p>{{ this.$store.state.locations[playdate.locationId].name }}</p>
        </article>
    </div>
</template>


<script>
export default {
    props: ['playdate']
}
</script>

<style scoped></style>