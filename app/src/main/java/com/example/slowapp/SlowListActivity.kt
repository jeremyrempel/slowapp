package com.example.slowapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.trace
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import kotlin.random.Random

class SlowListActivity : AppCompatActivity(R.layout.activity_list) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val adapter = MyAdapter()
        val recycler = findViewById<RecyclerView>(R.id.recycler)
        recycler.adapter = adapter
        recycler.setHasFixedSize(true)

        val data = List(10000) { "#" + Random.nextInt() }
        adapter.submitList(data)
    }

    class MyAdapter : ListAdapter<String, MyViewHolder>(StringDiff) {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
            return MyViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.list_row, parent, false)
            )
        }

        override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
            holder.bind(getItem(position))
        }
    }

    object StringDiff : DiffUtil.ItemCallback<String>() {
        override fun areItemsTheSame(oldItem: String, newItem: String) = oldItem == newItem
        override fun areContentsTheSame(oldItem: String, newItem: String) = oldItem == newItem
    }

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val txtView = view.findViewById<TextView>(R.id.row)

        fun bind(txt: String) {
            txtView.text = txt

            // step 1
            // step 2

            trace("computeSomething") {
                computeSomething()
            }
        }

        private fun computeSomething() {
            Thread.sleep(10)
        }
    }
}