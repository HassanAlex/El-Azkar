//package com.codestation.elazkar.ui.fragments.elazkar
//
//import android.app.Application
//import android.util.Log
//import androidx.lifecycle.AndroidViewModel
//import androidx.lifecycle.LiveData
//import androidx.lifecycle.MutableLiveData
//import com.codestation.elazkar.data.ElZekr
//import com.codestation.elazkar.repo.Repository
//import org.json.JSONException
//import org.json.JSONObject
//
//class MorningAzkarViewModel(
//    app: Application,
//    repository: Repository
//) : AndroidViewModel(app) {
//
//    // azkarArrayList  normal ArrayList
//    private val azkarArrayList: ArrayList<ElZekr> = ArrayList()
//
//    // MutableLive data to set data and use it in logic
//    private val _azkarMorningList: MutableLiveData<List<ElZekr>> = MutableLiveData<List<ElZekr>>()
//
//    //- live data to observing and read data
//    val azkarMorningList: LiveData<List<ElZekr>> = _azkarMorningList
//
//
//
//    init {
//        try {
//            val obj = JSONObject(repository.getAzkarMorningJSONFromAssets(app.applicationContext)!!)
//            val azkarArray = obj.getJSONArray("data")
//
//            for (i in 0 until azkarArray.length()) {
//                val zeker = azkarArray.getJSONObject(i)
//                val id = zeker.getInt("id")
//                val alzekr = zeker.getString("alzekr")
//                val numOfRepet = zeker.getString("numberOfRepetition")
//
//                val elzekrDetails = ElZekr(id, alzekr, numOfRepet)
//                //add details to the list
//                azkarArrayList.add(elzekrDetails)
//            }
//
//        } catch (e: JSONException) {
//            Log.d("morning fragment", e.message.toString())
//        }
//        // assgin normal array list to live data array list
//        _azkarMorningList.value = azkarArrayList
//    }
//
//
//}