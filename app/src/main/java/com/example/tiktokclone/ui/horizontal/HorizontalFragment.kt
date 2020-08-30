package com.example.tiktokclone.ui.horizontal

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.tiktokclone.R
import com.example.tiktokclone.data.entity.Movie

class HorizontalFragment : Fragment() {

    private lateinit var horizontalViewPager2: ViewPager2

    private lateinit var horizontalViewPagerAdapter: HorizontalViewPagerAdapter

    private var movie: Movie? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let { arguments ->
            movie = arguments.getSerializable(KEY_MOVIE) as Movie
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_horizontal, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        horizontalViewPagerAdapter = HorizontalViewPagerAdapter(this)
        horizontalViewPager2 = view.findViewById(R.id.horizontal_view_pager2)
        horizontalViewPager2.apply {
            orientation = ViewPager2.ORIENTATION_HORIZONTAL
            adapter = horizontalViewPagerAdapter
        }
        movie?.let { movie ->
            horizontalViewPagerAdapter.setMovie(movie)
        }
    }

    companion object {
        private const val KEY_MOVIE = "key_movie"

        fun newInstance(movie: Movie) =
            HorizontalFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(KEY_MOVIE, movie)
                }
            }
    }
}