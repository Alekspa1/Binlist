package com.drag0n.binlist.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.drag0n.binlist.R
import com.drag0n.binlist.databinding.FragmentHistoryBinding
import com.drag0n.binlist.domain.room.RoomDB
import com.drag0n.binlist.presentation.view.adapters.HistoryAdapter
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HistoryFrag : Fragment() {
    private lateinit var binding: FragmentHistoryBinding
    @Inject
    lateinit var db: RoomDB



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHistoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val listdb = db.dao().getAll()
        val adapter = HistoryAdapter()
        binding.rcView.layoutManager = LinearLayoutManager(view.context)
        binding.rcView.adapter = adapter
        listdb.observe(viewLifecycleOwner){list->

        adapter.submitList(list)
        }

    }
}