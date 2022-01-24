package com.example.myapplication.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myapplication.R


class DoingGoodFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_doing_good, container, false)
    }

    companion object {

        val TAG = DoingGoodFragment::class.simpleName

        @JvmStatic
        fun newInstance() = DoingGoodFragment().apply {

        }
    }
}