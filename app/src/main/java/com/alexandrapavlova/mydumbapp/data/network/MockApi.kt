package com.alexandrapavlova.mydumbapp.data.network

import com.alexandrapavlova.mydumbapp.data.network.Api
import com.alexandrapavlova.mydumbapp.data.network.GetUsersResponse
import com.alexandrapavlova.mydumbapp.data.network.request.CreateProfileRequest
import com.alexandrapavlova.mydumbapp.data.network.request.RefreshAuthTokensRequest
import com.alexandrapavlova.mydumbapp.data.network.request.SignInWithEmailRequest
import com.alexandrapavlova.mydumbapp.data.network.response.error.*
import com.alexandrapavlova.mydumbapp.entity.AuthTokens
import com.alexandrapavlova.mydumbapp.entity.User

import com.haroldadmin.cnradapter.NetworkResponse
import com.alexandrapavlova.mydumbapp.data.network.response.VerificationTokenResponse

class MockApi : Api {
    override suspend fun getUsers(): GetUsersResponse {
        return GetUsersResponse(
            emptyList()
        )
    }

    override suspend fun signInWithEmail(request: SignInWithEmailRequest): NetworkResponse<AuthTokens, SignInWithEmailErrorResponse> {
        return NetworkResponse.Success(
            AuthTokens(
                accessToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJsb2dnZWRJbkFzIjoiYWRtaW4iLCJpYXQiOjE0MjI3Nzk2MzgsImV4cCI6MTY0MDg3MTc3MX0.gzSraSYS8EXBxLN_oWnFSRgCzcmJmMjLiuyu5CSpyHI",
                refreshToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJsb2dnZWRJbkFzIjoiYWRtaW4iLCJpYXQiOjE0MjI3Nzk2MzgsImV4cCI6MTY0MDg3MTc3MX0.gzSraSYS8EXBxLN_oWnFSRgCzcmJmMjLiuyu5CSpyHI",
                accessTokenExpiration = 1640871771000,
                refreshTokenExpiration = 1640871771000,
            ),
            code = 200
        )
    }

    override suspend fun refreshAuthTokens(request: RefreshAuthTokensRequest): NetworkResponse<AuthTokens, RefreshAuthTokensErrorResponse> {
        TODO("Not yet implemented")
    }

    override suspend fun sendRegistrationVerificationCode(email: String): NetworkResponse<Unit, SendRegistrationVerificationCodeErrorResponse> {
        TODO("Not yet implemented")
    }

    override suspend fun verifyRegistrationCode(
        code: String,
        email: String?,
        phoneNumber: String?
    ): NetworkResponse<VerificationTokenResponse, VerifyRegistrationCodeErrorResponse> {
        TODO("Not yet implemented")
    }

    override suspend fun createProfile(request: CreateProfileRequest): NetworkResponse<AuthTokens, CreateProfileErrorResponse> {
        TODO("Not yet implemented")
    }
}