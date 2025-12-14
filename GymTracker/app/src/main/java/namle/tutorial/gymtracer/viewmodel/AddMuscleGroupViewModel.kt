package namle.tutorial.gymtracer.viewmodel

import android.net.Uri
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import namle.tutorial.gymtracer.data.local.entity.MuscleGroupEntity
import namle.tutorial.gymtracer.data.repository.MuscleGroupRepository
import namle.tutorial.gymtracer.utils.SingleLiveEvent
import java.io.File
import java.net.URI
import javax.inject.Inject

@HiltViewModel
class AddMuscleGroupViewModel @Inject constructor(private val repository: MuscleGroupRepository) : ViewModel()  {
    // 1. Dùng LiveData để cập nhật DỮ LIỆU UI
    private val _dataStatus = MutableLiveData<String>()
    val dataStatus: LiveData<String> = _dataStatus

    // 2. Dùng SingleLiveEvent để gửi SỰ KIỆN UI (ví dụ: Toast, Navigation)
    private val _showToastEvent = SingleLiveEvent<String>()
    val showToastEvent: LiveData<String> = _showToastEvent // View chỉ quan sát LiveData

    private val _saveStatusEvent = SingleLiveEvent<String>()
    val saveStatusEvent: LiveData<String> = _saveStatusEvent // View chỉ quan sát LiveData

    init {
        _dataStatus.value = ""
    }

    fun save(name: String, pic: String, status: Int) {
        viewModelScope.launch {
            repository.add(MuscleGroupEntity(name = name, picture = pic, status = status))
        }
    }

    fun getAll(): LiveData<List<MuscleGroupEntity>> {
        return repository.getAll().asLiveData()

    }

    fun saveData(imgName: String?, name: String?){
        viewModelScope.launch {
            repository.add(MuscleGroupEntity(name = name.toString(), picture = imgName.toString(), status = 1))
        }
        _saveStatusEvent.value = "SUCC"
    }

    override fun onCleared() {
        viewModelScope.cancel()
        super.onCleared()
    }
}