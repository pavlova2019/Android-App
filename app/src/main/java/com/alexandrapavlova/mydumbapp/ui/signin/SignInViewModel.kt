package com.alexandrapavlova.mydumbapp.ui.signin

import androidx.lifecycle.viewModelScope
import com.alexandrapavlova.mydumbapp.repository.AuthRepository
import com.alexandrapavlova.mydumbapp.ui.base.BaseViewModel
import kotlinx.coroutines.launch

class SignInViewModel: BaseViewModel() {

    fun signIn(email: String, password: String) {
        viewModelScope.launch {
            AuthRepository.signIn(email, password)
        }
    }
}