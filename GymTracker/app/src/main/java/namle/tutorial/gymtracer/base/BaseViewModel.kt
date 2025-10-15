package namle.tutorial.gymtracer.base

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.cancel

open class BaseViewModel: ViewModel() {
    protected val handler = CoroutineExceptionHandler { _, exception ->
        exception.printStackTrace()
    }

    override fun onCleared() {
        viewModelScope.cancel()
        super.onCleared()
    }
}