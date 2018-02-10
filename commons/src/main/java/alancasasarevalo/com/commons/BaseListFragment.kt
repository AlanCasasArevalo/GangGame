package alancasasarevalo.com.commons

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import kotlinx.android.synthetic.main.fragment_list.view.*

abstract class BaseListFragment : GenericFragment(){

    val listAdapter: RecyclerView.Adapter<*>
        get() = getAdapter()

    override fun getLayoutResId(): Int {
        return R.layout.fragment_list
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /* Diferentes maneras de escribir lo mismo pero mas sucinto
        view?.base_list_fragment?.adapter = listAdapter
        view?.base_list_fragment?.layoutManager = LinearLayoutManager(context)
        *
        view?.base_list_fragment?.let {
            view.base_list_fragment.adapter = listAdapter
            view.base_list_fragment.layoutManager = LinearLayoutManager(context)
        }
        Es lo mismo que la parte de abajo
        * */

        view?.base_list_fragment?.let {
            with(view.base_list_fragment){
                adapter = listAdapter
                layoutManager = LinearLayoutManager(context)
            }
        }

    }

    abstract fun getAdapter() : RecyclerView.Adapter<*>
}
















