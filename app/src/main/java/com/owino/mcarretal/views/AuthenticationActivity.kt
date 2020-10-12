package com.owino.mcarretal.views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.owino.mcarretal.R
import com.owino.mcarretal.adapter.AuthenticationPagerAdapter

class AuthenticationActivity : AppCompatActivity(){

    lateinit var viewPager: ViewPager
    lateinit var viewPagerAdapter:AuthenticationPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_authetication_layout);

        initializeResources();
    }

    private fun initializeResources() {
        viewPager = findViewById(R.id.authentication_flow_view_pager);
        viewPagerAdapter = AuthenticationPagerAdapter(supportFragmentManager)
        viewPager.adapter = viewPagerAdapter
    }
}