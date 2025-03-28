package com.example.apkventas

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewpager2.widget.ViewPager2
import com.example.apkventas.menu.FragmePadre
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener

class MnMenu : AppCompatActivity() {
    private lateinit var tabPadre:TabLayout
    private lateinit var viewP:ViewPager2
    private lateinit var fragPadre:FragmePadre

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_mn_menu)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        tabPadre = findViewById(R.id.FrmMenu_TabLayout)
        viewP = findViewById(R.id.FrmMenu_ViewPage)
        fragPadre = FragmePadre(supportFragmentManager,
                    lifecycle,
                    tabPadre.tabCount)
        viewP.adapter = fragPadre
        tabPadre.addOnTabSelectedListener(object:OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                viewP.currentItem = tab!!.position?:0
            }
            override fun onTabUnselected(tab: TabLayout.Tab?) {}
            override fun onTabReselected(tab: TabLayout.Tab?) {}
        })

        viewP.registerOnPageChangeCallback(object:ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                tabPadre.getTabAt(position)?.select()
            }
        })
    }
}