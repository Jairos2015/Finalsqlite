package com.app.mttc.finalsqlite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import com.app.mttc.finalsqlite.database.DatabaseQueries
import android.content.Context
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {

    lateinit var name: EditText
    lateinit var email: EditText
    lateinit var password: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        name = findViewById(R.id.name)
        email = findViewById(R.id.email)
        password = findViewById(R.id.password)
    }

    fun addUser(v: View) {
        val db = DatabaseQueries(this)
        val res = db.addUser(name.text.toString(),email.text.toString(),password.text.toString())
        if (res>0)
        {
            AlertDialog.Builder( this)
                .setIcon(R.mipmap.ic_launcher_round)
                .setTitle("Message")
                .setMessage("Register Success")
                .setPositiveButton("ok",null)
                .show()
        }
        else{
            AlertDialog.Builder( this)
                .setIcon(R.mipmap.ic_launcher_round)
                .setTitle("Alert")
                .setMessage("Something is wrong, \nPlease, try again")
                .setPositiveButton("ok",null)
                .show()
        }
    }
}
