package com.example.composeproject

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {
    private val _email = MutableLiveData<String>()
    val email: LiveData<String> = _email

    private val _checkbox = MutableLiveData<Boolean>()
    val checkbox: LiveData<Boolean> = _checkbox

    fun setEmail(newEmail: String) {
        _email.value = newEmail
    }

    fun setCheckboxState(checked: Boolean) {
        _checkbox.value = checked
    }
}