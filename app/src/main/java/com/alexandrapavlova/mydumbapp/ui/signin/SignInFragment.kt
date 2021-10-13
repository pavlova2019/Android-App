package com.alexandrapavlova.mydumbapp.ui.signin

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.alexandrapavlova.mydumbapp.R
import com.alexandrapavlova.mydumbapp.databinding.FragmentSignInBinding
import com.alexandrapavlova.mydumbapp.ui.base.BaseFragment

class SignInFragment: BaseFragment(R.layout.fragment_sign_in) {

    private val viewModel: SignInViewModel by viewModels()

    private val viewBinding by viewBinding(FragmentSignInBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding.backButton.setOnClickListener {
            findNavController().popBackStack()
        }
        viewBinding.signInButton.setOnClickListener {
            viewModel.signIn()
        }
    }

}