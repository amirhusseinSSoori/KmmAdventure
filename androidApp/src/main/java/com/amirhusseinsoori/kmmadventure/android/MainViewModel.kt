package com.amirhusseinsoori.kmmadventure.android

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.amirhusseinsoori.kmmadventure.repository.UserRepository

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: UserRepository) : ViewModel() {

    private val mutableState = MutableStateFlow(MainState())
    val state = mutableState.asStateFlow()

    init {
        event()
    }


    private fun event() {
        viewModelScope.launch {
            repository.getProducts()
                .onStart { mutableState.value = mutableState.value.copy(isLoading = true) }
                .onCompletion {
                    mutableState.value = mutableState.value.copy(isLoading = false)
                }.collect() { data ->
                    data.fold(
                        ifLeft = {
                            mutableState.value = mutableState.value.copy(list = it)
                        }, ifRight = {
                            mutableState.value = mutableState.value.copy(message = it.message ?: "")
                        }
                    )

                }
        }
    }
}