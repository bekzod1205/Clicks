package uz.ictscholl.click

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.cardview.widget.CardView
import com.google.android.material.textfield.TextInputLayout
import java.util.Locale

class Regestration : AppCompatActivity() {
    private lateinit var uz: Button
    private lateinit var rus: Button
    private lateinit var next: Button
    private lateinit var tv: TextView
    private lateinit var phone: EditText
    private lateinit var name: EditText
    private lateinit var pin: EditText
    private lateinit var pin_l: TextInputLayout
    private lateinit var name_l: TextInputLayout
    private lateinit var phone_l: TextInputLayout
    private lateinit var card: CardView

    @SuppressLint("MissingInflatedId", "SetTextI18n", "CommitPrefEdits")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var isok = true
        loadLocate()
        setContentView(R.layout.activity_regestration)
        uz = findViewById(R.id.uz)
        rus = findViewById(R.id.rus)
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
            loadLocate()
            uz.visibility = View.INVISIBLE
            rus.visibility = View.INVISIBLE
            card.visibility = View.VISIBLE
            next.visibility = View.VISIBLE
            setLocate("uz")
            isok = true
        }
        rus.setOnClickListener {
            loadLocate()
            uz.visibility = View.INVISIBLE
            rus.visibility = View.INVISIBLE
            card.visibility = View.VISIBLE
            next.visibility = View.VISIBLE
            setLocate("ru")
            isok = false
        }
        next.setOnClickListener {
            loadLocate()
            if (phone.text.isNotEmpty() && name.text.isNotEmpty() && pin.text.isNotEmpty()) {
                if (is_pin(pin.text.toString())) {
                    val cache = getSharedPreferences("Info", Context.MODE_PRIVATE)
                    val edit = cache.edit()
                    edit.putString("pin", pin.text.toString()).apply()
                    val cache_1 = getSharedPreferences("Name", Context.MODE_PRIVATE)
                    val edit_1 = cache_1.edit()
                    edit_1.putString("name", name.text.toString()).apply()
                    val intent = Intent(this, Entrance::class.java)
                    startActivity(intent)

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


    private fun setLocate(Lang: String) {

        val locale = Locale(Lang)

        Locale.setDefault(locale)

        val config = Configuration()

        config.locale = locale
        baseContext.resources.updateConfiguration(config, baseContext.resources.displayMetrics)

        val editor = getSharedPreferences("Settings", Context.MODE_PRIVATE).edit()
        editor.putString("My_Lang", Lang)
        editor.apply()
    }

    private fun loadLocate() {
        val sharedPreferences = getSharedPreferences("Settings", Activity.MODE_PRIVATE)
        val language = sharedPreferences.getString("My_Lang", "")
        if (language != null) {
            setLocate(language)
        }
    }
}