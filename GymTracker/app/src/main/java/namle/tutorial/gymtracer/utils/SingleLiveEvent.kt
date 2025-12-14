package namle.tutorial.gymtracer.utils

import androidx.annotation.MainThread
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import java.util.concurrent.atomic.AtomicBoolean

/**
 * Một LiveData được thiết kế để chỉ gửi giá trị một lần duy nhất cho một Observer.
 * Nó dùng để xử lý các sự kiện (Events) như Navigation, Toast, Snackbar.
 */
class SingleLiveEvent<T>: MutableLiveData<T>() {
    private val pending = AtomicBoolean(false)

    @MainThread
    override fun observe(owner: LifecycleOwner, observer: Observer<in T>) {
        // Chỉ quan sát khi giá trị được gửi.
        super.observe(owner, Observer { t ->
            if (pending.compareAndSet(true, false)) {
                observer.onChanged(t)
            }
        })
    }

    @MainThread
    override fun setValue(value: T?) {
        pending.set(true)
        super.setValue(value)
    }

    /**
     * Dùng để gửi sự kiện mà không cần giá trị payload (ví dụ: chỉ cần yêu cầu đóng màn hình)
     */
    @MainThread
    fun call() {
        value = null
    }
}