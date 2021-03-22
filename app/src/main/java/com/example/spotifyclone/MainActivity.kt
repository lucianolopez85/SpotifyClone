package com.example.spotifyclone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import androidx.core.internal.view.SupportMenu
import androidx.core.internal.view.SupportMenuItem
import androidx.fragment.app.Fragment
import com.app.spotifyclone.Fragments.Buscar
import com.example.spotifyclone.Fragments.Biblioteca

import com.example.spotifyclone.Fragments.Home
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private var Content: FrameLayout? = null

    private var mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when(item.itemId){

            R.id.nav_inicio ->{
                val fragment = Home.newInstance()
                addFragment(fragment)
                return@OnNavigationItemSelectedListener true

            }

            R.id.nav_buscar ->{
                val fragment = Buscar.newInstance()
                addFragment(fragment)
                return@OnNavigationItemSelectedListener true
            }

            R.id.nav_biblioteca ->{
                val fragment = Biblioteca.newInstance()
                addFragment(fragment)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Content = content
        bottom_menu.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        val fragment = Home.newInstance()
        addFragment(fragment)
    }

    private fun addFragment(fragment: Fragment){
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.content,fragment,fragment.javaClass.simpleName)
            .commit()
    }
}