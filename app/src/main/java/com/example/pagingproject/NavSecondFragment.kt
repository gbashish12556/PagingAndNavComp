package com.example.pagingproject


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

/**
 * A simple [Fragment] subclass.
 */
class NavSecondFragment : Fragment() {

    var recycleView: RecyclerView? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_nav_second, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recycleView = view.findViewById(R.id.recylerView)
        recycleView?.layoutManager  = LinearLayoutManager(activity)
        recycleView?.setHasFixedSize(true)

        var itemViewModel:ItemViewModel = ViewModelProviders.of(activity!!).get(ItemViewModel::class.java);
        var itemAdapter:ItemAdapter = ItemAdapter(activity);

        itemViewModel.itemPagedList.observe(activity!!, Observer {
            itemAdapter.submitList(it)
        })

        recycleView?.adapter = itemAdapter
    }

}
