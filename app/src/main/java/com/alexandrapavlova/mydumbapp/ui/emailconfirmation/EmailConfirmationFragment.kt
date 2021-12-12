package com.alexandrapavlova.mydumbapp.ui.emailconfirmation

import android.app.AlertDialog
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.core.view.isVisible
import androidx.fragment.app.setFragmentResultListener
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
    private var email: String? = null

    private val timer = object: CountDownTimer(20000, 1000) {
        override fun onTick(millisUntilFinished: Long) {
            viewBinding.emailConfirmationCodeTimer.isVisible = true
            val sec = millisUntilFinished/1000
            viewBinding.emailConfirmationCodeTimer.text = "Выслать код повторно через $sec секунд"
        }

        override fun onFinish() {
            viewBinding.emailConfirmationCodeTimer.isVisible = false
            viewBinding.emailConfirmationGetNewCode.isEnabled = true
        }
    }

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
        setFragmentResultListener("SignUpFragmentEmail") { _, bundle ->
            email = bundle.get("SignUpFragmentBundle").toString()
            email?.let { getNewCode()}
        }
        viewBinding.backButton.setOnClickListener {
            onBackButtonPressed()
        }
        viewBinding.emailConfirmationGetNewCode.setOnClickListener {
            email?.let { getNewCode() }
        }

    }

    private fun getNewCode() {
        viewBinding.emailConfirmationGetNewCode.isEnabled = false
        timer.start()
        email?.let { viewModel.getNewCode(it) }
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