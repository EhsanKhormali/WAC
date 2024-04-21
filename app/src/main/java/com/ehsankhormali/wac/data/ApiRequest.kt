package com.ehsankhormali.wac.data

import java.util.concurrent.Flow

class ApiRequest<T>(
     var data: T?,
     var state: RequestState){

}
