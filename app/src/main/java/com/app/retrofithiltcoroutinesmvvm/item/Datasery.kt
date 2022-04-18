package com.app.retrofithiltcoroutinesmvvm.item


import com.google.gson.annotations.SerializedName

data class Datasery(
    @SerializedName("cloudcover")
    var cloudcover: Int? = null,
    @SerializedName("lifted_index")
    var liftedIndex: Int? = null,
    @SerializedName("prec_type")
    var precType: String? = null,
    @SerializedName("rh2m")
    var rh2m: Int? = null,
    @SerializedName("seeing")
    var seeing: Int? = null,
    @SerializedName("temp2m")
    var temp2m: Int? = null,
    @SerializedName("timepoint")
    var timepoint: Int? = null,
    @SerializedName("transparency")
    var transparency: Int? = null,
    @SerializedName("wind10m")
    var wind10m: Wind10m? = null
)