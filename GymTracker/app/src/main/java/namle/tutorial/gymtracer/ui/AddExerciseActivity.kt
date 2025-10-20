package namle.tutorial.gymtracer.ui

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import dagger.hilt.android.AndroidEntryPoint
import namle.tutorial.gymtracer.R
import namle.tutorial.gymtracer.databinding.ActivityAddExerciseBinding
import namle.tutorial.gymtracer.databinding.ActivityMainBinding
import namle.tutorial.gymtracer.viewmodel.AddExerciseViewModel

@AndroidEntryPoint
class AddExerciseActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddExerciseBinding
    private val viewModel: AddExerciseViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddExerciseBinding.inflate(layoutInflater)
        binding.button2.setOnClickListener {
            viewModel.saveExercise("abc", "cba")
        }
    }
}