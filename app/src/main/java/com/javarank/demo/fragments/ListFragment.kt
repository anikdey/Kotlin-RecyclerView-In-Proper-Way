package com.javarank.demo.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.javarank.demo.R
import com.javarank.demo.adapter.ListAdapter
import com.javarank.demo.callback.OnItemClickListener
import com.javarank.demo.model.User

class ListFragment: Fragment() {

    protected lateinit var rootView: View
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: ListAdapter

    companion object {
        var TAG = ListFragment::class.java.simpleName
        const val ARG_POSITION: String = "positioin"

        fun newInstance(): ListFragment {
            var fragment = ListFragment();
            val args = Bundle()
            args.putInt(ARG_POSITION, 1)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        onCreateComponent()
    }

    private fun onCreateComponent() {
        adapter = ListAdapter()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater.inflate(R.layout.fragment_list, container, false);
        initView()
        return rootView
    }

    private fun initView(){
        setUpAdapter()
        initializeRecyclerView()
        setUpDummyData()
    }

    private fun setUpAdapter() {
        adapter.setOnItemClickListener(onItemClickListener = object : OnItemClickListener {
            override fun onItemClick(position: Int, view: View?) {
                Toast.makeText(view?.context, "Clicked On "+position, Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun initializeRecyclerView() {
        recyclerView = rootView.findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.adapter = adapter
    }

    private fun setUpDummyData(){
        var list: ArrayList<User> = ArrayList<User>()
        list.add(User("User 1", R.drawable.user))
        list.add(User("User 2", R.drawable.user))
        list.add(User("User 3", R.drawable.user))
        list.add(User("User 4", R.drawable.user))
        list.add(User("User 5", R.drawable.user))
        list.add(User("User 6", R.drawable.user))
        list.add(User("User 7", R.drawable.user))
        list.add(User("User 8", R.drawable.user))
        list.add(User("User 9", R.drawable.user))
        adapter.addItems(list)
    }
}