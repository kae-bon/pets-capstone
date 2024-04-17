import axios from 'axios';

export default {

    createPlayDate(playDate) {
        return axios.post('/playdates', playDate);
    },

    getUpcomingPlayDates() {
        return axios.get('/playdates');
    },

    getFilteredUpcomingPlayDates(timeOfDay, locationCity) {
        return axios.get(`/playdates?time_of_day=${timeOfDay}&location_city=${locationCity}`);
    },

    getUserPlayDates(userId) {
        return axios.get(`/playdates?host_id=${userId}`);
    },

    addPetsToPlayDate(petMap) {
        return axios.post('/playdates/pets', petMap);
    },

    getPlayDateById(playDateId) {
        return axios.get(`/playdates/${playDateId}`);
    }

}
