package com.example.controlador

import android.content.Context
import android.widget.Toast
import com.loopj.android.http.AsyncHttpClient
import com.loopj.android.http.AsyncHttpResponseHandler
import com.loopj.android.http.RequestParams
import com.loopj.android.http.ResponseHandlerInterface
import cz.msebera.android.httpclient.Header
import cz.msebera.android.httpclient.entity.StringEntity
import org.json.JSONObject

class DUsuario(val c:Context) {
    private var asyn:AsyncHttpClient = AsyncHttpClient()
    private var url:String  = "http://172.56.0.238:8080/login/"

    fun getValidar(nom:String,pas:String):String {
        /*var para:RequestParams = RequestParams()
        para.add("id","0")
        para.add("nombre_usuario",nom)
        para.add("contrasena",pas)*/

        val jsonObject = JSONObject()
        jsonObject.put("id",0);
        jsonObject.put("nombre_usuario",nom.toString());
        jsonObject.put("contrasena",pas.toString());
        val entity: StringEntity = StringEntity(jsonObject.toString());

        asyn.post(c,url,entity,"application/json", object:AsyncHttpResponseHandler(){
        //asyn.get(c,url,entity,"application/json", object:AsyncHttpResponseHandler(){
            override fun onSuccess(statusCode: Int,headers: Array<out Header>?,
                responseBody: ByteArray?) {
                var resp = java.lang.String(responseBody).toString()
                Toast.makeText(c,"Resp:$resp",Toast.LENGTH_LONG).show()
            }

            override fun onFailure(statusCode: Int,headers: Array<out Header>?,
                responseBody: ByteArray?,error: Throwable?) {
                Toast.makeText(c,"Error:$error",Toast.LENGTH_LONG).show()
            }
        })
        return "Autorizado"
    }


}