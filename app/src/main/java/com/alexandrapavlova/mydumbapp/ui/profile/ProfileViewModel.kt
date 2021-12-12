package com.alexandrapavlova.mydumbapp.ui.profile

import androidx.lifecycle.viewModelScope
import com.alexandrapavlova.mydumbapp.interactor.AuthInteractor
import com.alexandrapavlova.mydumbapp.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val authInteractor: AuthInteractor
) : BaseViewModel() {

    fun logout() {
        viewModelScope.launch {
            authInteractor.logout()
        }
    }
}