import { postApi } from "./index";

export const postLogin = (data: any) => postApi('/userLogin', data)

export const selectBill = (data: any) => postApi('/selectBill', data)
export const deleteBill = (data: any) => postApi('/deleteBill', data)
export const addBill = (data: any) => postApi('/addBill', data)

export const selectCall = (data: any) => postApi('/orderCall', data)
export const deleteCall = (data: any) => postApi('/deleteCall', data)
export const addCall = (data: any) => postApi('/addCall', data)

export const selectDate = (data: any) => postApi('/orderDate', data)
export const deleteDate = (data: any) => postApi('/deleteDate', data)
export const addDate = (data: any) => postApi('/addDate', data)