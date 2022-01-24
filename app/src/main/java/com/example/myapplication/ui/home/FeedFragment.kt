package com.example.myapplication.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentHomeBinding
import com.example.myapplication.model.CardContent

class FeedFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupCircularAdapter()
    }

    private fun setupCircularAdapter() {
        val card1 = CardContent(
            id = 1,
            image = R.drawable.img1,
            title = "כמה אתם מבינים בסרטים?",
            subtitle = "גלו כמה אתם בעלי הבנה בתחום"
        )

        val card2 = CardContent(
            id = 2,
            image = R.drawable.img2,
            title = "כמה אתם מבינים בסרטים?",
            subtitle = "גלו כמה אתם בעלי הבנה בתחום"
        )

        val card3 = CardContent(
            id = 3,
            image = R.drawable.img3,
            title = "כמה אתם מבינים בסרטים?",
            subtitle = "גלו כמה אתם בעלי הבנה בתחום"
        )

        val card4 = CardContent(
            id = 4,
            image = R.drawable.img4,
            title = "כמה אתם מבינים בסרטים?",
            subtitle = "גלו כמה אתם בעלי הבנה בתחום"
        )

        val hardcodedData = listOf(card1, card2, card3, card4)
        val circularAdapter = CircularPagerAdapter(this, hardcodedData)
        val itemDecoration = HorizontalMarginItemDecoration(
            requireContext(),
            R.dimen.viewpager_current_item_horizontal_margin
        )

        val nextItemVisiblePx = resources.getDimension(R.dimen.viewpager_next_item_visible)
        val currentItemHorizontalMarginPx =
            resources.getDimension(R.dimen.viewpager_current_item_horizontal_margin)
        val pageTranslationX = nextItemVisiblePx + currentItemHorizontalMarginPx
        val pageTransformer = ViewPager2.PageTransformer { page: View, position: Float ->
            page.translationX = -pageTranslationX * position
            page.scaleY = 1 - (0.25f * kotlin.math.abs(position))
        }

        binding.viewPager.apply {
            adapter = circularAdapter
            offscreenPageLimit = 1

            setPageTransformer(pageTransformer)
            addItemDecoration(itemDecoration)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {

        val TAG = FeedFragment::class.simpleName

        @JvmStatic
        fun newInstance() = FeedFragment().apply {

        }
    }
}