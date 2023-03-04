package uz.ictscholl.click

import android.graphics.Color
import android.graphics.Color.WHITE
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import uz.ictscholl.click.databinding.ItemUserBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ItemUserBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ItemUserBinding.inflate(layoutInflater)
        var users = mutableListOf<Card>()
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        users.add(Card("Bekzod", "1999 7775 4445 4444", R.drawable.img_2, "12/25", Color.RED))
        users.add(Card("Aziz", "4325 5353 7687 5445", R.drawable.img_1, "11/24", Color.BLACK))
        users.add(Card("Ibrohim", "5345 5435 3213 7897", R.drawable.img, "08/23", Color.RED))
        users.add(Card("Kamron", "9708 5345 3454 7657", R.drawable.img_1, "07/22", Color.MAGENTA))
        users.add(Card("Muxlisa", "5354 7834 9327 6743", R.drawable.img, "05/27", Color.MAGENTA))

        val adapter = CardAdapter(users)
        val manager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.rv.layoutManager = manager
        binding.rv.adapter = adapter
    }
}