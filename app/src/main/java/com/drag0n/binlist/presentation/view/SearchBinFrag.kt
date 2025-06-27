package com.drag0n.binlist.presentation.view

import android.os.Bundle
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.drag0n.binlist.databinding.FragmentSearchBinBinding
import com.drag0n.binlist.presentation.viewModel.ViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchBinFrag : Fragment() {
    private lateinit var binding: FragmentSearchBinBinding
    private val model: ViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSearchBinBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        model.infoBinLD.observe(viewLifecycleOwner){
            with(binding){
                val coutry = "Страна: ${it.country.name}"
                val location = "Ширина: ${it.country.latitude}, долгота: ${it.country.longitude}"
                val cardType = "Тип карты: ${it.scheme}"
                val url = "Сайт: ${it.bank.url}"
                val phone = "Номер телефона банка: ${it.bank.phone}"
                val city = "Город: ${it.bank.city}"

                itemTvCountry.text = coutry
                itemTvLoc.text = location
                itemTvCardType.text = cardType
                itemTvUrlBank.text = url
                itemTvPhone.text = phone
                itemTvCity.text = city
            }
        }
        binding.button.setOnClickListener {
            uprateInfoBin()
        }
        binding.editTextText.setOnEditorActionListener { _, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_DONE ||
                (event != null && event.action == KeyEvent.ACTION_DOWN && event.keyCode == KeyEvent.KEYCODE_ENTER)) {
               uprateInfoBin()
                true
            } else {
                false
            }
        }
    }
    private fun uprateInfoBin(){
        val value = binding.editTextText.text
        model.getInfoBinApi(value.toString())
        value.clear()
    }

}