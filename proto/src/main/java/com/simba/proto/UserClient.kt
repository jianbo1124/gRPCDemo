package com.simba.proto

import android.util.Log
import io.grpc.ManagedChannel
import proto.EmployeeServiceGrpcKt
import proto.requestLoginParams

/**
 *    @Author : Ｃｏｏｋ
 *    @Date   : 2024/8/7
 *    @Desc   :
 *    @Version:
 */
class UserClient(channel: ManagedChannel) {

    private val stub: EmployeeServiceGrpcKt.EmployeeServiceCoroutineStub =
        EmployeeServiceGrpcKt.EmployeeServiceCoroutineStub(channel)

    suspend fun login(email: String, pwd: String) {
        val params = requestLoginParams {
            this.name = email
            this.password = pwd
        }
        val response = stub.login(params)
        Log.e("UserClient","Received: ${response.data}")
        Log.e("UserClient","Received: ${response.data.bio}")
    }


}