package uz.ictscholl.click

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.cardview.widget.CardView

class Regestration : AppCompatActivity() {
    private lateinit var uz: Button
    private lateinit var rus: Button
    private lateinit var prev: Button
    private lateinit var next: Button
    private lateinit var tv: TextView
    private lateinit var phone: EditText
    private lateinit var name: EditText
    private lateinit var pin: EditText
    private lateinit var card: CardView

    @SuppressLint("MissingInflatedId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var isok = true
        setContentView(R.layout.activity_regestration)
        uz = findViewById(R.id.uz)
        rus = findViewById(R.id.rus)
        prev = findViewById(R.id.previous)
        next = findViewById(R.id.next)
        tv = findViewById(R.id.tv)
        phone = findViewById(R.id.phone)
        name = findViewById(R.id.name)
        pin = findViewById(R.id.pin)
        card = findViewById(R.id.card)

        uz.setOnClickListener {
            uz.visibility = View.INVISIBLE
            rus.visibility = View.INVISIBLE
            card.visibility = View.VISIBLE
            prev.visibility = View.VISIBLE
            next.visibility = View.VISIBLE
            isok = true
        }
        rus.setOnClickListener {
            uz.visibility = View.INVISIBLE
            rus.visibility = View.INVISIBLE
            card.visibility = View.VISIBLE
            prev.visibility = View.VISIBLE
            next.visibility = View.VISIBLE
            prev.text = "Предыдущий"
            next.text = "Следующий"
            tv.text = "Зарегистрироваться"
            phone.hint = "Номер телефона"
            name.hint = "Имя"
            pin.hint = "Пин-код"
            isok = false
        }
        prev.setOnClickListener {
            uz.visibility = View.VISIBLE
            rus.visibility = View.VISIBLE
            card.visibility = View.INVISIBLE
            prev.visibility = View.INVISIBLE
            next.visibility = View.INVISIBLE
            prev.text = "Keyingi"
            next.text = "Oldingi"
            tv.text = "Ro'yxatdan o'tish"
            phone.hint = "Telefon raqami"
            name.hint = "Ism"
            pin.hint = "Click pin kod"
        }
        next.setOnClickListener {
            val intent = Intent(this, Entrance::class.java)
            startActivity(intent)
            intent.putExtra("til", isok)
        }
    }
}