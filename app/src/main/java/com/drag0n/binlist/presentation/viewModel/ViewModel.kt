package com.drag0n.binlist.presentation.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.drag0n.binlist.data.Bin
import com.drag0n.binlist.domain.retrofit.BinApi
import com.drag0n.binlist.domain.room.ItemHistoryDB
import com.drag0n.binlist.domain.room.RoomDB
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ViewModel
    @Inject constructor(
        private val api: BinApi,
        private val db: RoomDB
    ): ViewModel() {


    private val _load = MutableLiveData<Boolean>()
    val load: LiveData<Boolean> = _load

    private val _infoBinLD = MutableLiveData<Bin>()
    val infoBinLD:LiveData<Bin> = _infoBinLD

    fun loadTrue(){ _load.value = true }
    fun loadFalse(){ _load.value = false }


    fun getInfoBinApi(value: String){
        loadTrue()
        viewModelScope.launch {
            try {
                api.getInfoBin(value).let { response ->
                    if (response.isSuccessful) {
                        _infoBinLD.postValue(response.body())
                        val item = ItemHistoryDB(
                            null,
                            "BIN: $value",
                            "Страна: ${response.body()?.country?.name}",
                            "Ширина: ${response.body()?.country?.latitude}, долгота: ${response.body()?.country?.longitude}",
                            "Тип карты: ${response.body()?.scheme}",
                            "Сайт: ${response.body()?.bank?.url}",
                            "Номер телефона банка: ${response.body()?.bank?.phone}",
                            "Город: ${response.body()?.bank?.city}"
                            )
                        insertHistoryDb(item)
                        loadFalse()
                    }
                }
            }
            catch (_: Exception){
                loadFalse()
            }

        }
    }

    private fun insertHistoryDb(item: ItemHistoryDB){
        viewModelScope.launch { db.dao().insert(item) }
    }
}