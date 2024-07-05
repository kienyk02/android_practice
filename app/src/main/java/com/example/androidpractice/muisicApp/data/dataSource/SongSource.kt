package com.example.androidpractice.muisicApp.data.dataSource

import com.example.androidpractice.muisicApp.data.model.Song
import com.example.androidpractice.muisicApp.screen.listSong.presenter.OnResultListener

interface SongSource {
    fun getSongs(listener: OnResultListener<List<Song>>)
}