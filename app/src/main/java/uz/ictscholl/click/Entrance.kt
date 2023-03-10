package uz.ictscholl.click

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.Toast
import androidx.cardview.widget.CardView

class Entrance : AppCompatActivity(), View.OnClickListener {
    private lateinit var one: Button
    private lateinit var two: Button
    private lateinit var three: Button
    private lateinit var four: Button
    private lateinit var five: Button
    private lateinit var six: Button
    private lateinit var seven: Button
    private lateinit var eight: Button
    private lateinit var nine: Button
    private lateinit var zero: Button
    var str = ""
    var n = 0
    var list = mutableListOf<ImageView>()
    private lateinit var circle_1: ImageView
    private lateinit var circle_2: ImageView
    private lateinit var circle_3: ImageView
    private lateinit var circle_4: ImageView
    private lateinit var circle_5: ImageView
    private lateinit var backspace: ImageButton

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_entrance)
        one = findViewById(R.id.one)
        two = findViewById(R.id.two)
        three = findViewById(R.id.three)
        four = findViewById(R.id.four)
        five = findViewById(R.id.five)
        six = findViewById(R.id.six)
        seven = findViewById(R.id.seven)
        eight = findViewById(R.id.eight)
        nine = findViewById(R.id.nine)
        zero = findViewById(R.id.zero)
        circle_1 = findViewById(R.id.circle_1)
        circle_2 = findViewById(R.id.circle_2)
        circle_3 = findViewById(R.id.circle_3)
        circle_4 = findViewById(R.id.circle_4)
        circle_5 = findViewById(R.id.circle_5)
        backspace = findViewById(R.id.backspace)
        one.setOnClickListener(this)
        two.setOnClickListener(this)
        three.setOnClickListener(this)
        four.setOnClickListener(this)
        five.setOnClickListener(this)
        six.setOnClickListener(this)
        seven.setOnClickListener(this)
        eight.setOnClickListener(this)
        nine.setOnClickListener(this)
        zero.setOnClickListener(this)
        list.add(circle_1)
        list.add(circle_2)
        list.add(circle_3)
        list.add(circle_4)
        list.add(circle_5)
    }

    override fun onClick(v: View?) {
        var btn = findViewById<Button>(v!!.id)
        list[n].setBackgroundResource(R.drawable.baseline_circle_24)
        n++
        str += btn.text
        val cache = getSharedPreferences("Info", Context.MODE_PRIVATE)
        val st = cache.getString("pin", "")
        Log.d("tag", st.toString())
        if (str.length == 5) {
            if (st.toString() == str) {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
            }
            list.forEach {
                it.setBackgroundResource(R.drawable.outline_circle_24)
            }
            n = 0
            str = ""
        }
    }
}
