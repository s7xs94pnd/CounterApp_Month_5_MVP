package com.example.counter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CounterViewModel : ViewModel() {
    private val model = CounterModel()

    private val _count = MutableLiveData(0)
    val count: LiveData<Int> get() = _count

    private val _toastMessage = MutableLiveData<String>()
    val toastMessage: LiveData<String> get() = _toastMessage

    private val _textColor = MutableLiveData<Int>()
    val textColor: LiveData<Int> get() = _textColor

    fun increment() {
        model.increment()
        updateState()
        checkSpecialValues()
    }

    fun decrement() {
        model.decrement()
        updateState()
    }

    private fun updateState() {
        _count.value = model.getCount()
    }

    private fun checkSpecialValues() {
        when (model.getCount()) {
            10 -> _toastMessage.value = "Поздравляем!"
            15 -> _textColor.value = R.color.green
        }
    }
}