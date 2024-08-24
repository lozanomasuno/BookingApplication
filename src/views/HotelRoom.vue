<template>
   <section class="flex flex-wrap -mx-3 mb-5">
      <div class="flex justify-center items-center w-full">
         <img class="object-fill rounded-lg" src="https://i.pinimg.com/originals/fb/56/fb/fb56fb82024069127af0c374cb39084d.png" >
      </div>  
   <div class="w-full max-w-full px-3 mb-6  mx-auto">
      <div class="relative flex-[1_auto] flex flex-col break-words min-w-0 bg-clip-border rounded-[.95rem] bg-white m-5">
         <div class="relative flex flex-col min-w-0 break-words border border-dashed bg-clip-border rounded-2xl border-stone-200 bg-light/30">
         <!-- card header -->
         <div class="px-9 pt-5 flex justify-between items-stretch flex-wrap min-h-[70px] pb-0 bg-transparent">
            <h3 class="flex flex-col items-start justify-center m-2 ml-0 font-medium text-xl/tight text-dark">
               <span class="mr-3 font-semibold text-dark">All the Rooms list</span>
               <span class="mt-1 font-medium text-secondary-dark text-lg/normal">See the rooms and their current status below</span>
            </h3>
            
         </div>
         <!-- end card header -->
         <!-- card body  -->
         <div class="flex-auto block py-8 pt-6 px-9">
            <div class="overflow-x-auto">
               <table class="w-full my-0 align-middle text-dark border-neutral-200">
               <thead class="align-bottom">
                  <tr class="font-semibold text-[0.95rem] text-secondary-dark">
                     <th class="pb-3 text-start min-w-[175px]"> </th>
                     <th class="pb-3 pr-12 text-end min-w-[175px]"></th>
                     <th class="pb-3 pr-12 text-end min-w-[100px]"></th>
                  </tr>
               </thead>
               <tbody>
                  <tr class="border-b border-dashed last:border-b-0" v-for="hotel in products" key="hotel.id">
                     <td class="p-3 pl-0">
                     <div class="flex items-center">
                        <div class="relative inline-block shrink-0 rounded-2xl me-3">
                           <img :src="hotel.hotel_picture" class="w-[50px] h-[50px] inline-block shrink-0 rounded-2xl" alt=""><br>                           
                        </div>
                        <div class="flex flex-col justify-start">
                           <a  class="mb-1 cursor-pointer font-semibold transition-colors duration-200 ease-in-out text-lg/normal text-secondary-inverse hover:text-primary">{{hotel.hotel_name}}</a>
                           <span class="font-light font-light text-md/normal">{{hotel.hotel_address}}</span>
                        </div>
                     </div>
                     </td>    
                                  
                     <td class="p-3 pr-12 text-end">
                     <span class="text-center align-baseline inline-flex px-4 py-3 mr-auto items-center font-semibold text-[.95rem] leading-none text-primary bg-primary-light rounded-lg" :class="productStatusClass(hotel)">  {{ hotel.book_status ? 'Available' : 'Booked' }} </span>
                     </td>
                     <td class="p-3 pr-12 text-end">
                     <button class="text-center align-baseline inline-flex px-4 py-3 mr-auto items-center font-semibold text-[.95rem] leading-none text-primary bg-primary-light rounded-lg"> Book </button>
                     </td>

                  </tr>
               </tbody>
               </table>
            </div>
         </div>
         </div>
      </div>
   </div>
   </section>
</template>

<script>
import axios from 'axios';
import { ref, onMounted, computed } from 'vue';

export default{
   setup(){
      const productStatusClass = computed(() => {
         return product => ({
         'text-green-500': product.inStock ==1,
         'text-red-500': !product.inStock
         });
      });
      
      
      onMounted(()=>{
         listProducts();
      }) 

      const products = ref([]);
      const listProducts = async()=>{
         try{
            const response = await axios.get("http://localhost:8080/booking-app/bookings");
            products.value = response.data;
         }catch(error){
            console.log("error trying geting data", error)
         }
      };
      return {
         products,
         productStatusClass 
      }

   }
}


</script>
<style scope>
</style>