package com.example.sixthmonth_2

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.sixthmonth_2.databinding.ItemUnselectedBinding

class SelectedAdapter(private var list: ArrayList<Sheep>) :
    Adapter<SelectedAdapter.SelectedViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SelectedViewHolder {
        return SelectedViewHolder(
            ItemUnselectedBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: SelectedViewHolder, position: Int) {
        holder.bind()
    }

    override fun getItemCount() = list.size

    inner class SelectedViewHolder(private var binding: ItemUnselectedBinding) :
        ViewHolder(binding.root) {
        fun bind() {
            val item = list[adapterPosition]
            binding.ivSheep.setImageResource(item.Image)

        }

    }
}