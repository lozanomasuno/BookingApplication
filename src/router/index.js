import { createRouter, createWebHistory } from 'vue-router'
import HotelRoom from '../views/HotelRoom.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: HotelRoom
    },
    {
      path: '/BookedRooms',
      name: 'booked',
      component: () => import(/* webpackChunkName: "Bookedrooms" */ '@/views/BookedRooms.vue')
    },
    
  ]
})

export default router
