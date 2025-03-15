package com.example.controlador

import android.content.Context
import android.widget.ListView
import android.widget.Toast
import com.loopj.android.http.AsyncHttpClient
import com.loopj.android.http.AsyncHttpResponseHandler
import com.loopj.android.http.RequestParams
import cz.msebera.android.httpclient.Header
import cz.msebera.android.httpclient.entity.StringEntity
import org.json.JSONObject

class DProducto(val c:Context) {
    private var asyn:AsyncHttpClient = AsyncHttpClient()
    private var url:String = "http://192.168.18.4:8080/productos/"
    public val lst:ListView? = null

    public fun getList(bus:String){
        val jsonObject = JSONObject()
        //jsonObject.put("txtbus",bus);
        val entity: StringEntity = StringEntity(jsonObject.toString());
        asyn.get(c,url,entity,"application/json",object:AsyncHttpResponseHandler(){
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