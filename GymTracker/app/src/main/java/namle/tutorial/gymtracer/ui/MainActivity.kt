package namle.tutorial.gymtracer.ui

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint
import namle.tutorial.gymtracer.R
import namle.tutorial.gymtracer.databinding.ActivityMainBinding
import namle.tutorial.gymtracer.viewmodel.MainViewModel

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()// full screen
        window.navigationBarColor = getColor(R.color.white)
        Log.d("MainActivity", "----------test--------------")
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, HomeFragment())
                .commit()
        }

        binding.btnNav.setOnItemSelectedListener { itemBtn ->
            val fragment = when (itemBtn.itemId){
                    R.id.nav_home -> {
                        HomeFragment()
                    }
                    R.id.nav_calendar -> {
                        HomeFragment()
                    }
                    R.id.nav_setting -> {
                        HomeFragment()
                    }
                    else -> null
                }
            fragment?.let {
                supportFragmentManager.beginTransaction()
                    .setCustomAnimations(
                        android.R.anim.fade_in,
                        android.R.anim.fade_out
                    )
                    .replace(R.id.container, it)
                    .commit()
            }

            true
        }

//        viewModel.getAllTest().observe(this) { list ->
//            val displayText = list.joinToString(separator = "") { test ->
//                "\nID: ${test.id}, Name: ${test.name}"
//            }
//            binding.info.text = displayText
//        }
//
//        binding.button.setOnClickListener {
//            val name = binding.editTextText.text.toString()
//            if (name.isNotEmpty()) {
//                viewModel.saveTest(name)
//                Toast.makeText(this, "Saved!", Toast.LENGTH_SHORT).show()
//            }
//        }
    }

}