package com.example.spotifyclone.Model

class Categoria(
        var titulo: String = "",
        var albuns: MutableList<Album> = ArrayList()
)

class Album(
        var album: Int = 0
)