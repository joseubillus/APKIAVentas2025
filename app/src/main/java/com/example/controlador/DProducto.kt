package com.example.controlador

import android.content.Context
import android.widget.ListView
import android.widget.Toast
import com.loopj.android.http.AsyncHttpClient
import com.loopj.android.http.AsyncHttpResponseHandler
import com.loopj.android.http.RequestParams
import cz.msebera.android.httpclient.Header

class DProducto(val c:Context) {
    private var asyn:AsyncHttpClient = AsyncHttpClient()
    private var url:String = "https://pokeapi.co/api/v2/pokemon?limit=100000&offset=0"
    public val lst:ListView? = null

    public fun getList(bus:String){
        asyn.get(url,null,object:AsyncHttpResponseHandler(){
            override fun onSuccess(statusCode: Int,headers: Array<out Header>?,
                responseBody: ByteArray?) {
                val resp:String = java.lang.String(responseBody).toString()
                Toast.makeText(c,"Resp:"+resp,Toast.LENGTH_LONG).show()
            }
            override fun onFailure(statusCode: Int, headers: Array<out Header>?,
                responseBody: ByteArray?,error: Throwable?) {
                Toast.makeText(c,"Error:$error",Toast.LENGTH_LONG).show()
            }
        })
    }
}