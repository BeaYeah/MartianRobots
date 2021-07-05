package com.beayeah.yeah.martianrobots

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.beayeah.yeah.martianrobots.databinding.ContentMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ContentMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ContentMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.commandButton.setOnClickListener {
            var commands = binding.commandsText.text.toString()

            try {
                val output = CommandParser().execute(commands)
                binding.resultText.text = output
            } catch (e: Exception) {
                binding.resultText.text = e.message
            }
        }
    }

}
