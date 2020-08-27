package com.example.tiktokclone

import android.content.Context
import android.widget.Toast

fun Context.show(message: String, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, message, duration).show()
}