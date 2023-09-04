package com.acabes.imageapiapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.TitleBar))


        val recyclerView: RecyclerView =findViewById(R.id.recyclerView)
        recyclerView.layoutManager= LinearLayoutManager(this)

        val quote=RetrofitHelper().getInstance().create(APIinterface::class.java)
        GlobalScope.launch {
            val result=quote.getImg()
            runOnUiThread {
                result.body()?.let{
                    val adapter=MyAdapter(it.photos)
                    recyclerView.adapter=adapter

                }

            }

        }
    }
}