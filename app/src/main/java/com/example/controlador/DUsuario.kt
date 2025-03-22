package com.example.controlador

import android.content.Context
import android.content.Intent
import android.widget.Toast
import com.example.apkventas.MnMenu
import com.example.apkventas.MnProducto
import com.example.util.Mensaje
import com.loopj.android.http.AsyncHttpClient
import com.loopj.android.http.AsyncHttpResponseHandler
import com.loopj.android.http.RequestParams
import com.loopj.android.http.ResponseHandlerInterface
import cz.msebera.android.httpclient.Header
import cz.msebera.android.httpclient.entity.StringEntity
import org.json.JSONObject

class DUsuario(val c:Context) {
    private var asyn:AsyncHttpClient = AsyncHttpClient()
    private var url:String  = "http://192.168.18.4:8080/login/"
    private var ms: Mensaje = Mensaje(c)

    fun getValidar(nom:String,pas:String):String {
        val jsonObject = JSONObject()
        jsonObject.put("id",0);
        jsonObject.put("nombre_usuario",nom);
        jsonObject.put("contrasena",pas);
        val entity = StringEntity(jsonObject.toString());

        asyn.post(c,url,entity,"application/json", object:AsyncHttpResponseHandler(){
            override fun onStart() {
                super.onStart()
                ms!!.MProgressBarDato()
            }

            override fun onSuccess(statusCode: Int, headers: Array<out Header>?,
                                   responseBody: ByteArray?) {
                ms.MCloseProgBar(true)
                val resp:String = java.lang.String(responseBody).toString()
                val auto = JSONObject(resp).getString("mensaje")
                if(auto.equals("Autorizado"))
                    c.startActivity(Intent(c, MnProducto::class.java))
                else Toast.makeText(c,"Resp:$auto",Toast.LENGTH_LONG).show()
            }

            override fun onFailure(statusCode: Int,headers: Array<out Header>?,
                responseBody: ByteArray?,error: Throwable?) {
                ms.MCloseProgBar(true)
                if(responseBody!=null) {
                    val responseString = String(responseBody) // Convertir el responseBody a String
                    val jsonResponse = JSONObject(responseString) // Convertir a JSON
                    val errorMessage = jsonResponse.optString("detail", "Error desconocido") // JSON detail'
                    Toast.makeText(c, "Error: $errorMessage", Toast.LENGTH_LONG).show()
                }else
                    Toast.makeText(c,"Error:$error",Toast.LENGTH_LONG).show()
            }
        })
        return "Autorizado"
    }


}