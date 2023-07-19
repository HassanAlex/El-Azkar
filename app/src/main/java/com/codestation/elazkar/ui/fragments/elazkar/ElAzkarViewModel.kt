package com.codestation.elazkar.ui.fragments.elazkar

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.codestation.elazkar.data.ElZekr
import com.codestation.elazkar.repo.Repository
import org.json.JSONException
import org.json.JSONObject

class ElAzkarViewModel(
    context: Context,
    repository: Repository
) : ViewModel() {


    // azkar Morning ArrayList-> normal ArrayList
    private val azkarMorningArrayList: ArrayList<ElZekr> = ArrayList()
    // azkar Evening ArrayList->   normal ArrayList
    private val azkarEveningArrayList: ArrayList<ElZekr> = ArrayList()


    // MutableLive data to set data in _azkar Morning Mutable List.
    private val _azkarMorningList: MutableLiveData<List<ElZekr>> = MutableLiveData<List<ElZekr>>()

    // MutableLive data to set data in _azkar Evening Mutable List.
    private val _azkarEveningList: MutableLiveData<List<ElZekr>> = MutableLiveData<List<ElZekr>>()


    //- azkar Morning live data list to observing and read data
    val azkarMorningList: LiveData<List<ElZekr>> = _azkarMorningList

    //- azkar Evening live data list to observing and read data
    val azkarEveningList: LiveData<List<ElZekr>> = _azkarEveningList


    //Set Data in Live Data
    init {
        // Azkar Morning
        try {
            val obj = JSONObject(repository.getAzkarMorningJSONFromAssets(context)!!)
            val azkarArray = obj.getJSONArray("data")

            for (i in 0 until azkarArray.length()) {
                val zeker = azkarArray.getJSONObject(i)
                val id = zeker.getInt("id")
                val alzekr = zeker.getString("alzekr")
                val numOfRepet = zeker.getString("numberOfRepetition")

                val elzekrDetails = ElZekr(id, alzekr, numOfRepet)
                //add details to the list
                azkarMorningArrayList.add(elzekrDetails)
            }
        }catch (e: JSONException){
            Log.d("morning fragment", e.message.toString())
        }
        // assgin normal array list to live data array list
        _azkarMorningList.value = azkarMorningArrayList


        // Azkar Evening
        try {
            val obj = JSONObject(repository.getAzkarEveningJSONFromAssets(context)!!)
            val azkarArray = obj.getJSONArray("data")

            for (i in 0 until azkarArray.length()) {
                val zeker = azkarArray.getJSONObject(i)
                val id = zeker.getInt("id")
                val alzekr = zeker.getString("alzekr")
                val numOfRepet = zeker.getString("numberOfRepetition")
                val elzekrDetails = ElZekr(id, alzekr, numOfRepet)
                //add details to the list
                azkarEveningArrayList.add(elzekrDetails)
            }

        } catch (e: JSONException) {
            Log.d("evening fragment", e.message.toString())
        }
        // assgin normal array list to live data array list
        _azkarEveningList.value = azkarEveningArrayList


    }

}