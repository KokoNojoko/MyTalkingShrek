import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ProgressViewModel : ViewModel() {
    private val _foodProgress = MutableLiveData<Int>()
    val foodProgress: LiveData<Int>
        get() = _foodProgress

    private val _thirstProgress = MutableLiveData<Int>()
    val thirstProgress: LiveData<Int>
        get() = _thirstProgress

    private val _cleanProgress = MutableLiveData<Int>()
    val cleanProgress: LiveData<Int>
        get() = _cleanProgress

    init {
        _foodProgress.value = 0
        _thirstProgress.value = 0
        _cleanProgress.value = 0
    }

    fun updateFoodProgress(amount: Int) {
        val newValue = (_foodProgress.value ?: 0) + amount
        _foodProgress.postValue(newValue)
    }

    fun updateThirstProgress(amount: Int) {
        val newValue = (_thirstProgress.value ?: 0) + amount
        _thirstProgress.postValue(newValue)
    }

    fun updateCleanProgress(amount: Int) {
        val newValue = (_cleanProgress.value ?: 0) + amount
        _cleanProgress.postValue(newValue)
    }
}
