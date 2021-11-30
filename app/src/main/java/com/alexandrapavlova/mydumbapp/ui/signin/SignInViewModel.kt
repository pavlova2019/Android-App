package com.alexandrapavlova.mydumbapp.ui.signin

import androidx.lifecycle.viewModelScope
import com.alexandrapavlova.mydumbapp.interactor.AuthInteractor
import com.alexandrapavlova.mydumbapp.repository.AuthRepositoryOld
import com.alexandrapavlova.mydumbapp.ui.base.BaseViewModel
import kotlinx.coroutines.launch

// @HttpViewModel
class SignInViewModel constructor(
    private  val authInteractor: AuthInteractor
    ) : BaseViewModel() {

    fun signIn(email: String, password: String) {
        viewModelScope.launch {
            AuthRepositoryOld.signIn(email, password)
        }
    }

    sealed class SignInActionState {
        object Pending : SignInActionState()
        object Loading : SignInActionState()
        data class ServerError(val e: NetworkResponse.ServerError<SignInWithEmailErrorResponse>) : SignInActionState()
        data class NetworkError(val e: NetworkResponse.NetworkError) : SignInActionState()
        data class UnknownError(val e: NetworkResponse.UnknownError) : SignInActionState()
    }
}