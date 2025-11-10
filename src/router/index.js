import { createRouter, createWebHistory } from 'vue-router';

import Home from '../view/HomePage.vue'
import Login from '../view/loginPage.vue'
import Detail from '../pages/DetailPage.vue'
// import { path } from 'api';

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
    },
    {
        path:'/detail',
        name:'Detail',
        component: Detail,
    }
]

const router = createRouter({
    history : createWebHistory(),
    routes
})

export default router
