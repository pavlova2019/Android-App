package com.alexandrapavlova.mydumbapp.ui.profile

import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.alexandrapavlova.mydumbapp.R
import com.alexandrapavlova.mydumbapp.databinding.FragmentProfileBinding
import com.alexandrapavlova.mydumbapp.ui.base.BaseFragment

class ProfileFragment: BaseFragment(R.layout.fragment_profile) {

    private val viewModel: ProfileViewModel by viewModels()

    private val viewBinding by viewBinding(FragmentProfileBinding::bind)

}