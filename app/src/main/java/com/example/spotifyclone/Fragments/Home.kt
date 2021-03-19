package com.example.spotifyclone.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.spotifyclone.Model.Album
import com.example.spotifyclone.Model.Categoria
import com.example.spotifyclone.R
import kotlinx.android.synthetic.main.album_item.view.*
import kotlinx.android.synthetic.main.categoria_item.view.*
import kotlinx.android.synthetic.main.fragment_home.*

class Home : Fragment() {

    private lateinit var categoriaAdapter: CategoriaAdapter

    companion object {
        fun newInstance(): Home {
            val fragmentHome = Home()
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
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val categorias: MutableList<Categoria> = ArrayList()
        for (c in 0..4) {
            val categoria = Categoria()
            categoria.titulo = "Categoria$c"

            val albuns: MutableList<Album> = ArrayList()
            for(a in 0..19){
                val album = Album()
                album.album = R.drawable.spotify
                albuns.add(album)
            }
            categoria.albuns = albuns
            categorias.add(categoria)
        }

        categoriaAdapter = CategoriaAdapter(categorias)
        recycler_view_categoria.adapter = categoriaAdapter
        recycler_view_categoria.layoutManager = LinearLayoutManager(context)

    }

    private inner class CategoriaAdapter(internal val categorias: MutableList<Categoria>) : RecyclerView.Adapter<CategoriaHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriaHolder {
            return CategoriaHolder(layoutInflater.inflate(R.layout.categoria_item, parent, false))
        }

        override fun getItemCount(): Int = categorias.size


        override fun onBindViewHolder(holder: CategoriaHolder, position: Int) {

            val categoria = categorias[position]
            holder.bind(categoria)
        }
    }

    private inner class CategoriaHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(categoria: Categoria) {
            itemView.text_titulo_categoria.text = categoria.titulo
            itemView.recycler_listagem_albuns.adapter = AlbunsAdapter(categoria.albuns)
            itemView.recycler_listagem_albuns.layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)

        }
    }




    //========================= Albuns Horizontal ================================

    private inner class AlbunsAdapter(private val albuns: MutableList<Album>): RecyclerView.Adapter<AlbunsHolder>() {


        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbunsHolder {
            return AlbunsHolder(layoutInflater.inflate(R.layout.album_item, parent, false))
        }

        override fun onBindViewHolder(holder: AlbunsHolder, position: Int) {
            val album = albuns[position]
            holder.bind(album)
        }

        override fun getItemCount(): Int = albuns.size

        }
    }

    private class AlbunsHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bind(album: Album){
            itemView.image_album.setImageResource(album.album)
    }
}
