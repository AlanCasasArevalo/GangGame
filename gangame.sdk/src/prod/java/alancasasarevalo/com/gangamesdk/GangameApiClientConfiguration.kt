
package alancasasarevalo.com.gangamesdk

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit

class GangameApiClientConfiguration : GangameApiConfigInterface {
    override fun setupConfiguration(builder: Retrofit.Builder){
        val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .build()

        builder.client(okHttpClient)
    }
}