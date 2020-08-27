package com.example.tiktokclone.ui.vertical

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.viewpager2.widget.ViewPager2
import com.example.tiktokclone.R

class VerticalFragment : Fragment() {

    private val viewModel: VerticalViewModel by activityViewModels()

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

        viewModel.canVerticalScroll.observe(viewLifecycleOwner, Observer {
            Log.d(TAG, "canScroll : $it")
            verticalViewPager2.isUserInputEnabled = it
        })
    }

    companion object {
        private const val TAG = "VerticalFragment"
    }
}