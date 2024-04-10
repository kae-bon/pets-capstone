import axios from 'axios';

export default {

    registerPet(newPet) {
        return axios.post('/pet/register', newPet)
    },


}
