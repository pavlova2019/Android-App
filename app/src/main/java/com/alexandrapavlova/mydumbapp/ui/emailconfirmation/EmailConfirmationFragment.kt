package com.alexandrapavlova.mydumbapp.ui.emailconfirmation

import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.alexandrapavlova.mydumbapp.ui.base.BaseFragment
import com.alexandrapavlova.mydumbapp.R
import com.alexandrapavlova.mydumbapp.databinding.FragmentEmailConfirmationBinding

class EmailConfirmationFragment: BaseFragment(R.layout.fragment_email_confirmation) {

    private val viewModel: EmailConfirmationViewModel by viewModels()

    private val viewBinding by viewBinding(FragmentEmailConfirmationBinding::bind)

}