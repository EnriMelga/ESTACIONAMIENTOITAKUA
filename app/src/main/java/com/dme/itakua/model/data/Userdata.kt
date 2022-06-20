package com.dme.itakua.model.data

import com.google.gson.annotations.SerializedName

data class Userdata (

    @SerializedName("idusuario"       ) var idusuario      : Int?    = null,
    @SerializedName("username"        ) var username       : String? = null,
    @SerializedName("nombre_completo" ) var nombreCompleto : String? = null,
    @SerializedName("idtipousuario"   ) var idtipousuario  : Int?    = null,
    @SerializedName("tipousuario"     ) var tipousuario    : String? = null

)