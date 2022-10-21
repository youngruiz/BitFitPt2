package com.example.bitfit_pt1

import android.app.Application


class MyApplication : Application() {
    val db by lazy { AppDatabase.getInstance(this) }
}

