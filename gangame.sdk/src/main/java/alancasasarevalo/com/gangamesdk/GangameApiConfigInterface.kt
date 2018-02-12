package alancasasarevalo.com.gangamesdk

import retrofit2.Retrofit

interface GangameApiConfigInterface {
    fun setupConfiguration(builder: Retrofit.Builder)
}