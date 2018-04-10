package alancasasarevalo.com.gangamesdk.serializer

import alancasasarevalo.com.gangamesdk.models.TopGame
import com.google.gson.*
import java.lang.reflect.Type

class ListTopGameDeserializer : JsonDeserializer<ArrayList<TopGame>>{
    override fun deserialize(json: JsonElement, typeOfT: Type?, context: JsonDeserializationContext?): ArrayList<TopGame> {
        val jsonTopGames = json.asJsonObject
                .entrySet()
                .map {(key, json) ->
                    json.asJsonObject
                }

        val gson = GsonBuilder().registerTypeAdapter(TopGame::class.java, TopGameDeserializer()).create()

        val topGames: List<TopGame> = jsonTopGames.map {json ->
                            gson.fromJson(json, TopGame::class.java)
                        }

        val arrayListTopGame: ArrayList<TopGame> = arrayListOf()

        arrayListTopGame.addAll(topGames)

        return arrayListTopGame
    }
}