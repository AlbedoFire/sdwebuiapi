package org.sdwebuiapi

import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import okio.IOException
import java.util.concurrent.TimeUnit

class Requests {
    val client = OkHttpClient.Builder().readTimeout(300,TimeUnit.SECONDS).build()

    fun post(url:String,json:String): String {
        val requestBody = json.toRequestBody("application/json; charset=utf-8".toMediaTypeOrNull())
        var request = Request.Builder()
                .url(url)
                .post(requestBody)
                .build()
        try {
            val respone = client.newCall(request).execute()
            if (respone.isSuccessful){
                val stringData = respone.body?.string() ?: return ""
                return stringData
            }

        }catch (e :IOException){
           println(e.toString())
        }
        return ""
    }
    fun post(url: String):String{
        var request = Request.Builder()
                .url(url)
                .build()
        try {
            val respone = client.newCall(request).execute()
            if (respone.isSuccessful){
                val stringData = respone.body?.string() ?: return ""
                return stringData
            }
            return ""

        }catch (e :IOException){
            println(e.toString())
        }
        return ""
    }

    fun _get(url: String,json: String): String? {
        var request = Request.Builder()
                .url(url)
                .build()
        try {
            var respone = client.newCall(request).execute()
            if (respone.isSuccessful){
                val stringData = respone.body?.string()
                return stringData
            }

        }catch (e :IOException){
            println(e.toString())
        }
        return ""
    }

}