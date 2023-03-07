package uz.ictscholl.click

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
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
    private lateinit var circle_1: CardView
    private lateinit var circle_2: CardView
    private lateinit var circle_3: CardView
    private lateinit var circle_4: CardView
    private lateinit var circle_5: CardView
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

    }

    fun change_back(str: String) {
        for (i in 1..5) {

        }
    }

    override fun onClick(v: View?) {
        var btn = findViewById<Button>(v!!.id)
        var str = ""
        str += btn.text
        change_back(str)
    }
}