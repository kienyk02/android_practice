package com.example.androidpractice.muisicApp.data.repository

import com.example.androidpractice.muisicApp.data.model.Song
import com.example.androidpractice.muisicApp.screen.listSong.presenter.OnResultListener

interface SongRepository {
    fun getSongs(listener: OnResultListener<List<Song>>)
}