package com.alexandrapavlova.mydumbapp.ui.likes

import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.alexandrapavlova.mydumbapp.ui.base.BaseFragment
import com.alexandrapavlova.mydumbapp.R
import com.alexandrapavlova.mydumbapp.databinding.FragmentLikesBinding

class LikesFragment: BaseFragment(R.layout.fragment_likes) {

    private val viewModel: LikesViewModel by viewModels()

    private val viewBinding by viewBinding(FragmentLikesBinding::bind)

}