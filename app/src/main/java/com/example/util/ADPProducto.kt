package com.example.util

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.apkventas.R
import com.example.modelo.Producto
import java.util.ArrayList

class ADPProducto:BaseAdapter {
    private var BD:ArrayList<Producto> = ArrayList()
    private var ct:Context? = null

    constructor(c:Context){
        this.ct = c
    }
    constructor(c:Context, data:ArrayList<Producto>){
        this.ct = c
        this.BD = data
    }

    fun getAdd(obj:Producto){
        BD.add(obj)
    }
    override fun getCount(): Int {
        return BD.size
    }

    override fun getItem(p0: Int): Producto {
        return BD.get(p0)
    }

    override fun getItemId(p0: Int): Long {
        return BD.get(p0).hashCode().toLong()
    }

    override fun getView(pos: Int, p1: View?, p2: ViewGroup?): View {
        var root:View? = p1
        if(p1==null){
            root = LayoutInflater.from(ct).inflate(R.layout.config_prod,p2,false)
        }

        val id:TextView = root!!.findViewById(R.id.FrmConfProd_Lblid)
        val nom:TextView = root.findViewById(R.id.FrmConfProd_Lblnom)
        val pre:TextView = root.findViewById(R.id.FrmConfProd_Lblpre)

        val pro = getItem(pos)
        id.text = pro.getId
        nom.text = pro.getNom
        pre.text = pro.getPre.toString()

        return root
    }
}