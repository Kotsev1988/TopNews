package com.example.topnews

import android.app.Application
import com.example.topnews.di.AppComponent
import com.example.topnews.di.AppModule
import com.example.topnews.di.DaggerAppComponent

class App: Application() {

    companion object{
        lateinit var instance: App
    }

     lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        instance = this


        appComponent = DaggerAppComponent
            .builder()
            .appModule(AppModule(this))
            .build()
    }

}