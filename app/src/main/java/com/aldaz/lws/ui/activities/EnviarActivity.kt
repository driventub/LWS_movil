package com.aldaz.lws.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.aldaz.lws.R
import com.aldaz.lws.databinding.ActivityEnviarBinding

class EnviarActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEnviarBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEnviarBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}