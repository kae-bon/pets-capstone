import axios from 'axios';

export default {

    createPlayDate(playDate) {
        return axios.post('/playdates', playDate);
    },

    getUpcomingPlayDates() {
        return axios.get('/playdates');
    },

    getUserPlayDates(userId) {
        return axios.get(`/playdates?host_id=${userId}`);
    },

    addPetsToPlayDate(petMap) {
        return axios.post('/playdates/pets', petMap);
    },

}
