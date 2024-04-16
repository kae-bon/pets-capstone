import axios from 'axios';

export default {

    getMessages() {
        return axios.get("/messages");
    }


}