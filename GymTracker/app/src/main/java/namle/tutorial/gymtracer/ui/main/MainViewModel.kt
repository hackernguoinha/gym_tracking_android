package namle.tutorial.gymtracer.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import namle.tutorial.gymtracer.base.BaseViewModel
import namle.tutorial.gymtracer.data.repository.TestRepository

class MainViewModel(private val repository: TestRepository) : ViewModel()  {
    fun saveTest(name: String) {
        viewModelScope.launch {
            repository.addTest(name)
        }
    }

    class MainViewModelFactory(private val repository: TestRepository)
        : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return MainViewModel(repository) as T
        }
    }

    protected val handler = CoroutineExceptionHandler { _, exception ->
        exception.printStackTrace()
    }

    override fun onCleared() {
        viewModelScope.cancel()
        super.onCleared()
    }
}