package com.encoders.roominkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.room.Room
import androidx.room.RoomDatabase
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var textview: TextView
    private lateinit var database: ContactDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textview = findViewById(R.id.textview)

        database = Room.databaseBuilder(
            applicationContext, ContactDatabase::class.java,
            "contact.db"
        ).build()

        GlobalScope.launch {
            database.contactDao().insert(Contact(0,"Encoders Technology Solution","0123456789"))

        }

        database.contactDao().get_Contact().observe(this, Observer {
            textview.text = it.toString()
        })

    }
}