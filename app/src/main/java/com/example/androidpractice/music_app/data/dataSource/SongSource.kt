package com.example.androidpractice.music_app.data.dataSource

import com.example.androidpractice.music_app.data.model.Song
import com.example.androidpractice.music_app.screen.listSong.presenter.OnResultListener

interface SongSource {
    fun getSongs(listener: OnResultListener<List<Song>>)
}