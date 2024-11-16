import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import android.os.SystemClock

class DashboardViewModel : ViewModel() {

    private val _time = MutableLiveData<Long>()
    val time: LiveData<Long> get() = _time

    private var startTime = 0L
    private var accumulatedTime = 0L
    private var isRunning = false
    private var timerJob: Job? = null

    fun startTimer() {
        if (!isRunning) {
            startTime = SystemClock.elapsedRealtime() // Cambio a SystemClock.elapsedRealtime()
            isRunning = true
            timerJob = viewModelScope.launch {
                while (isRunning) {
                    val elapsedMillis = SystemClock.elapsedRealtime() - startTime + accumulatedTime
                    _time.value = elapsedMillis
                    delay(100) // Ajustamos el retraso a 100 ms para optimización
                }
            }
        }
    }

    fun stopTimer() {
        if (isRunning) {
            accumulatedTime += SystemClock.elapsedRealtime() - startTime
            isRunning = false
            timerJob?.cancel()
        }
    }

    fun resetTimer() {
        stopTimer()
        accumulatedTime = 0L
        _time.value = 0L
    }
}
