package com.example.sampleocbccode.domain

import android.util.Log
import javax.inject.Inject

class SpanishPerson @Inject constructor() : Person {
    override fun speakLanguage() {
        Log.d("Tommy", "Despacito senor")
    }
}