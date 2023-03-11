package uz.ictscholl.click

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout

class Splash : AppCompatActivity() {
    private lateinit var image: ImageView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        image = findViewById(R.id.click)
        val animation = AnimationUtils.loadAnimation(this, R.anim.anim_1)
        val handler = Handler(Looper.getMainLooper())
        image.startAnimation(animation)
        handler.postDelayed({
            val cache = getSharedPreferences("Info", Context.MODE_PRIVATE)
            val str = cache.getString("pin", "")
            if (str == "") {
                val intent = Intent(this, Regestration::class.java)
                startActivity(intent)
            }else{
                val intent = Intent(this, Entrance::class.java)
                startActivity(intent)
            }
            finish()
        }, 1500)
    }
}