package com.example.tiktokclone.ui.horizontal

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.tiktokclone.data.User
import com.example.tiktokclone.ui.horizontal.player.PlayerFragment
import com.example.tiktokclone.ui.horizontal.profile.UserProfileFragment
import java.io.Serializable

enum class PlayerType {
    MOVIE,
    PROFILE;
}

class HorizontalViewPagerAdapter(
    fragment: Fragment,
    private var user: User? = null)
    : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int {
        return  PlayerType.values().size
    }

    override fun createFragment(position: Int): Fragment {
        return user?.run {
            when(PlayerType.values()[position]) {
                PlayerType.MOVIE -> PlayerFragment.newInstance(movie)
                PlayerType.PROFILE -> UserProfileFragment.newInstance(profile)
            }
        } ?: Fragment()
    }

    fun setUser(user: User) {
        this.user = user
        notifyDataSetChanged()
    }

    companion object {
        @Suppress("unused")
        private const val TAG = "HorizontalAdapter"
    }
}