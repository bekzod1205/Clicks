package uz.ictscholl.click

import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ReklamaAdapter(var reklamas: MutableList<Int>) :
    RecyclerView.Adapter<ReklamaAdapter.ReklamaHolder>() {
    class ReklamaHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var img: ImageView = itemView.findViewById(R.id.reklamaa)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReklamaHolder {
        val reklamaHolder = ReklamaHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.activity_main, parent, false)
        )
        return reklamaHolder
    }

    override fun onBindViewHolder(holder: ReklamaHolder, position: Int) {
        val reklamaHolder = reklamas[position]
        holder.img.setBackgroundResource(reklamaHolder)
    }

    override fun getItemCount(): Int {
        return reklamas.size
    }
}