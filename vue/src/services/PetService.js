import axios from 'axios';

export default {

    registerPet(newPet) {
        return axios.post('/owner/pet/register', newPet)
    },

    getUserPets(userId) {
        return axios.get('/owner/pets')
    }


}
