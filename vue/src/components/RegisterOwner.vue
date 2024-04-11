<template>
    <div class="d-flex flex-column text-center align-items-center">

        <form v-on:submit.prevent="registerOwner" class="col-4">
            <h1>Create your Owner Account</h1>

            <div class="form-input-group form-floating">
                <input class="form-control" type="text" id="first_name" v-model="newOwner.firstName"
                    placeholder="first_name" required autofocus />
                <label class="form-label" for="first_name">First Name</label>
            </div>

            <div class="form-input-group form-floating">
                <input class="form-control" type="text" id="last_name" v-model="newOwner.lastName" placeholder="last_name"
                    required autofocus />
                <label class="form-label" for="last_name">Last Name</label>
            </div>

            <div class="form-input-group form-floating">
                <input class="form-control" type="date" id="start" v-model="newOwner.birthdate" placeholder="birthdate"
                    required autofocus :max="minBirthday" />
                <label class="form-label" for="start">Birthdate</label>
            </div>
            <p>note: you must be over 18 to register!</p>
            <button type="submit" class="btn btn-primary mt-2 mb-2">Register Owner</button>
        </form>
    </div>
</template>

<script>
import OwnerService from '../services/OwnerService';

export default {
    data() {
        return {
            newOwner: {
                firstName: "", lastName: "", birthdate: "", id: 0
            }
        }
    },
    computed: {
        minBirthday() {
            const currentYear = new Date().getFullYear() - 18;
            const currentMonth = new Date().getMonth() + 1;
            const currentDay = new Date().getDate();
            if (currentDay < 10 && currentMonth < 10) {
                console.log(currentYear + "-0" + currentMonth + "-0" + currentDay);
                return currentYear + "-0" + currentMonth + "-0" + currentDay;
            } else if (currentDay < 10) {
                console.log(currentYear + "-" + currentMonth + "-0" + currentDay);
                return currentYear + "-" + currentMonth + "-0" + currentDay;
            } else if (currentMonth < 10) {
                console.log(currentYear + "-0" + currentMonth + "-" + currentDay);
                return currentYear + "-0" + currentMonth + "-" + currentDay;
            } else return currentYear + "-" + currentMonth + "-" + currentDay;
        }
    },

    methods: {
        registerOwner() {
            this.newOwner.id = this.$store.state.user.id;
            OwnerService.register(this.newOwner).then(response => {
                if (response.status == 201) {
                    this.ownerRegistered();
                }
            })
        },
        ownerRegistered() {
            this.$emit('ownerRegistered');
        }

    }

}
</script>

<style scoped>
.form-input-group {
    margin-bottom: 1rem;
}
</style>