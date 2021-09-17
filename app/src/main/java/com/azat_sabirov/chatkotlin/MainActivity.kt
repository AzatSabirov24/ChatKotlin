package com.azat_sabirov.chatkotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.azat_sabirov.chatkotlin.databinding.ActivityMainBinding
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val database = Firebase.database
        val myRef = database.getReference("message")

        binding.apply {
            sendBtn.setOnClickListener {
                myRef.setValue(messageEt.text.toString())
            }
        }
    }
}