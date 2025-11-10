import { createRouter, createWebHistory } from 'vue-router';

import Home from '../view/HomePage.vue'
import Login from '../view/LoginPage.vue'
import Detail from '../view/DetailPage.vue'
import CulturePage from '../view/CulturePage.vue';
import TravelPage from '../view/TravelPage.vue';
// import { path } from 'api';

const routes = [
    {
        path : '/login',
        name : 'login',
        component : Login
    },
    {
        path : '/',
        name : 'Home',
        component : Home
    },
    {
        path:'/detail',
        name:'Detail',
        component: Detail,
    },
    {
        path:'/culture',
        name:'CulturePage',
        component: CulturePage,
    },
    {
        path:'/travel',
        name:'TravelPage',
        component: TravelPage,
    }
]

const router = createRouter({
    history : createWebHistory(),
    routes
})

export default router
