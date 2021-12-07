package com.alexandrapavlova.mydumbapp.ui

import com.alexandrapavlova.mydumbapp.interactor.AuthInteractor
import com.alexandrapavlova.mydumbapp.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val authInteractor: AuthInteractor
): BaseViewModel() {

    suspend fun isAuthorizedFlow(): Flow<Boolean> = authInteractor.isAuthorized()
}
