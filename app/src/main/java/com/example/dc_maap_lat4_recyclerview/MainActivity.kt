package com.example.dc_maap_lat4_recyclerview

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {
    private lateinit var rvHeroes: RecyclerView
    private var list: ArrayList<HidanganMenu> = arrayListOf()
    private var title="e-Kantin"

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_depan, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    private fun setMode(selectedMode: Int) {
        when (selectedMode) {
            R.id.Profile -> {
                val i = Intent(this, aboutActivity::class.java)
                startActivity(i)
                finish()
            }
            R.id.exit -> {
                val dialogClickListener = DialogInterface.OnClickListener { dialog, which ->
                    when (which) {
                        DialogInterface.BUTTON_POSITIVE -> {
                            finish()
                        }
                        DialogInterface.BUTTON_NEGATIVE -> {
                        }
                    }
                }

                val builder: AlertDialog.Builder = AlertDialog.Builder(this)
                builder.setMessage("Anda Akan Keluar Program.. Are you sure?").setPositiveButton("Yes", dialogClickListener)
                        .setNegativeButton("No", dialogClickListener).show()
            }

        }
    }
    private fun showSelectedHero(hero: HidanganMenu) {
        Toast.makeText(this, "Lihat Detail " + hero.name, Toast.LENGTH_SHORT).show()
        val moveWithDataIntent = Intent(this@MainActivity, DetailHidanganActivity::class.java)
        moveWithDataIntent.putExtra(DetailHidanganActivity.EXTRA_NAME, hero.name)
        moveWithDataIntent.putExtra(DetailHidanganActivity.EXTRA_DET, hero.detail)
        moveWithDataIntent.putExtra(DetailHidanganActivity.EXTRA_HRG, hero.harga.toString())
        moveWithDataIntent.putExtra(DetailHidanganActivity.EXTRA_PSN, hero.pesan.toString())
        moveWithDataIntent.putExtra(DetailHidanganActivity.EXTRA_FVR, hero.fave.toString())
        moveWithDataIntent.putExtra(DetailHidanganActivity.EXTRA_SHR, hero.share.toString())
        moveWithDataIntent.putExtra(DetailHidanganActivity.EXTRA_PHT, hero.photo.toString())
        moveWithDataIntent.putExtra(DetailHidanganActivity.EXTRA_KET, hero.keterangan)
        startActivity(moveWithDataIntent)
        finish()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        setActionBarTitle(title)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvHeroes = findViewById(R.id.rv_heroes)
        rvHeroes.setHasFixedSize(true)

        list.addAll(NamaHidangan.listData)
        showRecyclerList()
    }

    private fun setActionBarTitle(title: String) {
        supportActionBar?.title = title
    }

    private fun showRecyclerList() {
        rvHeroes.layoutManager = LinearLayoutManager(this)
        val listHeroAdapter = ListHeroAdapter(list)
        rvHeroes.adapter = listHeroAdapter

        listHeroAdapter.setOnItemClickCallback(object : ListHeroAdapter.OnItemClickCallback {
            override fun onItemClicked(data: HidanganMenu) {
                showSelectedHero(data)
            }
        })
    }







}