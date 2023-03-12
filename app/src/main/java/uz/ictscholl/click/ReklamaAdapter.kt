package uz.ictscholl.click

import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class ReklamaAdapter(var reklamas: MutableList<Reklama>, var myreklama: myReklama) :
    RecyclerView.Adapter<ReklamaAdapter.ReklamaHolder>() {
    class ReklamaHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var img: ImageView = itemView.findViewById(R.id.reklamaa)
        var card: CardView = itemView.findViewById(R.id.card_reklama)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReklamaHolder {
        val reklamaHolder = ReklamaHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.reklama_view, parent, false)
        )
        return reklamaHolder
    }

    override fun onBindViewHolder(holder: ReklamaHolder, position: Int) {
        val reklama = reklamas[position]
        holder.img.setBackgroundResource(reklama.img)

        holder.card.setOnClickListener {
            myreklama.onClick(reklama)
        }
    }

    override fun getItemCount(): Int {
        return reklamas.size
    }

    interface myReklama {
        fun onClick(reklama: Reklama)
    }
}