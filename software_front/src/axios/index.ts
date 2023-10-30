import axios from 'axios'

const instance = axios.create({
    baseURL: 'http://localhost:8085',
    timeout: 1000,
});

const callApi = async (method: string, url: string, data?: any) => {
    try {
        const response = await instance({
            method,
            url,
            data
        })
        return response.data
    } catch (error) {
        console.log(error)
    }
}

export const getApi = (url: string, data?: any) => callApi('get', url, data)
export const postApi = (url: string, data?: any) => callApi('post', url, data)