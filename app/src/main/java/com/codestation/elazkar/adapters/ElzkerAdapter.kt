package com.codestation.elazkar.adapters

import android.content.res.ColorStateList
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.graphics.toColorInt
import androidx.recyclerview.widget.RecyclerView
import com.codestation.elazkar.R
import com.codestation.elazkar.data.ElZekr
import com.codestation.elazkar.databinding.ElzekrItemBinding

class ElzkerAdapter(
    val items: List<ElZekr>
) : RecyclerView.Adapter<ElzkerAdapter.ElzekrViewHolder>() {

    inner class ElzekrViewHolder(val binding: ElzekrItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ElzekrViewHolder {
        val binding = ElzekrItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ElzekrViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ElzekrViewHolder, position: Int) {
        val elzekr = items[position]
        holder.binding.tvElzekr.text = elzekr.alzekr
        holder.binding.tvNumberOfRepetition.text = elzekr.numberOfRepetition
        var counter = elzekr.counter // store current value
        val done = "تم بحمد الله"

        holder.itemView.setOnClickListener {
            if (counter in 1..100) {
                counter--
                holder.binding.tvNumberOfRepetition.text = counter.toString()
                if (counter == 0){
                    holder.binding.tvNumberOfRepetition.text = done
                    holder.binding.tvNumberOfRepetition.setTextColor(Color.GREEN)

                }
            }

        }
    }

    override fun getItemCount() = items.size
}