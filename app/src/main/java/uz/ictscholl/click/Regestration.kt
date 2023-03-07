package uz.ictscholl.click

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import com.google.android.material.textfield.TextInputLayout

class Regestration : AppCompatActivity() {
    private lateinit var uz: Button
    private lateinit var rus: Button
    private lateinit var prev: Button
    private lateinit var next: Button
    private lateinit var tv: TextView
    private lateinit var phone: EditText
    private lateinit var name: EditText
    private lateinit var pin: EditText
    private lateinit var pin_l: TextInputLayout
    private lateinit var name_l: TextInputLayout
    private lateinit var phone_l: TextInputLayout
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
        tv = findViewById(R.id.tv_1)
        phone = findViewById(R.id.phone)
        name = findViewById(R.id.name)
        pin = findViewById(R.id.pin)
        pin_l = findViewById(R.id.pin_l)
        name_l = findViewById(R.id.name_l)
        phone_l = findViewById(R.id.phone_l)
        card = findViewById(R.id.card)

        uz.setOnClickListener {
            uz.visibility = View.INVISIBLE
            rus.visibility = View.INVISIBLE
            card.visibility = View.VISIBLE
            prev.visibility = View.VISIBLE
            next.visibility = View.VISIBLE
            prev.text = "Oldingi"
            next.text = "Keyingi"
            tv.text = "Ro'yxatdan o'tish"
            phone.hint = "Telefon raqami"
            name.hint = "Ism"
            pin.hint = "Click pin kod"
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
            phone.text.clear()
            name.text.clear()
            pin.text.clear()
            pin_l.helperText = ""
            name_l.helperText = ""
            phone_l.helperText = ""
        }
        next.setOnClickListener {
            if (phone.text.isNotEmpty() && name.text.isNotEmpty() && pin.text.isNotEmpty()) {
                if (is_pin(pin.text.toString())) {
                    val intent = Intent(this, Entrance::class.java)
                    startActivity(intent)
                    intent.putExtra("til", isok)
                    finish()
                } else {
                    if (isok) {
                        pin_l.helperText = "Pin 5ta raqamdan iborat bo'lishi kerak"
                    } else {
                        pin_l.helperText = "PIN -код должен быть 5 цифр"
                    }
                }
            } else {
                if (isok) {
                    if (phone.text.isEmpty()) phone_l.helperText = "Ma'lumotlar to'ldiring !!!"
                    else phone_l.helperText = ""
                    if (name.text.isEmpty()) name_l.helperText = "Ma'lumotlar to'ldiring !!!"
                    else name_l.helperText = ""
                    if (pin.text.isEmpty()) pin_l.helperText = "Ma'lumotlar to'ldiring !!!"
                    else pin_l.helperText = ""
                    if (!is_pin(pin.text.toString())) pin_l.helperText =
                        "Pin 5ta raqamdan iborat bo'lishi kerak"
                    else pin_l.helperText = ""
                } else {
                    if (phone.text.isEmpty()) phone_l.helperText = "Заполнить данные !!!"
                    else phone_l.helperText = ""
                    if (name.text.isEmpty()) name_l.helperText = "Заполнить данные !!!"
                    else name_l.helperText = ""
                    if (pin.text.isEmpty()) pin_l.helperText = "Заполнить данные !!!"
                    else pin_l.helperText = ""
                    if (!is_pin(pin.text.toString())) pin_l.helperText =
                        "PIN -код должен быть 5 цифр"
                    else pin_l.helperText = ""
                }
            }
        }
    }

    fun is_pin(str: String): Boolean {
        var count = 0
        for (i in str.indices) {
            if (Character.isLetter(str[i])) return false
            count++
        }
        if (count > 5) return false
        return true
    }
}