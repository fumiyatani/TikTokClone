package com.example.tiktokclone.ui.horizontal

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.tiktokclone.data.entity.Movie
import com.example.tiktokclone.ui.horizontal.player.PlayerFragment
import com.example.tiktokclone.ui.horizontal.profile.UserProfileFragment

enum class PlayerType {
    MOVIE,
    USER_PROFILE;
}

class HorizontalViewPagerAdapter(
    fragment: Fragment,
    private var movie: Movie? = null)
    : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int {
        return  PlayerType.values().size
    }

    override fun createFragment(position: Int): Fragment {
        return movie?.let {
            when(PlayerType.values()[position]) {
                PlayerType.MOVIE -> PlayerFragment.newInstance(it)
                PlayerType.USER_PROFILE -> UserProfileFragment.newInstance(it.userId)
            }
        } ?: Fragment()
    }

    fun setMovie(movie: Movie) {
        this.movie = movie
        notifyDataSetChanged()
    }

    companion object {
        @Suppress("unused")
        private const val TAG = "HorizontalAdapter"
    }
}