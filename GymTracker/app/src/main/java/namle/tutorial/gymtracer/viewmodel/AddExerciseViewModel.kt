package namle.tutorial.gymtracer.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import namle.tutorial.gymtracer.data.local.entity.ExerciseEntity
import namle.tutorial.gymtracer.data.local.entity.TestEntity
import namle.tutorial.gymtracer.data.repository.ExerciseRepository
import namle.tutorial.gymtracer.data.repository.TestRepository
import javax.inject.Inject

@HiltViewModel
class AddExerciseViewModel @Inject constructor(private val repository: ExerciseRepository) : ViewModel()  {
    fun saveExercise(a: String, b: String) {
        viewModelScope.launch {

            repository.addExercise(ExerciseEntity(name = a, picture = b, note = a, muscleGroupId = 1, status = 3))
        }
    }

    fun getAllExercise(): LiveData<List<ExerciseEntity>> {
        return repository.getAllTest().asLiveData()

    }

    override fun onCleared() {
        viewModelScope.cancel()
        super.onCleared()
    }
}