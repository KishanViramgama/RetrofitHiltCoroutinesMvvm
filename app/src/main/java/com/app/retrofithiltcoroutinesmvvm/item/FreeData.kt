package com.app.retrofithiltcoroutinesmvvm.item


import com.google.gson.annotations.SerializedName

data class FreeData(
    @SerializedName("dataseries")
    var dataseries: List<Datasery>? = null,
    @SerializedName("init")
    var `init`: String? = null,
    @SerializedName("product")
    var product: String? = null
)