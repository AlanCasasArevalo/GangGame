package alancasasarevalo.com.ganggame.fragments

import alancasasarevalo.com.commons.databinding.DataBindingRecyclerAdapter
import alancasasarevalo.com.commons.fragments.BaseListFragment
import alancasasarevalo.com.ganggame.BR
import alancasasarevalo.com.ganggame.Models.Deal
import alancasasarevalo.com.ganggame.Models.TopGame
import alancasasarevalo.com.ganggame.R
import alancasasarevalo.com.ganggame.data.GangGameDataSource
import android.support.design.widget.Snackbar
import android.support.v7.widget.RecyclerView
import android.view.View

class TopOwnedFragment : BaseListFragment() {
    override fun getAdapter(): RecyclerView.Adapter<*> {
        return DataBindingRecyclerAdapter<TopGame>(BR.top, R.layout.item_top_game)
    }

    override fun onResume() {
        super.onResume()
        showOwned()
    }

    private fun showOwned(){
        GangGameDataSource
                .getMostOwned()
                .subscribe({ listOwned ->
                    replaceItems(listOwned)
                },{ error ->
                    showError(error)
                })
    }

    private fun showError(error: Throwable) {
        view.let {
            Snackbar.make(view as View, R.string.error_request, Snackbar.LENGTH_LONG)
                    .setAction(R.string.label_retry, {view: View -> showOwned() })
                    .show()
        }
    }

    private fun replaceItems (listItem: List<TopGame>) {
        with(listAdapter as DataBindingRecyclerAdapter<TopGame>){
            items.clear()
            items.addAll(listItem)
            notifyDataSetChanged()
        }
    }
}