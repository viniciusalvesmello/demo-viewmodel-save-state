package viniciusalvesmello.github.demoviewmodelsavestate

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

class MainViewModel(private val state: SavedStateHandle) : ViewModel() {

    val mainData: LiveData<MainData> = state.getLiveData(SAVE_STATE_VIEW_MODEL_KEY)
    
    fun updateMainData(mainData: MainData) {
        state.set(SAVE_STATE_VIEW_MODEL_KEY, mainData)
    }

    companion object {
        const val SAVE_STATE_VIEW_MODEL_KEY = "MAIN_DATA"
    }
}