package namle.tutorial.gymtracer.ui

import android.os.Bundle
import android.view.Window
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint
import namle.tutorial.gymtracer.databinding.ActivityAddExerciseBinding
import namle.tutorial.gymtracer.viewmodel.AddExerciseViewModel

@AndroidEntryPoint
class AddExerciseActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddExerciseBinding
    private val viewModel: AddExerciseViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        binding = ActivityAddExerciseBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button2.setOnClickListener {
            viewModel.saveExercise("abc", "cba")
        }


    }
}