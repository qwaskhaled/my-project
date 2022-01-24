package com.example.myapplication

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.ui.home.DoingGoodFragment
import com.example.myapplication.ui.home.FeedFragment
import com.example.myapplication.ui.home.MyPreziFragment
import com.example.myapplication.ui.home.ProfileFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private var currentScreen: String? = null

    private var tabsState = mapOf(
        FeedFragment.TAG to ::updateFeedTab,
        ProfileFragment.TAG to ::updateProfileTab,
        MyPreziFragment.TAG to ::updatePreziTab,
        DoingGoodFragment.TAG to ::updateDoingGoodTab,
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.statusBarColor = Color.TRANSPARENT

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        replaceScreen(FeedFragment.TAG)
        setupListeners()
    }

    private fun replaceScreen(tag: String?) {
        if (currentScreen == tag) {
            return
        } else {
            currentScreen = tag
        }

        val fragment = when (tag) {
            MyPreziFragment.TAG -> MyPreziFragment.newInstance()
            DoingGoodFragment.TAG -> DoingGoodFragment.newInstance()
            ProfileFragment.TAG -> ProfileFragment.newInstance()
            else -> FeedFragment.newInstance()
        }

        tabsState.forEach { entry ->
            entry.value.invoke(tag == entry.key)
        }

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.container, fragment)
            .commit()
    }

    private fun updateDoingGoodTab(isClicked: Boolean) {
        val color = getStateColor(isClicked)

        binding.bottomAppbarContent.apply {
            tvDoingGood.setTextColor(color)
            ivDoingGood.setColorFilter(color)
        }
    }

    private fun updatePreziTab(isClicked: Boolean) {
        val color = getStateColor(isClicked)

        binding.bottomAppbarContent.apply {
            tvPrezi.setTextColor(color)
            ivPrezi.setColorFilter(color)
        }
    }

    private fun updateFeedTab(isClicked: Boolean) {
        val color = getStateColor(isClicked)

        binding.bottomAppbarContent.apply {
            tvFeed.setTextColor(color)
            ivFeed.setColorFilter(color)
        }
    }

    private fun updateProfileTab(isClicked: Boolean) {
        val color = getStateColor(isClicked)

        binding.bottomAppbarContent.apply {
            tvProfile.setTextColor(color)
            ivProfile.setColorFilter(color)
        }
    }

    private fun setupListeners() {
        binding.bottomAppbarContent.btnFeed.setOnClickListener {
            replaceScreen(FeedFragment.TAG)
        }

        binding.bottomAppbarContent.btnDoingGood.setOnClickListener {
            replaceScreen(DoingGoodFragment.TAG)
        }

        binding.bottomAppbarContent.btnPrezi.setOnClickListener {
            replaceScreen(MyPreziFragment.TAG)
        }

        binding.bottomAppbarContent.btnProfile.setOnClickListener {
            replaceScreen(ProfileFragment.TAG)
        }
    }

    private fun getStateColor(isClicked: Boolean): Int {
        val color = if (isClicked) R.color.crimson else R.color.philippineSilver
        return ContextCompat.getColor(this@MainActivity, color)
    }
}