package com.example.dc_maap_lat4_recyclerview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView

class aboutActivity : AppCompatActivity() {
    private var title="About"

    private fun setActionBarTitle(title: CharSequence?) {
        supportActionBar?.title = title
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_about, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    private fun setMode(selectedMode: Int) {
        when (selectedMode) {
            R.id.Backbtn -> {
                val i = Intent(this, MainActivity::class.java)
                startActivity(i)
                finish()
            }
        }
    }

    fun tampilfoto(){
        val fotoku:ImageView = findViewById(R.id.img_photo_profile)
        fotoku.setImageResource(R.drawable.profilerian)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)
        setActionBarTitle(title)
        tampilfoto()

    }
}


