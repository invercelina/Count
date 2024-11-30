package com.example.count

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class CountViewModel: ViewModel() {
    private val _count = mutableStateOf(0)
    val count: State<Int> get() = _count

    fun increase() {
        _count.value++
    }
}