package com.javarank.demo.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.javarank.demo.R
import com.javarank.demo.base.BaseRecyclerViewAdapter
import com.javarank.demo.model.User
import kotlinx.android.synthetic.main.list_item.view.*

class ListAdapter: BaseRecyclerViewAdapter<User>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return MyViewHolder(LayoutInflater.from(parent?.context).inflate(R.layout.list_item, parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        var myHolder = holder as? MyViewHolder
        myHolder?.setUpView(user = getItem(position))
    }

    inner class MyViewHolder (view: View) : RecyclerView.ViewHolder(view), View.OnClickListener {

        private val imageView: ImageView = view.image_view
        private val textView: TextView = view.text_view

        init {
            view.setOnClickListener(this)
        }

        fun setUpView(user: User?) {
            user?.resId?.let { imageView.setImageResource(it) }
            textView.text = user?.name
        }

        override fun onClick(v: View?) {
            itemClickListener?.onItemClick(adapterPosition, v)
        }
    }
}