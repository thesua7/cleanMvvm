package com.thesua7.cleanmvvm.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.thesua7.cleanmvvm.databinding.ItemCardBinding
import com.thesua7.cleanmvvm.domain.model.RickMortyModel

class RickMortyAdapter : RecyclerView.Adapter<RickMortyAdapter.viewHolder>() {
    inner class viewHolder(val binding: ItemCardBinding) : RecyclerView.ViewHolder(binding.root)

    private val differCallback = object : DiffUtil.ItemCallback<RickMortyModel>() {
        override fun areItemsTheSame(oldItem: RickMortyModel, newItem: RickMortyModel): Boolean =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: RickMortyModel, newItem: RickMortyModel): Boolean =
            oldItem == newItem

    }

    private val differ = AsyncListDiffer(this, differCallback)
    fun submitList(list: List<RickMortyModel>) = differ.submitList(list)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder = viewHolder(
        ItemCardBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    override fun getItemCount() = differ.currentList.size

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        val item = differ.currentList[position]
        holder.binding.apply {
            imageView.load(item.image)
            textView.text = item.name
        }
    }
}