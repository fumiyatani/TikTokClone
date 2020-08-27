package com.example.tiktokclone.ui.vertical

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.widget.ViewPager2
import com.example.tiktokclone.R
import com.example.tiktokclone.data.Movie

class VerticalFragment : Fragment() {

    private lateinit var viewModel: VerticalViewModel

    private lateinit var verticalViewPager2: ViewPager2

    private lateinit var verticalViewPagerAdapter: VerticalViewPagerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.vertical_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(VerticalViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        verticalViewPagerAdapter = VerticalViewPagerAdapter(this)
        verticalViewPager2 = view.findViewById(R.id.vertical_view_pager2)
        verticalViewPager2.apply {
            orientation = ViewPager2.ORIENTATION_VERTICAL
            adapter = verticalViewPagerAdapter
        }
    }

    companion object {
        fun newInstance() = VerticalFragment()
    }
}