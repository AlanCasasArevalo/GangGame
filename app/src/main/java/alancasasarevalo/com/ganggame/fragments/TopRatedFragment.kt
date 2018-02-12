package alancasasarevalo.com.ganggame.fragments

import alancasasarevalo.com.commons.databinding.DataBindingRecyclerAdapter
import alancasasarevalo.com.commons.fragments.BaseListFragment
import alancasasarevalo.com.ganggame.BR
import alancasasarevalo.com.ganggame.Models.TopGame
import alancasasarevalo.com.ganggame.R
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.view.View

class TopRatedFragment : BaseListFragment() {

    override fun getAdapter(): RecyclerView.Adapter<*> {
        return DataBindingRecyclerAdapter<TopGame>(BR.top, R.layout.item_top_game)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (listAdapter as DataBindingRecyclerAdapter<TopGame>).items.addAll(getDummyDeals())

        listAdapter.notifyDataSetChanged()

    }

    fun getDummyDeals(): ArrayList<TopGame> {

        var dummyArrayTopGames = ArrayList<TopGame>()

        (0..9).forEach { i ->
            val dummyTopGame = TopGame(
                    "Counter Strike",
                    14232323,
                    80,
                    "Valve",
                    40F,
                    2,
                    "http://www.gamingesports.com/wp-content/uploads/2016/01/Counter-Strike-Global-Offensive1.jpg"
            )

            dummyArrayTopGames.add(dummyTopGame)
        }


        return dummyArrayTopGames

    }

}