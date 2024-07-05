package com.example.androidpractice.muisicApp.screen.listSong.presenter

interface OnResultListener<T> {
    fun onSuccess(data: T)
    fun onError(error: String)
}