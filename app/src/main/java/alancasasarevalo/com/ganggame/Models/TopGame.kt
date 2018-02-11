package alancasasarevalo.com.ganggame.Models

data class TopGame (var title:String,
                    var owners: Int,
                    var steamRating: Int,
                    var publisher: String,
                    var price: Float,
                    var position: Int,
                    var thumb: String){

    val priceFormatted : String
        get() = Formatter.pricePriceFormatted(price)

}

