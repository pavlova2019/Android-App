package com.alexandrapavlova.mydumbapp.ui.emailconfirmation

import android.app.AlertDialog
import android.os.Bundle
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.alexandrapavlova.mydumbapp.ui.base.BaseFragment
import com.alexandrapavlova.mydumbapp.R
import com.alexandrapavlova.mydumbapp.databinding.FragmentEmailConfirmationBinding
import dev.chrisbanes.insetter.applyInsetter

class EmailConfirmationFragment: BaseFragment(R.layout.fragment_email_confirmation) {

    private val viewModel: EmailConfirmationViewModel by viewModels()

    private val viewBinding by viewBinding(FragmentEmailConfirmationBinding::bind)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requireActivity().onBackPressedDispatcher.addCallback(
            this,
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    onBackButtonPressed()
                }
            }
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding.backButton.applyInsetter {
            type(statusBars = true) { margin() }
        }
        viewBinding.emailConfirmationCode.applyInsetter {
            type(navigationBars = true) { margin() }
        }
        viewBinding.backButton.setOnClickListener {
            onBackButtonPressed()
        }
    }

    private fun onBackButtonPressed() {
        val code = viewBinding.emailConfirmationCode.getCode()
        if (code.isBlank()) {
            findNavController().popBackStack()
            return
        }
        AlertDialog.Builder(requireContext())
            .setTitle(R.string.common_back_alert_dialog_text)
            .setNegativeButton(R.string.common_back_alert_dialog_cancel_button_text) { dialog, _ ->
                dialog?.dismiss()
            }
            .setPositiveButton(R.string.common_back_alert_dialog_ok_button_text) { _, _ ->
                findNavController().popBackStack()
            }
            .show()
    }

}