import { createRouter, createWebHistory } from 'vue-router'
const router=createRouter({
    history: createWebHistory(import.meta.env.BASE_URL),
    routes:[
        {
            path: '/home',
            component:() =>import("../views/home.vue"), 
        },
        {
            path:"/look",
            component:()=>import("../views/look.vue")  
        },
        {
            path:"/Information",
            component:()=>import("../views/Information.vue")  
        },
                 
    ]  
    
})
export default router