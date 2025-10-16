package namle.tutorial.gymtracer.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import namle.tutorial.gymtracer.data.local.TestEntity
import namle.tutorial.gymtracer.data.repository.TestRepository
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: TestRepository) : ViewModel()  {
    fun saveTest(name: String) {
        viewModelScope.launch {
            repository.addTest(name)
        }
    }

    fun getAllTest(): LiveData<List<TestEntity>> {
        return repository.getAllTest().asLiveData()

    }

    protected val handler = CoroutineExceptionHandler { _, exception ->
        exception.printStackTrace()
    }

    override fun onCleared() {
        viewModelScope.cancel()
        super.onCleared()
    }
}