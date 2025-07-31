package com.example.favorite.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.favorite.data.local.model.DataEntity
import com.example.favorite.domain.usecase.DataLocalUseCase
import com.example.shared.utils.Results
import com.example.shared.utils.handleResult
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.koin.android.annotation.KoinViewModel

@KoinViewModel
class FavoriteViewModel(private val dataLocalUseCase: DataLocalUseCase): ViewModel() {
    private val _stateListData : MutableStateFlow<Results<List<DataEntity>>> = MutableStateFlow(Results.empty())
    val stateListData = _stateListData.asStateFlow()

    private val _stateData : MutableStateFlow<Results<DataEntity>> = MutableStateFlow(Results.empty())
    val stateData = _stateData.asStateFlow()

    init {
        getData()
    }

    fun getData() {
        viewModelScope.launch {
            delay(1000)
            dataLocalUseCase.getData().handleResult(
                onLoading = {
                    _stateListData.value = Results.loading()
                },
                onSuccess = { it ->
                    _stateListData.value = Results.success(it)
                    if (it.size == 0){
                        _stateListData.value = Results.empty()
                    }
                },
                onError = { code, message ->
                    _stateListData.value = Results.error(code, message)
                }
            )
        }
    }

    fun getDataById(id: Int){
        viewModelScope.launch {
            delay(1000)
            dataLocalUseCase.getDatabyId(id).handleResult(
                onLoading = {
                    _stateData.value = Results.loading()
                },
                onSuccess = { it ->
                    _stateData.value = Results.success(it)
                },
                onError = { code, message ->
                    _stateData.value = Results.error(code, message)
                }
            )
        }
    }

    fun insertToFav(dataEntity: DataEntity){
        viewModelScope.launch {
            dataLocalUseCase.insertData(dataEntity)
        }
    }

    fun deleteFromFav(dataEntity: DataEntity){
        viewModelScope.launch {
            dataLocalUseCase.deleteData(dataEntity)
        }
        getData()
    }
}