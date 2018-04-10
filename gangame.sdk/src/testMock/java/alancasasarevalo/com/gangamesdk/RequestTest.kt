package alancasasarevalo.com.gangamesdk

import com.google.gson.*
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertTrue
import org.json.JSONArray
import org.json.JSONObject
import org.junit.Test

class RequestTest {

    @Test
    fun deals_request_success() {
        val apiService = GangameApiService()
        val response = apiService.apiClient.getDeals().execute()
        val deals = response.body()

        val parser = JsonParser()

        val jsonResponse: JsonArray = parser.parse(MockResponses.DEALS_RESPONSE).asJsonArray

        assertTrue(response.isSuccessful)

//        if (deals != null){
//            assertEquals(4, deals?.count())
//        }

        deals?.let {
            assertEquals(jsonResponse.size(), deals.size)

            deals.zip(jsonResponse).forEach { (deal, jsonDeal) ->
                with(jsonDeal.asJsonObject) {
                    assertEquals(deal.title, this["title"].asString)
                    assertEquals(deal.metacriticScore, this["metacriticScore"].asInt)
                    assertEquals(deal.steamRating, this["steamRatingPercent"].asInt)
                    assertEquals(deal.thumb, this["thumb"].asString)
                }
            }

        }
    }

    @Test
    fun top_rated_request_success() {
        val apiService = GangameApiService()
        val response = apiService.apiClient.getTopRatedGames().execute()
        val topGames = response.body()

        val parser = JsonParser()

        val jsonResponse: List<JsonObject> = parser.parse(MockResponses.TOP_100_GAMES)
                .asJsonObject
                .entrySet()
                .map { (_, json)->
                    json.asJsonObject
                }

        assertTrue(response.isSuccessful)

        topGames?.let {
            assertEquals(jsonResponse.size, topGames.size)

            topGames.zip(jsonResponse).forEach { (topGame, jsonTopGame) ->
                with(jsonTopGame.asJsonObject) {
                    assertEquals(topGame.title, this["name"].asString)
                    assertEquals(topGame.steamRating, this["score_rank"].asInt)
                    assertEquals(topGame.publisher, this["publisher"].asString)
                    assertEquals(topGame.owners, this["owners"].asInt)
                    assertEquals(topGame.thumb, "http://cdn.akamai.steamstatic.com/steam/apps/${this["appid"].asInt}/capsule_184x69.jpg" )
                }
            }

        }
    }

}