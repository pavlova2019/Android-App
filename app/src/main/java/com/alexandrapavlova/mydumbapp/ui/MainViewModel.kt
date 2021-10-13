package com.alexandrapavlova.mydumbapp.ui

import com.alexandrapavlova.mydumbapp.repository.AuthRepository
import com.alexandrapavlova.mydumbapp.ui.base.BaseViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

class MainViewModel : BaseViewModel() {
    val isAuthorizedFlow: Flow<Boolean> = AuthRepository.isAuthorizedFlow

}