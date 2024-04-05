import { createStore as _createStore } from 'vuex';
import axios from 'axios';

export function createStore(currentToken, currentUser) {
  let store = _createStore({
    state: {
      token: currentToken || '',
      user: currentUser || {},
      testimonials: [
        {
          text: "Woofr revolutionized how I socialize my pup! We've met amazing furry friends and their humans, making every playdate an adventure. Thanks to Woofr, our dog's tail is always wagging!",
          author: "Sarah & Max",
          image: "https://images.pexels.com/photos/1490908/pexels-photo-1490908.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"
        },
        {
          text: "As a busy professional, Woofr is a lifesaver for scheduling dog playdates. The platform is user-friendly, and we've found fantastic companions for our pooch. Woofr truly enhances our pup's social life!",
          author: "Grethel & Luna",
          image: "https://images.pexels.com/photos/3812207/pexels-photo-3812207.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"
        },
        {
          text: "Woofr brings joy to both pups and owners! Our furry family member has made lasting friendships, and we've connected with wonderful pet parents. Woofr isn't just a platform; it's a community that celebrates the love for our dogs!",
          author: "Emily & Baxter",
          image: "https://images.pexels.com/photos/1586948/pexels-photo-1586948.jpeg?auto=compress&cs=tinysrgb&w=400"
        }
      ]
    },
    mutations: {
      SET_AUTH_TOKEN(state, token) {
        state.token = token;
        localStorage.setItem('token', token);
        axios.defaults.headers.common['Authorization'] = `Bearer ${token}`;
      },
      SET_USER(state, user) {
        state.user = user;
        localStorage.setItem('user', JSON.stringify(user));
      },
      LOGOUT(state) {
        localStorage.removeItem('token');
        localStorage.removeItem('user');
        state.token = '';
        state.user = {};
        axios.defaults.headers.common = {};
      }
    },
  });
  return store;
}
