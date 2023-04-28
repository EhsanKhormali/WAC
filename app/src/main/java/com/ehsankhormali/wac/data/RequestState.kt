package com.ehsankhormali.wac.data

sealed class RequestState(val message: String?){
    class Success: RequestState(message = null)
    class Error(message: String): RequestState(message = message)
    class Loading: RequestState(message = null)
    class Idle: RequestState(message = null)

}
