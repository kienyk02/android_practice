package com.example.androidpractice.music_app.screen.listSong.presenter

import com.example.androidpractice.music_app.data.model.Song

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