package uz.ictscholl.click

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import uz.ictscholl.click.databinding.ActivityReklamaItemBinding

class Reklama_item : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val binding = ActivityReklamaItemBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val reklama = intent.getSerializableExtra("reklama") as Reklama

        binding.news.text = reklama.text
        binding.des.text = reklama.description
        binding.newsImg.setImageResource(reklama.img)
    }
}