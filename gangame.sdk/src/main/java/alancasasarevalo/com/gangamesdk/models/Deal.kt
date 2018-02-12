package alancasasarevalo.com.gangamesdk.models

import com.google.gson.annotations.SerializedName

data class Deal(var title: String,
                var salePrice: Float,
                var normalPrice: Float,
                var metacriticScore: Int,
                @SerializedName("steamRatingPercent") var steamRating: Int,
                var thumb: String
)


