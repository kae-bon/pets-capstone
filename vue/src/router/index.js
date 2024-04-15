import { createRouter as createRouter, createWebHistory } from 'vue-router'
import { useStore } from 'vuex'

// Import components
import WoofrView from '../views/WoofrView.vue';
import LoginView from '../views/LoginView.vue';
import LogoutView from '../views/LogoutView.vue';
import RegisterView from '../views/RegisterView.vue';
import UserHomeView from '../views/UserHomeView.vue';
import UpcomingPlayDatesView from '../views/UpcomingPlayDatesView.vue';
import EditInfoView from '../views/EditInfoView.vue';
import ProfileView from '../views/ProfileView.vue';
import RegisterPetView from '../views/RegisterPetView.vue'

/**
 * The Vue Router is used to "direct" the browser to render a specific view component
 * inside of App.vue depending on the URL.
 *
 * It also is used to detect whether or not a route requires the user to have first authenticated.
 * If the user has not yet authenticated (and needs to) they are redirected to /login
 * If they have (or don't need to) they're allowed to go about their way.
 */
const routes = [
  {
    path: '/',
    name: 'woofr',
    component: WoofrView,
    meta: {
      requiresAuth: false
    }
  },
  {
    path: "/login",
    name: "login",
    component: LoginView,
    meta: {
      requiresAuth: false
    }
  },
  {
    path: "/logout",
    name: "logout",
    component: LogoutView,
    meta: {
      requiresAuth: false
    }
  },
  {
    path: "/register",
    name: "register",
    component: RegisterView,
    meta: {
      requiresAuth: false
    }
  },
  {
    path: "/home",
    name: "user-home",
    component: UserHomeView,
    meta: {
      requiresAuth: true
    }
  },
  {
    path: "/upcoming",
    name: "upcoming",
    component: UpcomingPlayDatesView,
    meta: {
      requiresAuth: true
    }
  },
  {
    path: "/accountinfo",
    name: "accountinfo",
    component: EditInfoView,
    meta: {
      requiresAuth: true
    }
  },
  {
    path: "/profile",
    name: "profile",
    component: ProfileView,
    meta: {
      requiresAuth: true
    }
  },
  {
    path: "/newfriend",
    name: "register-pet",
    component: RegisterPetView,
    meta: {
      requiresAuth: true
    }
  }
];

// Create the router
const router = createRouter({
  history: createWebHistory(),
  routes: routes
});

router.beforeEach((to) => {

  // Get the Vue store
  const store = useStore();

  // Determine if the route requires Authentication
  const requiresAuth = to.matched.some(x => x.meta.requiresAuth);

  // If it does and they are not logged in, send the user to "/login"
  if (requiresAuth && store.state.token === '') {
    return { name: "login" };
  }
  // Otherwise, do nothing and they'll go to their next destination
});

export default router;
