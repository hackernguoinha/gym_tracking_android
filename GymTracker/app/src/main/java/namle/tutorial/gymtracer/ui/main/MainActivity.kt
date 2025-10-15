package namle.tutorial.gymtracer.ui.main

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import namle.tutorial.gymtracer.R
import namle.tutorial.gymtracer.data.local.AppDatabase
import namle.tutorial.gymtracer.data.repository.TestRepository
import namle.tutorial.gymtracer.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()// full screen
        Log.d("MainActivity", "----------test--------------")
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val db = AppDatabase.getInstance(this)
        val repo = TestRepository(db.testDao())
        val factory = MainViewModel.MainViewModelFactory(repo)
        viewModel = ViewModelProvider(this, factory)[MainViewModel::class.java]

        binding.button.setOnClickListener {
            val name = binding.editTextText.text.toString()
            if (name.isNotEmpty()) {
                viewModel.saveTest(name)
                Toast.makeText(this, "Saved!", Toast.LENGTH_SHORT).show()
            }
        }
    }

}