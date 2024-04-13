
<template>
  <div class="d-flex flex-column justify-content-center align-items-center">
    <h1 class="mb-5">{{ $store.state.owner.firstName }}'s Profile</h1>
    <div class="d-flex align-items-center justify-content-center mb-5 column-gap-5 w-100">
      <img class="img-thumbnail profilePic" :src="profilePic" alt="user's profile picture">
      <div class="text-center">
        <h2>First Name</h2>
        <p class="mb-4">{{ this.$store.state.owner.firstName }}</p>
        <h2>Last Name</h2>
        <p class="mb-4">{{ this.$store.state.owner.lastName }}</p>
        <h2>Email</h2>
        <p class="mb-4">{{ this.$store.state.user.username }}</p>
        <h2>Birthday</h2>
        <p>{{ birthday }}</p>
      </div>
    </div>
    <!-- Button trigger modal -->
    <div>
      <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#editProfile">
        Edit User Information
      </button>
    </div>

    <!-- Modal -->
    <div class="modal fade" id="editProfile" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1"
      aria-labelledby="editOwnerProfile" aria-hidden="true">
      <editOwnerProfile />
    </div>
  </div>
</template>

<script>
import OwnerService from '../services/OwnerService';
import editOwnerProfile from '../components/EditOwnerProfile.vue'

export default {
  components: { editOwnerProfile },
  name: "ProfileView.vue",
  created() {
    OwnerService.getOwner(this.$store.state.user.id)
      .then(response => {
        this.$store.commit("SET_OWNER", response.data);
      })
  },
  computed: {
    profilePic() {
      if (this.$store.state.owner.profilePic == "") {
        return this.$store.state.defaultOwnerPic;
      }
      return this.$store.state.owner.profilePic;
    },
    birthday() {
      let birthday = this.$store.state.owner.birthdate;
      let date = new Date(birthday);
      return date.toLocaleDateString();
    }
  },
  methods: {
    editOwnerProfile() {

    }
  }
}
</script>


<style scoped>
.profilePic {
  height: auto;
  max-width: 350px;
  border-radius: 100vmax;
}

h2 {
  font-size: 1.5rem;
}
</style>