package com.codestation.elazkar.ui

import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.viewpager2.widget.ViewPager2
import com.codestation.elazkar.R
import com.codestation.elazkar.adapters.AdapterViewPager
import com.codestation.elazkar.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var viewPager2: ViewPager2
    private lateinit var adapter: AdapterViewPager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bottomNavigation = binding.bottomNavigation
        viewPager2 = binding.pager

        adapter = AdapterViewPager(supportFragmentManager,lifecycle)

        viewPager2.adapter = adapter

        bottomNavigation.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.morningAzkarFragment -> viewPager2.currentItem = 0
                R.id.eveningAzkarFragment -> viewPager2.currentItem = 1
                R.id.elsabhaFragment -> viewPager2.currentItem = 2
            }
            true
        }
        viewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                val menuItem = bottomNavigation.menu.getItem(position)
                bottomNavigation.selectedItemId = menuItem.itemId
            }
        })

    }


}