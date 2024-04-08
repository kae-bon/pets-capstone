<template>
    <div class="container d-flex flex-column align-items-center mt-5 justify-content-center">
        <h2 class="pb-2">Ready To Play?</h2>
        <router-link class="btn btn-primary" :to="{ name: 'register' }" v-if="$store.state.token == ''">Create an
            Account!</router-link>
    </div>
</template>

<script>
export default {

}
</script>

<style scoped></style>