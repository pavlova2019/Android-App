package com.alexandrapavlova.mydumbapp.ui.signup

import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.alexandrapavlova.mydumbapp.ui.base.BaseFragment
import com.alexandrapavlova.mydumbapp.R
import com.alexandrapavlova.mydumbapp.databinding.FragmentSignUpBinding

class SignUpFragment: BaseFragment(R.layout.fragment_sign_up) {

    private val viewModel: SignUpViewModel by viewModels()

    private val viewBinding by viewBinding(FragmentSignUpBinding::bind)

}