package namle.tutorial.gymtracer.ui

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint
import namle.tutorial.gymtracer.databinding.ActivityMainBinding
import namle.tutorial.gymtracer.viewmodel.MainViewModel

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()// full screen
        Log.d("MainActivity", "----------test--------------")
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel.getAllTest().observe(this) { list ->
            val displayText = list.joinToString(separator = "") { test ->
                "\nID: ${test.id}, Name: ${test.name}"
            }
            binding.info.text = displayText
        }

        binding.button.setOnClickListener {
            val name = binding.editTextText.text.toString()
            if (name.isNotEmpty()) {
                viewModel.saveTest(name)
                Toast.makeText(this, "Saved!", Toast.LENGTH_SHORT).show()
            }
        }
    }

}