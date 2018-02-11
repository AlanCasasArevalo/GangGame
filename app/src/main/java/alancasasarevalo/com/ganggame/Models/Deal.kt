package alancasasarevalo.com.ganggame.Models

data class Deal(var title: String,
                var salePrice: Float,
                var normalPrice: Float,
                var metacriticScore: Int,
                var steamRating: Int,
                var thumb: String) {

    val salePriceFormatted: String
        get() = Formatter.pricePriceFormatted(salePrice)
    val normalPriceFormatted: String
        get() = Formatter.pricePriceFormatted(normalPrice)
}

