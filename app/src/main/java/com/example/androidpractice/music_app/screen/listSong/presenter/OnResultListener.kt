package com.example.androidpractice.music_app.screen.listSong.presenter

interface OnResultListener<T> {
    fun onSuccess(data: T)
    fun onError(error: String)
}