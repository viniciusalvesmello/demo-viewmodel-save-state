package viniciusalvesmello.github.demoviewmodelsavestate

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

class MainViewModel(state: SavedStateHandle) : ViewModel() {

    private val _mainData: MutableLiveData<MainData> = state.getLiveData(SAVE_STATE_VIEW_MODEL_KEY)
    val mainData: LiveData<MainData>
        get() = _mainData
    
    fun updateMainData(mainData: MainData) {
        _mainData.value = mainData
    }

    companion object {
        const val SAVE_STATE_VIEW_MODEL_KEY = "MAIN_DATA"
    }
}