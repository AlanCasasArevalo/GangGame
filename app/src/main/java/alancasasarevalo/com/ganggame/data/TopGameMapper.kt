package alancasasarevalo.com.ganggame.data

import alancasasarevalo.com.ganggame.Models.TopGame

object TopGameMapper {

    fun fromSDKModelToAppTopGame(topGame: alancasasarevalo.com.gangamesdk.models.TopGame, position:Int): alancasasarevalo.com.ganggame.Models.TopGame {
        return TopGame(
                topGame.title,
                topGame.owners,
                topGame.steamRating,
                topGame.publisher,
                topGame.price,
                position,
                topGame.thumb
        )
    }

}