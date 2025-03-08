package com.example.apkventas

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MnLogin : AppCompatActivity() {
    private lateinit var txtusu:EditText
    private lateinit var txtpas:EditText
    private lateinit var btnacep:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_mn_login)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        txtusu = findViewById(R.id.FrmLog_txtusu)
        txtpas = findViewById(R.id.FrmLog_txtpas)
        btnacep = findViewById(R.id.FrmLog_btnacep)
        btnacep.setOnClickListener(View.OnClickListener {
            val usu:String = txtusu.text.toString()
            val pas = txtpas.text.toString()
            if(usu.equals("senati") && pas.equals("123"))
                startActivity(Intent(this,MnMenu::class.java))
            else
                Toast.makeText(this,"Error credencial",Toast.LENGTH_LONG).show()
        })
    }
}