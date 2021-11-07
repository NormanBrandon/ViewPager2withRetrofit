import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.nprmanbrandons11.viewpager2withretrofit.databinding.FragmentItemViewPager2Binding
import com.squareup.picasso.Picasso

class ViewPagerAdapter(val imgList:List<String>) : RecyclerView.Adapter<ViewPagerAdapter.ViewPagerViewHolder>(){

    inner class ViewPagerViewHolder(val binding:FragmentItemViewPager2Binding): RecyclerView.ViewHolder(binding.root){
        fun render(url : String){
            Picasso.get().load(url).into(binding.imageView)
       }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerViewHolder {
        val layoutinflater = LayoutInflater.from(parent.context)
        return ViewPagerViewHolder(FragmentItemViewPager2Binding.inflate(layoutinflater,parent,false))
    }

    override fun onBindViewHolder(holder: ViewPagerViewHolder, position: Int) {
        val urlimg = imgList[position]
        holder.render(urlimg)
    }

    override fun getItemCount(): Int {

        return imgList.size
    }
}