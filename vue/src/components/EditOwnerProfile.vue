<template>
    <div>
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h1 class="modal-title fs-5" id="staticBackdropLabel">Edit Profile</h1>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <form @submit.prevent="update">
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
                            <input type="email" class="form-control" v-model="updatedOwner.email" id="email"
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
                            <button type="button" id="closeEditModal" class="btn btn-danger" data-bs-dismiss="modal"
                                @click="resetForm">Close</button>
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
    props: ['owner'],
    components: {
        PicUploaderButton
    },
    data() {
        return {
            updatedOwner: {
                firstName: this.owner.firstName,
                lastName: this.owner.lastName,
                birthdate: this.owner.birthdate,
                profilePic: this.owner.profilePic,
                email: this.owner.email
            },
            // updatedUser: {
            //     email: this.$store.state.user.username
            // }
        }
    },
    methods: {
        update() {
            if (this.updatedOwner.firstName == "" || this.updatedOwner.firstName == null) {
                this.updatedOwner.firstName = this.owner.firstName
            }
            if (this.updatedOwner.lastName == "" || this.updatedOwner.lastName == null) {
                this.updatedOwner.lastName = this.owner.lastName
            }
            if (this.updatedOwner.email == "" || this.updatedOwner.email == null) {
                this.updatedOwner.email = this.owner.email
            }
            if (this.updatedOwner.birthdate == null) {
                this.updatedOwner.birthdate = this.owner.birthdate
            }
            if (this.updatedOwner.profilePic == "") {
                this.updatedOwner.profilePic = this.owner.profilePic;
            }
            this.updatedOwner.userid = this.$store.state.user.id

            OwnerService.updateOwner(this.$store.state.user.id, this.updatedOwner)
                .then(response => {
                    if (response.status === 200) {
                        this.closeModal();
                        this.$store.commit("SET_OWNER", response.data);
                    }
                })
        },
        closeModal() {
            const modal = document.getElementById('closeEditModal');
            modal.click();
            this.resetForm();
        },
        setImgToDisplay(img) {
            // this.$store.state.owner.profilePic = img;
            this.updatedOwner.profilePic = img;
        },
        resetForm() {
            // this.updatedOwner.firstName = this.owner.firstName;
            // this.updatedOwner.lastName = this.owner.lastName;
            // this.updatedOwner.birthdate = this.owner.birthdate;
            // this.updatedOwner.profilePic = this.owner.profilePic;
            this.updatedOwner = this.owner;
        }
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
    },
    watch: {
        owner: {
            immediate: true,
            handler(n, o) {
                this.updatedOwner = this.owner;
            }
        }
    }
}
</script>

<style scoped></style>