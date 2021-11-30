package com.alexandrapavlova.mydumbapp.ui.bookmarks

import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.alexandrapavlova.mydumbapp.R
import com.alexandrapavlova.mydumbapp.databinding.FragmentBookmarksBinding
import com.alexandrapavlova.mydumbapp.ui.base.BaseFragment

class BookmarksFragment: BaseFragment(R.layout.fragment_bookmarks) {

    private val viewModel: BookmarksViewModel by viewModels()

    private val viewBinding by viewBinding(FragmentBookmarksBinding::bind)

}