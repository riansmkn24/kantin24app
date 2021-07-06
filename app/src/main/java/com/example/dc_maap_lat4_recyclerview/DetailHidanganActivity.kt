package com.example.dc_maap_lat4_recyclerview

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailHidanganActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_DET = "extra_detail"
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_PHT = "0"
        const val EXTRA_HRG = "extra_harga"
        const val EXTRA_PSN = "extra_p"
        const val EXTRA_FVR = "extra_f"
        const val EXTRA_SHR = "extra_shr"
        const val EXTRA_KET = "extra_keterangan"
    }
    private var title="Detail Hidangan"

    private fun setActionBarTitle(title: CharSequence?) {
        supportActionBar?.title = title
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_item, menu)
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
            R.id.Profile -> {
                val i = Intent(this, aboutActivity::class.java)
                startActivity(i)
                finish()
            }
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setActionBarTitle(title)
        setContentView(R.layout.activity_detail_hidangan)
        val tvData1: TextView = findViewById(R.id.tv_item_name)
        val tvData5: TextView = findViewById(R.id.tv_item_harga)
        val tvData6: TextView = findViewById(R.id.tv_item_pesan)
        val tvData7: TextView = findViewById(R.id.tv_item_share)
        val tvData8: TextView = findViewById(R.id.tv_item_fave)
        val tvData2: TextView = findViewById(R.id.tv_item_detail)
        val tvData4: TextView = findViewById(R.id.tv_item_ket)
        val tvData3: ImageView = findViewById(R.id.img_hidangan)


        val name = intent.getStringExtra(EXTRA_NAME)
        val details = intent.getStringExtra(EXTRA_DET)
        val harganya = intent.getStringExtra(EXTRA_HRG)
        val pesan1 = intent.getStringExtra(EXTRA_PSN)
        val share1 = intent.getStringExtra(EXTRA_SHR)
        val fave1 = intent.getStringExtra(EXTRA_FVR)
        val keterangan = intent.getStringExtra(EXTRA_KET)
        val foto1 = intent.getStringExtra(EXTRA_PHT)
        val foto2=foto1 ?.toInt()

        tvData1.text=name
        tvData5.text=harganya
        tvData6.text=pesan1
        tvData7.text=share1
        tvData8.text=fave1
        tvData2.text=details
        tvData4.text=keterangan
        if (foto2 != null) {
            tvData3.setImageResource(foto2)

        }

    }

    fun faveBtn(view: View) {
        plusoneFave()
    }

    fun plusonePesan(){
        val tvData6: TextView = findViewById(R.id.tv_item_pesan)
        val temp: String = tvData6.getText().toString()
        var hitung = temp.toInt() + 1
        tvData6.text=hitung.toString()
    }
    fun plusoneFave(){
        val tvData8: TextView = findViewById(R.id.tv_item_fave)
        val temp: String = tvData8.getText().toString()
        var hitung = temp.toInt() + 1
        tvData8.text=hitung.toString()
    }
    fun plusoneShare(){
        val tvData7: TextView = findViewById(R.id.tv_item_share)
        val temp: String = tvData7.getText().toString()
        var hitung = temp.toInt() + 1
        tvData7.text=hitung.toString()
    }

    fun shareBtn(view: View) { plusoneShare() }
    fun pesanBtn(view: View) { plusonePesan() }
}