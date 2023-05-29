package com.example.sixthmonth_2

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.sixthmonth_2.databinding.ItemUnselectedBinding

class UnselectAdapter(
    private var arrayList: ArrayList<Sheep>,
    private val addImage: (sheep: Sheep) -> Unit,
    private val removeImage: (sheep: Sheep) -> Unit,
) : Adapter<UnselectAdapter.UneselectViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UneselectViewHolder {
        return UneselectViewHolder(
            ItemUnselectedBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: UneselectViewHolder, position: Int) {
        holder.bind(arrayList[position])
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    inner class UneselectViewHolder(private val binding: ItemUnselectedBinding) :
        ViewHolder(binding.root) {
        fun bind(sheep: Sheep) {

            binding.ivSheep.setImageResource(sheep.Image)

            itemView.setOnClickListener {
                sheep.isSelected = !sheep.isSelected

                if (sheep.isSelected) {
                    binding.ivSheep.alpha = 0.3f
                    addImage(sheep)
                }else{
                    removeImage(sheep)
                    binding.ivSheep.alpha = 1.0f
                }
            }

        }

    }

}


