import axios from 'axios';

export default {

    getLocations() {
        return axios.get("/locations");
    }


}