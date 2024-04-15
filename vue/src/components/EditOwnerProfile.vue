<template>
    <div>
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h1 class="modal-title fs-5" id="staticBackdropLabel">Edit Profile</h1>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <form @submit.prevent="update()">
                        <div class="form-floating mb-3">
                            <input type="text" class="form-control" v-model="updatedOwner.firstName" id="firstname"
                                placeholder="firstname">
                            <label for="floatingInput">First Name</label>
                        </div>
                        <div class="form-floating mb-3">
                            <input type="text" class="form-control" v-model="updatedOwner.lastName" id="lastname"
                                placeholder="lastname">
                            <label for="floatingPassword">Last Name</label>
                        </div>
                        <div class="form-floating mb-3">
                            <input type="email" class="form-control" v-model="updatedUser.email" id="email"
                                placeholder="email">
                            <label for="floatingPassword">Email</label>
                        </div>
                        <div class="form-input-group form-floating mb-3">
                            <input class="form-control" type="date" id="birthday" v-model="updatedOwner.birthdate"
                                placeholder="birthdate" autofocus :max="minBirthday" />
                            <label class="form-label" for="start">Birthdate</label>
                        </div>

                        <PicUploaderButton class="mb-5 text-center" @imageUploaded="setImgToDisplay" />
                        <div class="d-flex justify-content-between">
                            <button type="button" id="closeEditModal" class="btn btn-danger"
                                data-bs-dismiss="modal">Close</button>
                            <button type="submit" class="btn btn-primary">Save Changes</button>
                        </div>
                    </form>
                </div>

            </div>
        </div>
    </div>
</template>

<script>
import PicUploaderButton from '../components/PicUploaderButton.vue';
import OwnerService from '../services/OwnerService';

export default {
    components: {
        PicUploaderButton
    },
    data() {
        return {
            updatedOwner: {
                firstName: this.$store.state.owner.firstName,
                lastName: this.$store.state.owner.lastName,
                birthdate: this.$store.state.owner.birthdate,
                profilePic: this.$store.state.owner.profilePic
            },
            updatedUser: {
                email: this.$store.state.user.username
            }
        }
    },
    methods: {
        update() {
            if (this.updatedOwner.firstName == "" || this.updatedOwner.firstName == null) {
                this.updatedOwner.firstName = this.$store.state.owner.firstName
            }
            if (this.updatedOwner.lastName == "" || this.updatedOwner.lastName == null) {
                this.updatedOwner.lastName = this.$store.state.owner.lastName
            }
            if (this.updatedUser.email == "" || this.updatedUser.email == null) {
                this.updatedUser.email = this.$store.state.user.username
            }
            this.updatedOwner.userid = this.$store.state.user.id

            OwnerService.updateOwner(this.$store.state.user.id, this.updatedOwner)
                .then(response => {
                    if (response.status === 200) {
                        this.closeModal();
                        this.$store.commit("SET_OWNER", this.updatedOwner);
                    }
                })
        },
        closeModal() {
            const modal = document.getElementById('closeEditModal');
            modal.click();
        },
        setImgToDisplay(img) {
            this.profileImg = img;
            this.$store.state.owner.profilePic = img;
            this.updatedOwner.profilePic = img;
        },
    },
    computed: {
        minBirthday() {
            const currentYear = new Date().getFullYear() - 18;
            const currentMonth = new Date().getMonth() + 1;
            const currentDay = new Date().getDate();
            if (currentDay < 10 && currentMonth < 10) {
                return currentYear + "-0" + currentMonth + "-0" + currentDay;
            } else if (currentDay < 10) {
                return currentYear + "-" + currentMonth + "-0" + currentDay;
            } else if (currentMonth < 10) {
                return currentYear + "-0" + currentMonth + "-" + currentDay;
            } else return currentYear + "-" + currentMonth + "-" + currentDay;
        }
    }
}
</script>

<style scoped></style>