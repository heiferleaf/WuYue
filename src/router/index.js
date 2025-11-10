import { createRouter, createWebHistory } from 'vue-router';

import Home from '../pages/HomePage.vue'
import Detail from '../pages/DetailPage.vue'
// import { path } from 'api';

const routes = [
    {
        path : '/',
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
