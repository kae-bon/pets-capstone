import axios from 'axios';

export default {

    register(owner) {
        return axios.post('/owners/register', owner)
    },

    getOwner(id) {
        return axios.get(`/owners/${id}`);
    }


}