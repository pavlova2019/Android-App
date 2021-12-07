package com.alexandrapavlova.mydumbapp.ui.userlist

import androidx.lifecycle.viewModelScope
import com.alexandrapavlova.mydumbapp.BuildConfig
import com.alexandrapavlova.mydumbapp.data.network.Api
import com.alexandrapavlova.mydumbapp.data.network.MockApi
import com.alexandrapavlova.mydumbapp.ui.base.BaseViewModel
import com.alexandrapavlova.mydumbapp.entity.User
import com.squareup.moshi.Moshi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

//@HiltViewModel
class UserListViewModel : BaseViewModel() {

    sealed class ViewState {
        object Loading : ViewState()
        data class Data(val userList: List<User>) : ViewState()
    }

    private val _viewState = MutableStateFlow<ViewState>(ViewState.Loading)
    val viewState: Flow<ViewState> get() = _viewState.asStateFlow()

    init {
        viewModelScope.launch {
            _viewState.emit(ViewState.Loading)
            val users = loadUsers()
            _viewState.emit(ViewState.Data(users))
        }
    }

    private suspend fun loadUsers() : List<User> {
        return withContext(Dispatchers.IO) {
            Thread.sleep(1000)
            provideApi().getUsers().data
        }
    }

    private fun provideApi(): Api =
        if (BuildConfig.USE_MOCK_BACKEND_API) {
            MockApi()
        } else {
            Retrofit
                .Builder()
                .client(provideOkHttpClient())
                .baseUrl("https://reqres.in/api/")
                .addConverterFactory(MoshiConverterFactory.create(provideMoshi()))
                .build()
                .create(Api::class.java)
        }

    private fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient
            .Builder()
            //.addNetworkInterceptor(AuthorizationInterceptor(authRepository))
            //.authenticator(OurAwesomeAppAuthenticator(authRepository))
            .build()
    }

    private fun provideMoshi(): Moshi {
        return Moshi.Builder().build()
    }
}