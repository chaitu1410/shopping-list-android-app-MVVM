package com.chaittnyashinde.shoppingcart.ui.shoppinglist

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import androidx.appcompat.app.AppCompatActivity
import com.chaittnyashinde.shoppingcart.R


class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        object : CountDownTimer(1000,500){
            override fun onTick(p0: Long) {

            }

            override fun onFinish() {
                val intent = Intent(this@SplashActivity, ShopingActivity::class.java)
                startActivity(intent)
                finish()
            }
        }.start()
    }
}