package com.rafa.retrofit

import com.google.gson.annotations.SerializedName

//reponsavel por criar atributos para mapear dados
class PostModel {
    @SerializedName("id") // setando atributos
    var id: Int = 0
    @SerializedName("userId")
    var userId: Int = 0
    @SerializedName("title")
    var title: String = ""
    @SerializedName("body")
    var body: String = ""
}