package com.example.dc_maap_lat4_recyclerview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView


class SplashDepanActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_depan)
        pindah()
    }

    fun pindah(){
        var ldp: ImageView = findViewById(R.id.logodp)
        ldp.alpha = 0.3f
        ldp.scaleX = 0.5f
        ldp.scaleY = 0.5f
        ldp.animate().setDuration(2000).alpha(2f).scaleX(1.5f).scaleY(1.5f).withEndAction() {
            ldp.animate().setDuration(1500).alpha(2f).scaleX(1.5f).scaleY(1.5f).withEndAction() {
                ldp.animate().setDuration(200).alpha(0f).scaleX(2f).scaleY(2f).withEndAction() {
                    val i = Intent(this, MainActivity::class.java)
                    startActivity(i)
                    overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
                    finish()
                }
            }
        }
    }
}