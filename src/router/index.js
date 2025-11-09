import { createRouter, createWebHistory } from 'vue-router';

import Home from '../view/HomePage.vue'
import Login from '../view/loginPage.vue'

const routes = [
    {
        path : '/',
        name : '/login',
        component : Login

    },
    {
        path : '/home',
        name : 'Home',
        component : Home
    }
]

const router = createRouter({
    history : createWebHistory(),
    routes
})

export default router
