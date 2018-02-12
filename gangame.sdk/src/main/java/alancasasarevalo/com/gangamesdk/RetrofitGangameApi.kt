package alancasasarevalo.com.gangamesdk

import alancasasarevalo.com.gangamesdk.models.Deal
import alancasasarevalo.com.gangamesdk.models.TopGame
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitGangameApi {

    @GET(Routes.GET_DEALS)
    fun getDeals(): Call<ArrayList<Deal>>

    @GET(Routes.GET_DEALS)
    fun getTopRatedGames(): Call<ArrayList<TopGame>>

    @GET(Routes.GET_DEALS)
    fun getMostOwnedGames(): Call<ArrayList<TopGame>>

}