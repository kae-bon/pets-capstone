<template>
    <div>
        <header id="header">
            <nav id="nav" class="navbar justify-content-between">
                <img class="navbar-brand" src="@/assets/nav-logo.png" alt="woofr">
                <div class="router-links">

                    <router-link class="nav-link border-start border-light" :to="{ name: 'woofr' }"
                        v-if="$store.state.token == ''">Home</router-link>
                    <router-link class="nav-link border-start border-light" :to="{ name: 'user-home' }"
                        v-else>Home</router-link>

                    <router-link class="nav-link border-start border-light" :to="{ name: 'upcoming' }"
                        v-if="!$store.state.token == ''">Upcoming</router-link>
                    <router-link class="nav-link border-start border-light" :to="{ name: 'message-board' }"
                        v-if="!$store.state.token == ''">Message Board</router-link>
                    <router-link class="nav-link border-start border-light" :to="{ name: 'register' }"
                        v-if="$store.state.token == ''">Register</router-link>

                    <router-link class="nav-link border border-top-0 border-bottom-0 border-light" :to="{ name: 'login' }"
                        v-if="$store.state.token == ''">Sign In</router-link>
                    <router-link class="nav-link border border-top-0 border-bottom-0 border-light" :to="{ name: 'logout' }"
                        v-if="$store.state.token != ''">Sign out</router-link>
                    <router-link class="nav-link pl-0" :to="{ name: 'profile' }" v-if="$store.state.token == ''"><img
                            class="img-thumbnail pic rounded-circle" :src="$store.state.defaultPetPic"></router-link>
                    <router-link class="nav-link" :to="{ name: 'profile' }" v-else><img
                            class="img-thumbnail pic rounded-circle" :src="profilePic"></router-link>
                </div>
            </nav>
        </header>
    </div>
</template>

<script>
import OwnerService from '../services/OwnerService';

export default {
    data() {
        return {
            // foundOwner: false
        }
    },
    computed: {
        profilePic() {
            if (Object.keys(this.$store.state.owner).length === 0 || this.$store.state.owner.profilePic == "") {
                return this.$store.state.defaultOwnerPic
            } else {
                return this.$store.state.owner.profilePic
            }
        }
    },
    // created() {
    //     OwnerService.getOwner(this.$store.state.user.id)
    //         .then(response => {
    //             this.$store.commit("SET_OWNER", response.data);
    //             this.foundOwner = true;
    //         }).catch(error => {
    //             if (error.status === 404 || error.status === 400) {
    //                 this.$store.commit("SET_OWNER", {});
    //                 this.foundOwner = false;
    //             }
    //         })
    // }
}
</script>

<style scoped>
img {
    height: 100%;
    width: auto;
    margin-left: 20px;
}

.hero-link {
    height: 100%;
    width: auto;
}

.navbar {
    height: 100%;
}

#header {
    margin-bottom: 5rem;
}

.pic {
    height: 60px;
    width: auto;
    margin: 0;
    border: none;
}
</style>