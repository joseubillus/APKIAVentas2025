package com.example.apkventas.menu

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class FragmePadre(fragmentManager: FragmentManager, lifecycle: Lifecycle
                  ,private val numTab:Int) :
    FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount(): Int = numTab

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0->FragmeTabInicio()
            1->FragmeTabProd()
            2->FragmeTabUsuario()
            else-> null!!
        }
    }
}