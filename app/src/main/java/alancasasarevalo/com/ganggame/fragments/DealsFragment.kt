package alancasasarevalo.com.ganggame.fragments

import alancasasarevalo.com.commons.databinding.DataBindingRecyclerAdapter
import alancasasarevalo.com.commons.fragments.BaseListFragment
import alancasasarevalo.com.ganggame.BR
import alancasasarevalo.com.ganggame.Models.Deal
import alancasasarevalo.com.ganggame.R
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.view.View

class DealsFragment  : BaseListFragment(){

    override fun getAdapter(): RecyclerView.Adapter<*> {
        val adapter = DataBindingRecyclerAdapter<Deal>(BR.deal, R.layout.item_deal)
        return adapter
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (listAdapter as DataBindingRecyclerAdapter<Deal>).items.addAll(getDummyDeals())
        listAdapter.notifyDataSetChanged()

    }

    fun getDummyDeals () : ArrayList<Deal>{

        var dummyArrayDeal = ArrayList<Deal>()

        (0..9).forEach { i ->
            val dummyDeal = Deal(
                    "Counter Strike",
                    0.99F,
                    9.99F,
                    80,
                    80,
                    "http://www.gamingesports.com/wp-content/uploads/2016/01/Counter-Strike-Global-Offensive1.jpg"
            )


            dummyArrayDeal.add(dummyDeal)
        }

        return dummyArrayDeal

    }

}