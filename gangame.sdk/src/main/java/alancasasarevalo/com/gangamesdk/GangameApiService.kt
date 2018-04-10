package alancasasarevalo.com.gangamesdk

import alancasasarevalo.com.gangamesdk.models.TopGame
import alancasasarevalo.com.gangamesdk.serializer.ListTopGameDeserializer
import alancasasarevalo.com.gangamesdk.serializer.TopGameDeserializer
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class GangameApiService (val apiConfig: GangameApiConfigInterface = GangameApiClientConfiguration()) {

    val apiClient : RetrofitGangameApi

    init {

        val tokenType = object : TypeToken<ArrayList<TopGame>>(){}.type
        val gson = GsonBuilder()
                .registerTypeAdapter(TopGame::class.java, TopGameDeserializer())
                .registerTypeAdapter(tokenType, ListTopGameDeserializer()).create()

        val apiClientConfig = Retrofit.Builder()
                .baseUrl(Routes.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))


        apiConfig.setupConfiguration(apiClientConfig)
        apiClient = apiClientConfig.build().create(RetrofitGangameApi::class.java)

    }
}