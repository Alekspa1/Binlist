package com.drag0n.binlist.presentation.view.adapters

import androidx.recyclerview.widget.DiffUtil
import com.drag0n.binlist.domain.room.ItemHistoryDB


class DiffCallback: DiffUtil.ItemCallback<ItemHistoryDB>() {
    override fun areItemsTheSame(oldItem: ItemHistoryDB, newItem: ItemHistoryDB): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: ItemHistoryDB, newItem: ItemHistoryDB): Boolean {
        return oldItem == newItem
    }
}