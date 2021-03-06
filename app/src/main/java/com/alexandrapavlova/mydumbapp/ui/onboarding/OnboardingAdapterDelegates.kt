package com.alexandrapavlova.mydumbapp.ui.onboarding

import com.alexandrapavlova.mydumbapp.databinding.ItemOnboardingTextBinding
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding

fun onboardingTextAdapterDelegate() =
    adapterDelegateViewBinding<String, CharSequence, ItemOnboardingTextBinding>(
    viewBinding = { layoutInflater, parent ->
        ItemOnboardingTextBinding.inflate(layoutInflater, parent, false)
    },
    block = {
        bind {
            binding.textView.text = item
        }
    }
)