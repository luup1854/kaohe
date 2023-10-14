import request from "../utils/request"
//进入功能方法实现
export const  getInformationById=(id)=>
    request.get("/select?id="+id)
//查看功能的实现
export const examin=()=>
    request.get("/examin")
//重置
export const resetService=() =>
    request.post("/reset")
export const getNumberList=()=>
    request.get("/list")
