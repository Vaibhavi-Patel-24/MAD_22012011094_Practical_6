package com.example.mad_22012011094_practical_6

import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SplashActivity : AppCompatActivity(),Animation.AnimationListener {

    lateinit var guni_animation:AnimationDrawable
    lateinit var tween_animation:Animation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_splash)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val uvpce_imageview= findViewById<ImageView>(R.id.uvpce_imageview)
        uvpce_imageview.setBackgroundResource(R.drawable.uvpce_animation_list)

        guni_animation =uvpce_imageview.background as AnimationDrawable
        tween_animation=AnimationUtils.loadAnimation(this,R.anim.tween)
        tween_animation.setAnimationListener(this)

    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if(hasFocus)
        {
            guni_animation.start()
            findViewById<ImageView>(R.id.uvpce_imageview).startAnimation(tween_animation)
        }
        else{
            guni_animation.stop()
        }
    }

    override fun onAnimationStart(animation: Animation?) {
    }

    override fun onAnimationEnd(animation: Animation?) {
        Intent(this,MainActivity::class.java).also{startActivity(it)}

    }

    override fun onAnimationRepeat(animation: Animation?) {
     }


}