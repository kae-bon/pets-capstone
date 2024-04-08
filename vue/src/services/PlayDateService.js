import axios from 'axios';

export default {

    createPlayDate(playDate) {
        return axios.post('/playdates');
    }


}
