package com.ehsankhormali.wac.authentication

object WacAuth {
    var currentUser:WacUser?=null
fun signInWithEmailAndPassword( email:String, password:String):AuthResult {
    return AuthResult()
}
    fun getInstance():WacAuth{
        return this
    }


}
