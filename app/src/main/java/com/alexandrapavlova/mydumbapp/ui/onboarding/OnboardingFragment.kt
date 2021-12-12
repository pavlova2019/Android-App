package com.alexandrapavlova.mydumbapp.ui.onboarding

import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import by.kirich1409.viewbindingdelegate.viewBinding
import com.alexandrapavlova.mydumbapp.ui.base.BaseFragment
import com.alexandrapavlova.mydumbapp.R
import com.alexandrapavlova.mydumbapp.databinding.FragmentOnboardingBinding
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter
import dev.chrisbanes.insetter.applyInsetter

class OnboardingFragment : BaseFragment(R.layout.fragment_onboarding) {

    private val viewBinding by viewBinding(FragmentOnboardingBinding::bind)

    private var player : ExoPlayer? = null

    private var userTouch = false
    private var stopTimer = false
    private var page = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        player = SimpleExoPlayer.Builder(requireContext()).build().apply {
            addMediaItem(MediaItem.fromUri("asset:///onboarding.mp4"))
            repeatMode = Player.REPEAT_MODE_ALL
            prepare()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding.volumeControlButton.applyInsetter {
            type(statusBars = true) { margin() }
        }
        viewBinding.signUpButton.applyInsetter {
            type(navigationBars = true) { margin() }
        }
        viewBinding.playerView.player = player
        viewBinding.viewPager.setTextPages()
        viewBinding.viewPager.offscreenPageLimit = 1
        val recyclerView = viewBinding.viewPager.getChildAt(0) as RecyclerView
        recyclerView.apply {
        // setting padding on inner RecyclerView puts overscroll effect in the right place
        // TODO: expose in later versions not to rely on getChildAt(0) which might break
            setPadding(140, 0, 140, 0)
            clipToPadding = false
        }
        viewBinding.viewPager.attachDots(viewBinding.onboardingTextTabLayout)
        var volumeFlag = false
        viewBinding.playerView.player?.volume = 0F
        viewBinding.volumeControlButton.setOnClickListener{
            if (volumeFlag) {
                volumeFlag = false
                viewBinding.playerView.player?.volume = 0F
                viewBinding.volumeControlButton.setImageResource(R.drawable.ic_volume_off_white_24dp)
            }
            else {
                volumeFlag = true
                viewBinding.playerView.player?.volume = 1F
                viewBinding.volumeControlButton.setImageResource(R.drawable.ic_volume_on_white_24dp)
            }
        }
        viewBinding.signInButton.setOnClickListener {
            findNavController().navigate(R.id.action_onboardingFragment_to_signInFragment)
        }
        viewBinding.signUpButton.setOnClickListener {
            findNavController().navigate(R.id.action_onboardingFragment_to_signUpFragment)
        }
    }

    /*override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
    }*/

    override fun onResume() {
        super.onResume()
        startScroll()
        player?.play()
    }

    override fun onPause() {
        super.onPause()
        stopTimer = true
        player?.pause()
    }

    override fun onDestroy() {
        super.onDestroy()
        stopTimer = true
        player?.release()
    }

    private fun timer() : CountDownTimer = object: CountDownTimer(4000, 100) {
        override fun onTick(millisUntilFinished: Long) {
            if (stopTimer) {
                cancel()
            }
            if (userTouch) {
                userTouch = false
                cancel()
                timer().start()
            }
        }

        override fun onFinish() {
            if (!stopTimer) {
                page += 1
                if (viewBinding.viewPager.adapter?.itemCount == page) {
                    page = 0
                }
                viewBinding.viewPager.setCurrentItem(page, true)
                timer().start()
            }
        }
    }

    private fun startScroll() {
        stopTimer = false
        timer().start()
        viewBinding.viewPager.registerOnPageChangeCallback(
            object : ViewPager2.OnPageChangeCallback() {
                override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
                    super.onPageScrolled(position, positionOffset, positionOffsetPixels)
                    userTouch = true
                    page = position
                }
            }
        )
    }

    private fun ViewPager2.setTextPages() {
        adapter =
            ListDelegationAdapter(onboardingTextAdapterDelegate()).apply {
                items =
                    listOf(
                        getString(R.string.onboarding_view_pager_text_1),
                        getString(R.string.onboarding_view_pager_text_2),
                        getString(R.string.onboarding_view_pager_text_3)
                    )
            }
    }

    private fun ViewPager2.attachDots(tabLayout: TabLayout) {
        TabLayoutMediator(tabLayout, this) { _, _ -> }.attach()
    }


}