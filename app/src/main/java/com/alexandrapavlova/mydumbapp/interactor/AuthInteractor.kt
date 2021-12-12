package com.alexandrapavlova.mydumbapp.interactor

import com.alexandrapavlova.mydumbapp.data.network.response.error.SignInWithEmailErrorResponse
import com.alexandrapavlova.mydumbapp.entity.AuthTokens
import com.alexandrapavlova.mydumbapp.repository.AuthRepository
import kotlinx.coroutines.flow.Flow
import com.haroldadmin.cnradapter.NetworkResponse
import timber.log.Timber
import javax.inject.Inject

class AuthInteractor @Inject constructor(
    private val authRepository: AuthRepository
) {

    suspend fun isAuthorized(): Flow<Boolean> =
        authRepository.isAuthorizedFlow()

    suspend fun signInWithEmail(email: String, password: String): NetworkResponse<AuthTokens, SignInWithEmailErrorResponse> {
        val response = authRepository.generateAuthTokensByEmail(email, password)
        when (response) {
            is NetworkResponse.Success -> {
                authRepository.saveAuthTokens(response.body)
            }
            is NetworkResponse.Error -> {
                Timber.e(response.error)
            }
            else -> {
                // TODO: do something ._.
            }
        }
        return response
    }



    suspend fun logout() {
        authRepository.saveAuthTokens(null)
    }
}