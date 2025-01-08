package com.drag0n.binlist.presentation.view

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.drag0n.binlist.databinding.ActivityMainBinding
import com.drag0n.binlist.presentation.view.adapters.VpAdapter
import com.drag0n.binlist.presentation.viewModel.ViewModel
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val model: ViewModel by viewModels()
    private val listTab = listOf("Поиск","История")
    override fun onCreate(savedInstanceState: Bundle?) {
        initAll()
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        model.load.observe(this){
            when(it){
                true-> binding.progressBar.visibility = View.VISIBLE
                false-> binding.progressBar.visibility = View.GONE
            }
        }

    }

    private fun initVp() {
        val vpAdapter = VpAdapter(this)
        binding.placeHolder.adapter = vpAdapter
        TabLayoutMediator(binding.tabLayout, binding.placeHolder) { tab, pos ->
            tab.text = listTab[pos]
        }.attach()

    } // инициализирую ViewPager
    private fun initAll(){
        binding = ActivityMainBinding.inflate(layoutInflater)
        initVp()
    }

}