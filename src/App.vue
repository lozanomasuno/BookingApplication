<script setup>
import { RouterLink, RouterView } from 'vue-router'
</script>

<template>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/gh/Loopple/loopple-public-assets@main/riva-dashboard-tailwind/riva-dashboard.css">

  <header >
    <nav class="bg-gray-800 p-4">
      <div class="container mx-auto flex justify-between items-center">
        <div class="text-white text-lg font-semibold">MyApp</div>
        <div class="space-x-4">
          <router-link to="/" class="text-gray-300 hover:bg-sky-700">Home</router-link>
          <router-link to="/BookedRooms" class="text-gray-300 hover:bg-sky-700">My Booked Rooms</router-link>
        </div>
      </div>
    </nav>
  </header>

  <RouterView />
</template>

<style scoped>

</style>
