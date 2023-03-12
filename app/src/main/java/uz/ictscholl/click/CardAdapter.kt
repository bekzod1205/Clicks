package uz.ictscholl.click

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class CardAdapter(var cards: MutableList<Card>,var myCard: MyCard) :
    RecyclerView.Adapter<CardAdapter.CardHolder>() {
    class CardHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var card_type: ImageView = itemView.findViewById(R.id.img)
        var name: TextView = itemView.findViewById(R.id.username)
        var data: TextView = itemView.findViewById(R.id.card_data)
        var card_number: TextView = itemView.findViewById(R.id.card)
        var background: ImageView = itemView.findViewById(R.id.back)
        var card_item: CardView = itemView.findViewById(R.id.card_item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardHolder {
        val cardHolder = CardHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.activity_main, parent, false)
        )
        return cardHolder
    }

    override fun onBindViewHolder(holder: CardHolder, position: Int) {
        val card = cards[position]
        holder.card_type.setBackgroundResource(card.card_type)
        holder.name.text = card.username
        holder.card_number.text = card.card_number
        holder.data.text = card.card_data
        holder.background.setBackgroundColor(card.color)

        holder.card_item.setOnClickListener {
            myCard.onItemClick(card)
        }

    }

    override fun getItemCount(): Int {
        return cards.size
    }

    interface MyCard {
        fun onItemClick(card: Card)
    }
}