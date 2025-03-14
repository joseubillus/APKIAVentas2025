package com.example.apkventas

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.SearchView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.controlador.DProducto
import com.example.modelo.Producto
import com.example.util.ADPProducto

class MnProducto : AppCompatActivity() {
    private lateinit var lstpro:ListView
    private lateinit var schbus:SearchView
    private lateinit var dpro:DProducto

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_mn_producto)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        dpro = DProducto(this)
        dpro.getList("")

        /*schbus = findViewById(R.id.FrmProd_SchBus)
        lstpro = findViewById(R.id.FrmProd_LstProd)
        var adp = ADPProducto(this)
        for (i in 0..2000)
            adp.getAdd(Producto("PR00"+i, "Producto",12.45,3,null))
        lstpro.adapter = adp*/
    }
}