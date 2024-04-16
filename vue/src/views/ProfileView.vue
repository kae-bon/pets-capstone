
<template>
  <div class="container">
    <article class="d-flex flex-column justify-content-center align-items-center mb-5">
      <h1 class="mb-5">{{ $store.state.owner.firstName }}'s Profile</h1>
      <div class="d-flex align-items-center justify-content-center mb-5 column-gap-5 w-100">
        <img class="img-thumbnail profilePic" :src="profilePic" alt="user's profile picture">
        <div class="text-center">
          <h2>First Name</h2>
          <p class="mb-4">{{ this.$store.state.owner.firstName }}</p>
          <h2>Last Name</h2>
          <p class="mb-4">{{ this.$store.state.owner.lastName }}</p>
          <h2>Email</h2>
          <p class="mb-4">{{ this.$store.state.owner.email }}</p>
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
    </article>
    <div class="d-flex justify-content-center column-gap-5 mb-5">
      <i class="fa-solid fa-paw"></i><i class="fa-solid fa-paw"></i><i class="fa-solid fa-paw"></i>
    </div>
    <article>
      <div class="d-flex justify-content-start mb-4 column-gap-5 align-items-center">
        <h1 class="mb-3">My Pets</h1>
        <button type="button" class="btn btn-primary" @click="registerNewPet">
          Register New Pet
        </button>
      </div>



      <RegisteredPets />

    </article>
  </div>

  <!-- Modal -->
  <div class="modal fade" id="editProfile" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1"
    aria-labelledby="editOwnerProfile" aria-hidden="true">
    <editOwnerProfile :owner="currentOwner" @updatedProfile="resetOwner" />
  </div>
</template>

<script>
import OwnerService from '../services/OwnerService';
import PetService from '../services/PetService';
import editOwnerProfile from '../components/EditOwnerProfile.vue'
import RegisteredPets from '../components/RegisteredPets.vue';

export default {
  components: { editOwnerProfile, RegisteredPets },
  name: "ProfileView.vue",
  data() {
    return {
      currentOwner: this.$store.state.owner,
    }
  },
  created() {
    OwnerService.getOwner(this.$store.state.user.id)
      .then(response => {
        this.$store.commit("SET_OWNER", response.data);
      })
    PetService.getUserPets(this.$store.state.user.id)
      .then(response => {
        this.$store.state.pets = response.data
      });
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
    registerNewPet() {
      this.$router.push({ name: 'register-pet' })
    },
    resetOwner() {
      OwnerService.getOwner(this.$store.state.user.id)
        .then(response => {
          this.$store.commit("SET_OWNER", response.data);
        })
    }

  }
}
</script>


<style scoped>
.profilePic {
  height: auto;
  max-width: 350px;
  border-radius: 50%;
}

h2 {
  font-size: 1.5rem;
}

i {
  font-size: 2rem;
}
</style>