package com.alexandrapavlova.mydumbapp.ui

import com.alexandrapavlova.mydumbapp.repository.AuthRepositoryOld
import com.alexandrapavlova.mydumbapp.ui.base.BaseViewModel
import kotlinx.coroutines.flow.Flow

class MainViewModel : BaseViewModel() {
    val isAuthorizedFlow: Flow<Boolean> = AuthRepositoryOld.isAuthorizedFlow

}