package com.simba.proto

import android.content.Context
import io.grpc.android.AndroidChannelBuilder

/**
 *    @Author : Ｃｏｏｋ
 *    @Date   : 2024/8/7
 *    @Desc   :
 *    @Version:
 */
object GRPCUtils {

    private const val URL = ""
    private const val PORT = 80


    suspend fun login(cxt: Context, email: String, pwd: String) {
        val androidChannel = AndroidChannelBuilder
            .forAddress(URL, PORT)
            .context(cxt)
            .usePlaintext()
            .build()
        val client = UserClient(androidChannel)
        client.login(email, pwd)

    }


}