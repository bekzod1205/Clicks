package uz.ictscholl.click

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.Color.WHITE
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import uz.ictscholl.click.databinding.ItemUserBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ItemUserBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ItemUserBinding.inflate(layoutInflater)
        val users = mutableListOf<Card>()
        val reklama = mutableListOf<Reklama>()
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        users.add(
            Card(
                "Bekzod",
                "1999 7775 4445 4444",
                R.drawable.img_2,
                "12/25",
                Color.parseColor("#282739")
            )
        )
        users.add(
            Card(
                "Aziz",
                "4325 5353 7687 5445",
                R.drawable.img_1,
                "11/24",
                Color.parseColor("#282739")
            )
        )
        users.add(
            Card(
                "Ibrohim",
                "5345 5435 3213 7897",
                R.drawable.img,
                "08/23",
                Color.parseColor("#282739")
            )
        )
        users.add(
            Card(
                "Kamron",
                "9708 5345 3454 7657",
                R.drawable.img_1,
                "07/22",
                Color.parseColor("#282739")
            )
        )
        users.add(
            Card(
                "Muxlisa",
                "5354 7834 9327 6743",
                R.drawable.img,
                "05/27",
                Color.parseColor("#282739")
            )
        )
        reklama.add(Reklama(R.drawable.img_4,"Bu yil Click kompaniyasi 11 yoshga to’ladi! Ushbu ayyom sharafiga biz siz uchun yangi mahsulotlarimiznin yirik taqdimotini tayyorladik.","Click Day 2022 – Yirik hodisaning bir qismi bo’ling!"))
        reklama.add(Reklama(R.drawable.img_6,"Hurmatli foydalanuvchilar, profilaktika ishlari munosabati bilan ba'zi hamkorlarimizga to'lovni amalga oshirish imkoni vaqtinchalik mavjud emas.","Diqqat!"))
        reklama.add(Reklama(R.drawable.img_7,"Yosh foydalanuvchilar uchun to'lov ilovasi!","O'zbekistonda ilk bor!"))
        reklama.add(Reklama(R.drawable.img_8,"CLICK Evolution ilovasidagi yangi \"Mening qarzlarim\" bo'limida qarz bering, oling va nazorat qiling!","CLICK ilovasining yangi «Mening qarzlarim» funksiyasi yordamida qarzlaringizni nazorat qiling"))

        binding.scanner.setOnClickListener {
            Toast.makeText(this, "Coming soon.......", Toast.LENGTH_SHORT).show()
        }
        binding.pass.setOnClickListener {
            Toast.makeText(this, "Coming soon.......", Toast.LENGTH_SHORT).show()
        }
        binding.boom.setOnClickListener {
            Toast.makeText(this, "Coming soon.......", Toast.LENGTH_SHORT).show()
        }

        val adapter = CardAdapter(users, object : CardAdapter.MyCard {
            override fun onItemClick(card: Card) {
                val intent = Intent(this@MainActivity, Item_view::class.java)
                intent.putExtra("card", card)
                startActivity(intent)
            }
        })
        val adapter_1 = ReklamaAdapter(reklama, object : ReklamaAdapter.myReklama {
            override fun onClick(reklama: Reklama) {
                val intent = Intent(this@MainActivity, Reklama_item::class.java)
                intent.putExtra("reklama", reklama)
                startActivity(intent)
            }
        })
        val manager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        val manager_1 = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.rv.layoutManager = manager
        binding.rv.adapter = adapter

        binding.rv1.layoutManager = manager_1
        binding.rv1.adapter = adapter_1
        val cache = getSharedPreferences("Name", Context.MODE_PRIVATE)
        val name = cache.getString("name", "")
        binding.welcome.text = binding.welcome.text.toString() + name.toString()
    }
}