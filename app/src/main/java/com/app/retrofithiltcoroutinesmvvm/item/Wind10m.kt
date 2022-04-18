package com.app.retrofithiltcoroutinesmvvm.item


import com.google.gson.annotations.SerializedName

data class Wind10m(
    @SerializedName("direction")
    var direction: String? = null,
    @SerializedName("speed")
    var speed: Int? = null
)