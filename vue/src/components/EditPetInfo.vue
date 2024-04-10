<template>
    <div class="d-flex flex-column text-center align-items-center">

        <form v-on:submit.prevent="register" class="col-4">
            <h1>Register your Pet</h1>

            <div class="form-input-group form-floating">
                <input class="form-control" type="text" id="name" v-model="newPet.name" placeholder="name" required
                    autofocus />
                <label class="form-label" for="name">Pet Name</label>
            </div>

            <div class="form-input-group form-floating">
                <input class="form-control" type="text" id="breed" v-model="newPet.breed" placeholder="last_name" required
                    autofocus />
                <label class="form-label" for="breed">Breed</label>
            </div>

            <div class="form-input-group form-floating">
                <input class="form-control" type="date" id="start" :max="minBirthday" v-model="newPet.birthdate"
                    placeholder="birthdate" required autofocus />
                <label class="form-label" for="start">Birthdate</label>
            </div>
            <div class="form-floating mb-3">
                <select class="form-select" id="floatingSelect" aria-label="Floating label select example"
                    v-model="newPet.size" required>
                    <option selected>---</option>
                    <option v-for="size in dogSizes" v-bind:key="size" :value="size">
                        {{ size.size + " (" + size.minWeight + "lbs - " + size.maxWeight + "lbs)" }}
                    </option>
                </select>
                <label for="floatingSelect">Pet Size</label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="checkbox" v-model="newPet.isFriendly" required id="flexCheckChecked">
                <label class="form-check-label" for="flexCheckChecked">
                    Is {{ newPet.name }} friendly with other dogs? They must be in order to register.
                </label>
            </div>

            <button type="submit" class="btn btn-primary mt-2 mb-2">Confirm Pet</button>
        </form>
    </div>
</template>

<script>
export default {
    data() {
        return {
            newPet: {
                name: "",
                ownerId: 0,
                birthdate: "",
                breed: "",
                size: "",
                isFriendly: ""
            },
            dogSizes: []
        }
    },
    computed: {
        minBirthday() {
            const currentYear = new Date().getFullYear();
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
    created() {
        this.dogSizes = this.$store.state.breedSizes;
    }
}
</script>

<style scoped>
.form-input-group {
    margin-bottom: 1rem;
}
</style>