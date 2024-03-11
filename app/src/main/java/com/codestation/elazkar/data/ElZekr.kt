package com.codestation.elazkar.data

import com.google.gson.annotations.SerializedName
import org.json.JSONArray

data class ElZekr(
    @SerializedName("id")
    var id: Int,
    @SerializedName("alzekr")
    var alzekr: String,
    @SerializedName("numberOfRepetition")
    var numberOfRepetition: String,
    @SerializedName("counter")
    var counter: Int,

    )