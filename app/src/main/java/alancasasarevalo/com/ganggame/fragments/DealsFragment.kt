package alancasasarevalo.com.ganggame.fragments

import alancasasarevalo.com.commons.databinding.DataBindingRecyclerAdapter
import alancasasarevalo.com.commons.fragments.BaseListFragment
import alancasasarevalo.com.ganggame.BR
import alancasasarevalo.com.ganggame.Models.Deal
import alancasasarevalo.com.ganggame.R
import alancasasarevalo.com.ganggame.data.GangGameDataSource
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.widget.RecyclerView
import android.view.View
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import org.reactivestreams.Subscriber
import org.reactivestreams.Subscription

class DealsFragment  : BaseListFragment(){

    override fun getAdapter(): RecyclerView.Adapter<*> {
        val adapter = DataBindingRecyclerAdapter<Deal>(BR.deal, R.layout.item_deal)
        return adapter
    }

    override fun onResume() {
        super.onResume()
        showDeals()
    }

    private fun showDeals(){
        GangGameDataSource
                .getDeals()
                .subscribe({ listDeal ->
                    replaceItems(listDeal)
                },{ error ->
                    showError(error)
                })
    }

    private fun showError(error: Throwable) {
        view.let {
            Snackbar.make(view as View, R.string.error_request, Snackbar.LENGTH_LONG)
                    .setAction(R.string.label_retry, {view: View -> showDeals() })
                    .show()
        }
    }

    private fun replaceItems (listItem: List<Deal>) {
        with(listAdapter as DataBindingRecyclerAdapter<Deal>){
            items.clear()
            items.addAll(listItem)
            notifyDataSetChanged()
        }
    }


    //      Esto es si quieres TODO
//    private fun showDeals() {
//        GangGameDataSource
//                .getDeals()
//                .subscribe(object : Observer<ArrayList<Deal>>{
//                    override fun onComplete() {
//                        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//                    }
//
//                    override fun onSubscribe(d: Disposable?) {
//                        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//                    }
//
//                    override fun onNext(t: ArrayList<Deal>?) {
//                        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//                    }
//
//                    override fun onError(e: Throwable?) {
//                        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//                    }
//
//                })
//    }
//


//    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//        (listAdapter as DataBindingRecyclerAdapter<Deal>).items.addAll(getDummyDeals())
//        listAdapter.notifyDataSetChanged()
//
//    }
//
//    fun getDummyDeals () : ArrayList<Deal>{
//
//        var dummyArrayDeal = ArrayList<Deal>()
//
//        (0..9).forEach { i ->
//            val dummyDeal = Deal(
//                    "Counter Strike",
//                    0.99F,
//                    9.99F,
//                    80,
//                    80,
//                    "http://www.gamingesports.com/wp-content/uploads/2016/01/Counter-Strike-Global-Offensive1.jpg"
//            )
//
//
//            dummyArrayDeal.add(dummyDeal)
//        }
//
//        return dummyArrayDeal
//
//    }

}