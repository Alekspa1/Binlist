package com.drag0n.binlist.presentation.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.drag0n.binlist.databinding.ItemBinBinding
import com.drag0n.binlist.domain.room.ItemHistoryDB

class HistoryAdapter: ListAdapter<ItemHistoryDB, HistoryAdapter.ViewHolder>(DiffCallback()) {
    class ViewHolder(private val binding: ItemBinBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(item: ItemHistoryDB){
        with(binding){
            itemTvBin.text = item.bin
            itemTvCountry.text = item.country
            itemTvLoc.text = item.location
            itemTvCardType.text = item.cardType
            itemTvUrlBank.text = item.url
            itemTvPhone.text = item.phone
            itemTvCity.text = item.city
        }
    }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemBinBinding.inflate(LayoutInflater.from(parent.context),
            parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}