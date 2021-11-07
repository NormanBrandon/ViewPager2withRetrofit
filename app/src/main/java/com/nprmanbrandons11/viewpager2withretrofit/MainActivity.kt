package com.nprmanbrandons11.viewpager2withretrofit

import ViewPagerAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.nprmanbrandons11.viewpager2withretrofit.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    val images = listOf(
        "https://images.pexels.com/photos/9608996/pexels-photo-9608996.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
        "https://images.pexels.com/photos/6421589/pexels-photo-6421589.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
        "https://images.pexels.com/photos/9882510/pexels-photo-9882510.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
        "https://images.pexels.com/photos/9124361/pexels-photo-9124361.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
        "https://images.pexels.com/photos/10070829/pexels-photo-10070829.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
        "https://images.pexels.com/photos/10057628/pexels-photo-10057628.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
        "https://images.pexels.com/photos/9148144/pexels-photo-9148144.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
        "https://images.pexels.com/photos/9938940/pexels-photo-9938940.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
        "https://images.pexels.com/photos/9579125/pexels-photo-9579125.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500"
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        val adapter= ViewPagerAdapter(images)
        binding.vp2.adapter = adapter
        //binding.vp2.orientation = ViewPager2.ORIENTATION_VERTICAL
        /*binding.vp2.beginFakeDrag()
        binding.vp2.fakeDragBy(-10f)
        binding.vp2.endFakeDrag()*/
    }
}