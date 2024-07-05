package com.example.androidpractice.muisicApp.data.repository

import com.example.androidpractice.muisicApp.data.dataSource.SongSource
import com.example.androidpractice.muisicApp.data.model.Song
import com.example.androidpractice.muisicApp.screen.listSong.presenter.OnResultListener

class SongRepositoryImpl(private val songSource: SongSource):SongRepository {
    override fun getSongs(listener: OnResultListener<List<Song>>) {
        songSource.getSongs(listener)
    }
}