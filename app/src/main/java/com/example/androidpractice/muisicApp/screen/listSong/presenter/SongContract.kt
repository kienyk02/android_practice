package com.example.androidpractice.muisicApp.screen.listSong.presenter

import com.example.androidpractice.muisicApp.data.model.Song

interface SongContract {
    interface Presenter{
        fun getSongs()
    }

    interface View{
        fun onGetSongsSuccess(songs: List<Song>)
        fun onError(error: String)
        fun startMusicService(song: Song)
        fun pauseMusicService(song: Song)
        fun changeSongService(song: Song)
    }

}