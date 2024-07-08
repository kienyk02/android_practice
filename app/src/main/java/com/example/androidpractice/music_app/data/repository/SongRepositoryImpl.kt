package com.example.androidpractice.music_app.data.repository

import com.example.androidpractice.music_app.data.dataSource.SongSource
import com.example.androidpractice.music_app.data.model.Song
import com.example.androidpractice.music_app.screen.listSong.presenter.OnResultListener

class SongRepositoryImpl(private val songSource: SongSource):SongRepository {
    override fun getSongs(listener: OnResultListener<List<Song>>) {
        songSource.getSongs(listener)
    }
}