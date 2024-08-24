import axios from "axios";

const testloApi = axios.create({
    baseURL: import.meta.env.VITE_TESLO_API_URL,
})


export { testloApi };