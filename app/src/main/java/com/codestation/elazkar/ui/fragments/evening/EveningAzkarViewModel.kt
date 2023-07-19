package com.codestation.elazkar.ui.fragments.evening

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.codestation.elazkar.data.ElZekr
import org.json.JSONException
import org.json.JSONObject
import java.nio.charset.Charset

class EveningAzkarViewModel(
    app: Application
) : AndroidViewModel(app) {

    private val azkarArrayList: ArrayList<ElZekr> = ArrayList()

    private val _azkarEveningList: MutableLiveData<List<ElZekr>> = MutableLiveData<List<ElZekr>>()

    val azkarEveningList: LiveData<List<ElZekr>> = _azkarEveningList


    private fun getAzkarEveningJSONFromAssets(context: Context): String? {
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

    init {
        try {
            val obj = JSONObject(getAzkarEveningJSONFromAssets(app.applicationContext)!!)
            val azkarArray = obj.getJSONArray("data")

            for (i in 0 until azkarArray.length()) {
                val zeker = azkarArray.getJSONObject(i)
                val id = zeker.getInt("id")
                val alzekr = zeker.getString("alzekr")
                val numOfRepet = zeker.getString("numberOfRepetition")

                val elzekrDetails = ElZekr(id, alzekr, numOfRepet)
                azkarArrayList.add(elzekrDetails)
            }

        } catch (e: JSONException) {
        }
        _azkarEveningList.value = azkarArrayList

    }

}