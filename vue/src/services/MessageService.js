import axios from 'axios';

export default {

    getMessages() {
        return axios.get("/messages");
    },

    createMessage(message) {
        return axios.post("/messages", message)
    }


}