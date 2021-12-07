package com.alexandrapavlova.mydumbapp.ui.profile

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.alexandrapavlova.mydumbapp.R
import com.alexandrapavlova.mydumbapp.databinding.FragmentProfileBinding
import com.alexandrapavlova.mydumbapp.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import dev.chrisbanes.insetter.applyInsetter

@AndroidEntryPoint
class ProfileFragment: BaseFragment(R.layout.fragment_profile) {

    private val viewModel: ProfileViewModel by viewModels()

    private val viewBinding by viewBinding(FragmentProfileBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding.logOutButton.applyInsetter {
            type(statusBars = true) { margin() }
        }
        viewBinding.logOutButton.setOnClickListener {
            viewModel.logout()
        }
    }

}