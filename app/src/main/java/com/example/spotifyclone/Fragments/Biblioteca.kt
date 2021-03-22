package com.example.spotifyclone.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.spotifyclone.FragmentsTab.Albuns
import com.example.spotifyclone.FragmentsTab.Artistas
import com.example.spotifyclone.FragmentsTab.Playlists
import com.example.spotifyclone.R
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems
import kotlinx.android.synthetic.main.fragment_biblioteca.*

class Biblioteca : Fragment() {

    companion object{
        fun newInstance(): Biblioteca{
            val fragmentHome = Biblioteca()
            val argumentos = Bundle()
            fragmentHome.arguments = argumentos
            return fragmentHome
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_biblioteca, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        var adapter = FragmentPagerItemAdapter(fragmentManager, FragmentPagerItems.with(context)

            .add("Playlists", Playlists::class.java)
            .add("Artistas", Artistas::class.java)
            .add("Álbuns", Albuns::class.java)
            .create())

            viewpager.adapter = adapter
            viewpagertab.setViewPager(viewpager)
    }

}