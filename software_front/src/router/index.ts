import { createRouter, createWebHistory, RouteRecordRaw } from 'vue-router'

const routes: RouteRecordRaw[] = [
    {
        path: '/',
        name: 'Home',
        redirect: '/login'
    },
    {
        path: '/login',
        name: 'Login',
        component: () => import('../components/login/LoginDemo.vue')
    },
    {
        path: '/main',
        name: 'Main',
        children: [
            {
                path: 'bill',
                name: 'Bill',
                component: () => import('../components/main/components/BillDemo.vue')
            },
            {
                path: 'bus',
                name: 'Bus',
                component: () => import('../components/main/components/BusDemo.vue')
            },
            {
                path: 'phone',
                name: 'Phone',
                component: () => import('../components/main/components/PhoneDemo.vue')
            },
            {
                path: 'todo',
                name: 'Todo',
                component: () => import('../components/main/components/TodoDemo.vue')
            }
        ],
        component: () => import('../components/main/MainDemo.vue'),
        redirect: '/main/bill'
    }
]

const router = createRouter({
    history: createWebHistory(),
    routes
})

export default router