package com.example.controlador

import android.content.Context
import android.widget.ListView
import android.widget.Toast
import com.example.modelo.Producto
import com.example.util.ADPProducto
import com.loopj.android.http.AsyncHttpClient
import com.loopj.android.http.AsyncHttpResponseHandler
import com.loopj.android.http.RequestParams
import cz.msebera.android.httpclient.Header
import cz.msebera.android.httpclient.entity.StringEntity
import org.json.JSONArray
import org.json.JSONObject

class DProducto(val c:Context) {
    private var asyn:AsyncHttpClient = AsyncHttpClient()
    private var url:String = "http://172.56.0.238:8080/productos/"
    private var Array:ArrayList<Producto> = ArrayList()
    public var lst:ListView? = null


    public fun getList(bus:String){
        asyn.get(url,null,object:AsyncHttpResponseHandler(){
            override fun onSuccess(statusCode: Int,headers: Array<out Header>?,
                responseBody: ByteArray?) {
                val resp:String = java.lang.String(responseBody).toString()
                getJson(resp)
                lst!!.adapter = ADPProducto(c,Array)
            }
            override fun onFailure(statusCode: Int, headers: Array<out Header>?,
                responseBody: ByteArray?,error: Throwable?) {
                Toast.makeText(c,"Error:$error",Toast.LENGTH_LONG).show()
            }
        })
    }

    private fun getJson(dato:String){
        var json = JSONArray(dato)
        for (i in 0..json.length()-1) {
            val id = json.getJSONObject(i).getString("id")
            val nom = json.getJSONObject(i).getString("nom")
            val pre:Double = json.getJSONObject(i).getString("pre").toDouble()
            val rang:Int = json.getJSONObject(i).getString("rang").toInt()
            val img = json.getJSONObject(i).getString("img")
            var pro=Producto(id,nom,pre,rang,img)
            Array.add(pro)
        }
        //Toast.makeText(c,"Dato:"+r,Toast.LENGTH_LONG).show()
    }

    /*public fun getList(bus:String){
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
    }*/
}