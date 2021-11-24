package com.alexandrapavlova.mydumbapp.ui.news

import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.alexandrapavlova.mydumbapp.ui.base.BaseFragment
import com.alexandrapavlova.mydumbapp.R
import com.alexandrapavlova.mydumbapp.databinding.FragmentNewsBinding

class NewsFragment: BaseFragment(R.layout.fragment_news) {

    private val viewModel: NewsViewModel by viewModels()

    private val viewBinding by viewBinding(FragmentNewsBinding::bind)

}