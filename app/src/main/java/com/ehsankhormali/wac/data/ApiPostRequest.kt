package com.ehsankhormali.wac.data

class ApiPostRequest<T>(data:T?, state: RequestState, var total:Int, var totalPages:Int): ApiRequest<T>(data=data,state=state) {
}