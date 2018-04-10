package alancasasarevalo.com.ganggame.data

import alancasasarevalo.com.ganggame.Models.Deal

object DealMapper {


    fun fromSDKModelToAppDeal(deal: alancasasarevalo.com.gangamesdk.models.Deal): alancasasarevalo.com.ganggame.Models.Deal {
        return Deal(
                deal.title,
                deal.salePrice,
                deal.normalPrice,
                deal.metacriticScore,
                deal.steamRating,
                deal.thumb
        )
    }

}