package com.example.gdsc_myapp

import com.google.gson.annotations.SerializedName

data class TemperModel(
    @SerializedName("avgTa")
    var avgTemper : Int,
    @SerializedName("minTa")
    var minTemper : Int,
    @SerializedName("maxTa")
    var maxTemper : Int
)
