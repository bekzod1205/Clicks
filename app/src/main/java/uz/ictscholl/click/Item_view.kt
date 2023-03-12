package uz.ictscholl.click

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import uz.ictscholl.click.databinding.ActivityItemViewBinding

class Item_view : AppCompatActivity() {
    lateinit var binding: ActivityItemViewBinding

    @SuppressLint("InflateParams")
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityItemViewBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        var user = intent.getSerializableExtra("card") as Card
        binding.username.text = user.username
        binding.cardData.text = user.card_data
        binding.img.setImageResource(user.card_type)
        binding.card.text = user.card_number


        binding.edit.setOnClickListener {
            binding.editName.visibility = View.VISIBLE
            binding.cardItem.visibility = View.INVISIBLE
            binding.delete.visibility = View.INVISIBLE
        }
        binding.save.setOnClickListener {
            binding.username.text = binding.editText.text
            binding.editName.visibility = View.INVISIBLE
            binding.cardItem.visibility = View.VISIBLE
            binding.delete.visibility = View.VISIBLE
        }
        binding.delete.setOnClickListener {
            Toast.makeText(this, "Coming soon.......", Toast.LENGTH_SHORT).show()
        }
    }
}