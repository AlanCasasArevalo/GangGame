package alancasasarevalo.com.ganggame.data

import alancasasarevalo.com.gangamesdk.GangameApiService
import alancasasarevalo.com.ganggame.Models.Deal
import alancasasarevalo.com.ganggame.Models.TopGame
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


object GangGameDataSource {

    val apiService = GangameApiService()


    fun getDeals() : Observable<ArrayList<Deal>> {
        return apiService.apiClient
                .getObservableDeals()
                .map { listDeal ->
                    val deals = listDeal.map {deal ->
                        DealMapper.fromSDKModelToAppDeal(deal)
                    }
                    val arrayList = arrayListOf<Deal>()
                    arrayList.addAll(deals)
                    arrayList
                }
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())

    }

    fun getTopRated() : Observable<ArrayList<TopGame>> {
        return apiService.apiClient
                .getObservableTopRatedGames()
                .map {listGames ->
                    val games = listGames.mapIndexed { index, topGame ->
                        TopGameMapper.fromSDKModelToAppTopGame(topGame, (index + 1))
                    }

                    val arrayList = arrayListOf<TopGame>()
                    arrayList.addAll(games)
                    arrayList
                }.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())

    }

    fun getMostOwned() : Observable<ArrayList<TopGame>> {
        return apiService.apiClient
                .getObservableMostOwnedGames()
                .map {listGames ->
                    val games = listGames.mapIndexed { index, topGame ->
                        TopGameMapper.fromSDKModelToAppTopGame(topGame, (index + 1))
                    }

                    val arrayList = arrayListOf<TopGame>()
                    arrayList.addAll(games)
                    arrayList
                }.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())

    }

}

















