package com.example.count

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.count.room.AppDatabase
import com.example.count.room.CountEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CountViewModel(application: Application) : AndroidViewModel(application) {
    private val countDao = AppDatabase.getDatabase(application).countDao()

    private val _count = MutableStateFlow(0)
    val count: StateFlow<Int> get() = _count

    private val _name = MutableStateFlow("")
    val name: StateFlow<String> get() = _name

    init {
        loadCount()
    }

    fun increase() {
        _count.value++
        saveCount()
    }

    fun login(nameInput: String) {
        _name.value = nameInput
        loadCount()
    }

    private fun loadCount() {
        viewModelScope.launch(Dispatchers.IO) {
            val savedCount = countDao.getCount(_name.value)?.count ?: 0
            _count.value = savedCount
        }
    }

    private fun saveCount() {
        viewModelScope.launch(Dispatchers.IO) {
            countDao.insertCount(CountEntity(name = _name.value, count = _count.value))
        }
    }
}