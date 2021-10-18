package com.example.sampleocbccode.domain

import android.util.Log
import javax.inject.Inject

class EnglishPerson @Inject constructor() : Person {
    override fun speakLanguage() {
        Log.d("Tommy", "Hello")
    }
}