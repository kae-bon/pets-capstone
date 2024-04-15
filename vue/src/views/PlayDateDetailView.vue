<template>
    <div>
        <h1>Play Date Details</h1>
    </div>
</template>

<script>
import PlayDateService from '../services/PlayDateService';
export default {
    data() {
        return {
            currentPlayDate: {},
        }
    },
    computed: {

    },
    created() {
        PlayDateService.getPlayDateById(this.$route.params.playDateId)
            .then(response => {
                this.currentPlayDate = response.data;
            })
    }

}
</script>

<style scoped></style>