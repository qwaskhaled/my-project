package com.example.myapplication.ui.home

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.myapplication.model.CardContent

class CircularPagerAdapter(fragment: Fragment, private val data: List<CardContent>) :
    FragmentStateAdapter(fragment) {

    override fun getItemCount() = Integer.MAX_VALUE

    override fun createFragment(position: Int) = CardFragment.newInstance(data[position % data.size])

    override fun getItemId(position: Int): Long = position.toLong()

}