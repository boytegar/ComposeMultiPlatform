package org.example.project.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shared.utils.Results
import com.example.shared.utils.handleResult
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import org.example.project.data.network.DataDto
import org.example.project.data.repository.DataRepository
import org.example.project.domain.usecase.DataUseCase
import org.koin.android.annotation.KoinViewModel

@KoinViewModel
class DataViewModel(private val dataUseCase: DataUseCase): ViewModel() {
    private val _state : MutableStateFlow<Results<List<DataDto>>> = MutableStateFlow(Results.empty())
    val state = _state.asStateFlow()
    init {
        getData()
    }
    fun getData() {
        viewModelScope.launch {
            dataUseCase.getData().handleResult(
                onLoading = {
                    _state.value = Results.loading()
                },
                onSuccess = { it ->
                    _state.value = Results.success(it)
                },
                onError = { code, message ->
                    _state.value = Results.error(code, message)
                }
            )
        }
    }

    fun getDataFailed() {
        viewModelScope.launch {
            dataUseCase.getDataFailed().handleResult(
                onLoading = {
                    _state.value = Results.loading()
                },
                onSuccess = { it ->
                    _state.value = Results.success(it)
                },
                onError = { code, message ->
                    _state.value = Results.error(code, message)
                }
            )
        }
    }

//    fun getData() {
//        val data =  dataUseCase.getData()
//        data.onStart {
//            _state.emit(Results.loading())
//            delay(1000)
//        }.onEach { it ->
//            _state.emit(Results.success(it))
//        }.catch {
//            _state.emit(Results.fail(it.toString()))
//        }.launchIn(viewModelScope)
//    }
}