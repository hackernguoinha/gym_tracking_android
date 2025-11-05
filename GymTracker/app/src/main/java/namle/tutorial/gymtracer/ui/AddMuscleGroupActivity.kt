package namle.tutorial.gymtracer.ui

import android.app.Activity
import android.app.Instrumentation.ActivityResult
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.Window
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.google.android.material.imageview.ShapeableImageView
import dagger.hilt.android.AndroidEntryPoint
import namle.tutorial.gymtracer.databinding.ActivityAddMuscleGroupBinding
import namle.tutorial.gymtracer.viewmodel.AddMuscleGroupViewModel
import java.io.File

@AndroidEntryPoint
class AddMuscleGroupActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddMuscleGroupBinding
    private val viewModel: AddMuscleGroupViewModel by viewModels()
    private val TAG = "AddMuscleGroupActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        binding = ActivityAddMuscleGroupBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
    }

    private fun initView() {
        Log.d(TAG, "init view")
        binding.imgMuscle.setOnClickListener {
            openGallery()
        }
    }

    private val pickImageLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val uri: Uri? = result.data?.data
            uri?.let { saveImageToInternalStorage(it) }
        }
    }

    private fun openGallery() {
        val intent = Intent(Intent.ACTION_PICK).apply {
            type = "image/*"
        }
        pickImageLauncher.launch(intent)
    }

    private fun saveImageToInternalStorage(selectedUri: Uri) {
        try {
            // Tạo file đích trong thư mục nội bộ app
            val file = File(filesDir, "image${System.currentTimeMillis()}.jpg")

            // Sao chép dữ liệu
            contentResolver.openInputStream(selectedUri)?.use { input ->
                file.outputStream().use { output ->
                    input.copyTo(output)
                }
            }

            // Hiển thị ảnh đã lưu bằng Glide
            Glide.with(this)
                .load(file)
                .into(binding.imgMuscle)

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}