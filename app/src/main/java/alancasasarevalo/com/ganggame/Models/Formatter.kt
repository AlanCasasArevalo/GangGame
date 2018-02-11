package alancasasarevalo.com.ganggame.Models

object Formatter{
    val FORMAT_PRICE = "%.2f"

    fun pricePriceFormatted(price: Float) = String.format(FORMAT_PRICE, price)

}