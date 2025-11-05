package namle.tutorial.gymtracer.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import namle.tutorial.gymtracer.data.local.entity.MuscleGroupEntity
import namle.tutorial.gymtracer.data.repository.MuscleGroupRepository
import javax.inject.Inject

@HiltViewModel
class AddMuscleGroupViewModel @Inject constructor(private val repository: MuscleGroupRepository) : ViewModel()  {
    fun save(name: String, pic: String, status: Int) {
        viewModelScope.launch {
            repository.add(MuscleGroupEntity(name = name, picture = pic, status = status))
        }
    }

    fun getAll(): LiveData<List<MuscleGroupEntity>> {
        return repository.getAll().asLiveData()

    }

    override fun onCleared() {
        viewModelScope.cancel()
        super.onCleared()
    }
}