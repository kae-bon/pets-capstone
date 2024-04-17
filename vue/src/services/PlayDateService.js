import axios from 'axios';

export default {

    createPlayDate(playDate) {
        return axios.post('/playdates', playDate);
    },

    getAllUpcomingPlayDates() {
        return axios.get('/playdates');
    },

    getTimeFilteredUpcomingPlayDates(timeOfDay) {
        return axios.get(`/playdates?time_of_day=${timeOfDay}`);
    },

    getLocationFilteredUpcomingPlayDates(locationCity) {
        return axios.get(`/playdates?location_city=${locationCity}`);
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
