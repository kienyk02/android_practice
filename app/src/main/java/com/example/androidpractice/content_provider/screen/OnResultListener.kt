package com.example.androidpractice.content_provider.screen

interface OnResultListener<T> {
    fun onSuccess(data: T)
    fun onError(error: String)
}