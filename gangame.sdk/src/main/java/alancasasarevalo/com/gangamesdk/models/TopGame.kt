package alancasasarevalo.com.gangamesdk.models

import com.google.gson.annotations.SerializedName

data class TopGame(@SerializedName("name") var title: String,
                   var publisher: String,
                   @SerializedName("score_rank") var steamRating: Int,
                   var owners: Int,
                   var price: Float,
                   var thumb: String
)