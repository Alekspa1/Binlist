package com.drag0n.binlist.presentation.view.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

import com.drag0n.binlist.presentation.view.HistoryFrag
import com.drag0n.binlist.presentation.view.SearchBinFrag

private val listFrag = listOf(SearchBinFrag(), HistoryFrag())
class VpAdapter(fragment: FragmentActivity): FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int {
        return listFrag.size
    }

    override fun createFragment(position: Int): Fragment {
        return listFrag[position]
    }
}