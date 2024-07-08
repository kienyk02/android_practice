package com.example.androidpractice.music_app.data.repository

import com.example.androidpractice.music_app.data.model.Song
import com.example.androidpractice.music_app.screen.listSong.presenter.OnResultListener

interface SongRepository {
    fun getSongs(listener: OnResultListener<List<Song>>)
}