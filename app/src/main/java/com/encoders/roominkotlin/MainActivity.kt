package com.encoders.roominkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.encoders.roominkotlin.Adapter.ContactListAdapter
import com.encoders.roominkotlin.Adapter.onContactClickListner
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity(), onContactClickListner {
    private lateinit var textview: TextView
    private lateinit var database: ContactDatabase
    private lateinit var save_user: AppCompatButton
    private lateinit var phone_number: EditText
    private lateinit var username: EditText
    private lateinit var contact_list: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        save_user = findViewById(R.id.save_user)
        phone_number = findViewById(R.id.phone_number)
        username = findViewById(R.id.username)

        contact_list = findViewById(R.id.contact_list)

        database = ContactDatabase.getDatabase(this)
        save_user.setOnClickListener {
            GlobalScope.launch {
                database.contactDao().insert(
                    Contact(
                        0, username.text.toString(),
                        phone_number.text.toString()
                    )
                )

            }
        }


        database.contactDao().get_Contact().observe(this, Observer {
            Load_Contacts(it)

        })


    }


    fun Load_Contacts(list: List<Contact>) {
        contact_list.layoutManager =
            LinearLayoutManager(
                this,
                LinearLayoutManager.VERTICAL,
                false
            )

        val contactListAdapter =
            ContactListAdapter(
                list, this@MainActivity,
            )
        contact_list.adapter = contactListAdapter
    }

    override fun onContactClickListner(data: Contact, position: Int) {

    }
}