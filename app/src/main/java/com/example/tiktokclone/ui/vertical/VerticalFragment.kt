package com.example.tiktokclone.ui.vertical

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.viewpager2.widget.ViewPager2
import com.example.tiktokclone.R
import com.example.tiktokclone.data.UserRepository
import com.example.tiktokclone.ui.VerticalScrollViewModel

class VerticalFragment : Fragment() {

    private val viewModel: VerticalViewModel by viewModels {
        VerticalViewModelFactory(UserRepository)
    }

    private val verticalScrollViewModel: VerticalScrollViewModel by activityViewModels()

    private lateinit var verticalViewPager2: ViewPager2

    private lateinit var verticalViewPagerAdapter: VerticalViewPagerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_vertical, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        verticalViewPagerAdapter = VerticalViewPagerAdapter(this)
        verticalViewPager2 = view.findViewById(R.id.vertical_view_pager2)
        verticalViewPager2.apply {
            orientation = ViewPager2.ORIENTATION_VERTICAL
            adapter = verticalViewPagerAdapter
        }

        bindViewModel()
    }

    private fun bindViewModel() {
        viewModel.movieList.observe(viewLifecycleOwner) {
            verticalViewPagerAdapter.setMovieList(it)
        }

        verticalScrollViewModel.canVerticalScroll.observe(viewLifecycleOwner) {
            Log.d(TAG, "canScroll : $it")
            verticalViewPager2.isUserInputEnabled = it
        }
    }

    override fun onStart() {
        super.onStart()

        viewModel.loadMovieList()
    }

    companion object {
        private const val TAG = "VerticalFragment"
    }
}