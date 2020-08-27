package com.example.tiktokclone.ui.horizontal

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.widget.ViewPager2
import com.example.tiktokclone.R
import com.example.tiktokclone.data.Movie
import com.example.tiktokclone.ui.vertical.VerticalFragment
import com.example.tiktokclone.ui.vertical.VerticalViewPagerAdapter

class HorizontalFragment : Fragment() {

    private lateinit var viewModel: HorizontalViewModel

    private lateinit var horizontalViewPager2: ViewPager2

    private lateinit var horizontalViewPagerAdapter: HorizontalViewPagerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this).get(HorizontalViewModel::class.java)
        return inflater.inflate(R.layout.horizontal_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        horizontalViewPagerAdapter = HorizontalViewPagerAdapter(this)
        horizontalViewPager2 = view.findViewById(R.id.horizontal_view_pager2)
        horizontalViewPager2.apply {
            orientation = ViewPager2.ORIENTATION_HORIZONTAL
            adapter = horizontalViewPagerAdapter
        }

        arguments?.let {
            val movie = it.getSerializable(KEY_MOVIE) as Movie
            viewModel.setMovie(movie)
        }

        viewModel.movie.observe(viewLifecycleOwner, Observer { movie ->
            horizontalViewPagerAdapter.setMovie(movie)
        })
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