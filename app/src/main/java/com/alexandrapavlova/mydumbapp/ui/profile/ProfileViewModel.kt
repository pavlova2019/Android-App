package com.alexandrapavlova.mydumbapp.ui.profile

import com.alexandrapavlova.mydumbapp.interactor.AuthInteractor
import com.alexandrapavlova.mydumbapp.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val authInteractor: AuthInteractor
) : BaseViewModel() {
}