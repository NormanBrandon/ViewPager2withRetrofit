package com.nprmanbrandons11.viewpager2withretrofit

import ViewPagerAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.nprmanbrandons11.viewpager2withretrofit.databinding.ActivityMainBinding
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    lateinit var adapter: ViewPagerAdapter
    lateinit var tvDots:  MutableList<TextView>
    var currentImage:Int = 0

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
        adapter= ViewPagerAdapter(images)
        binding.vp2.adapter = adapter
        initIndicator()
        binding.btnSiguiente.setOnClickListener {
            Toast.makeText(this, "${currentImage}", Toast.LENGTH_SHORT).show()
            if (adapter.itemCount -1 == currentImage){
                currentImage = 0
                binding.vp2.setCurrentItem(currentImage)}
            else{
                currentImage++
                binding.vp2.setCurrentItem(currentImage)
            }
            transitionDots()
        }
        binding.btnAnteror.setOnClickListener {
            Toast.makeText(this, "${currentImage}", Toast.LENGTH_SHORT).show()
            if (0 == currentImage){
                currentImage = adapter.itemCount -1
                binding.vp2.setCurrentItem(currentImage)}
            else{
                currentImage--
                binding.vp2.setCurrentItem(currentImage)
            }
            transitionDots()
        }
        //binding.vp2.orientation = ViewPager2.ORIENTATION_VERTICAL
        /*binding.vp2.beginFakeDrag()
        binding.vp2.fakeDragBy(-10f)
        binding.vp2.endFakeDrag()*/
    }
    fun initIndicator(){
        tvDots = mutableListOf(TextView(this))
        tvDots.clear()
        binding.dots.removeAllViews()
        for ( i : Int in 0..adapter.itemCount-1){
            tvDots.add(TextView(this))
            val params:LinearLayout.LayoutParams  = LinearLayout.LayoutParams(20,20)
            params.setMargins(8,8,8,8)
            tvDots[i].layoutParams = params
            binding.dots.addView(tvDots[i])
        }
        currentImage = 0;
        transitionDots()

    }
    fun transitionDots(){
        for(i:Int in 0..tvDots.size -1){
            if (i == currentImage){
                tvDots[i].setBackgroundResource(R.drawable.indicator_select)
            }
            else{
                tvDots[i].setBackgroundResource(R.drawable.indicator_void)
            }
        }
    }

}