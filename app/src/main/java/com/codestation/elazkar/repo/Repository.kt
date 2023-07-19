package com.codestation.elazkar.repo

import android.content.Context
import android.util.Log
import java.nio.charset.Charset

class Repository {

    //Read Data From Azkar Morning File
    fun getAzkarMorningJSONFromAssets(context: Context): String? {
        var json: String?
        val charset: Charset = Charsets.UTF_8
        try {
            val jsonFile = context.assets.open("Azkar_Morning.json")
            val size = jsonFile.available()
            val buffer = ByteArray(size)
            jsonFile.read(buffer)
            jsonFile.close()
            json = String(buffer, charset)
        } catch (e: Exception) {
            Log.d("morning fragment", e.message.toString())
            return null
        }
        return json
    }

    //Read Data From Azkar Evening File
    fun getAzkarEveningJSONFromAssets(context: Context): String? {
        var json: String?
        val charset: Charset = Charsets.UTF_8
        try {
            val jsonFile = context.assets.open("Azkar_Evening.json")
            val size = jsonFile.available()
            val buffer = ByteArray(size)
            jsonFile.read(buffer)
            jsonFile.close()
            json = String(buffer, charset)
        } catch (e: Exception) {
            Log.d("evening fragment", e.message.toString())
            return null
        }
        return json
    }
}