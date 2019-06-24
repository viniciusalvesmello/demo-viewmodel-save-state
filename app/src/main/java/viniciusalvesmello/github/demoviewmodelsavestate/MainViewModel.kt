package viniciusalvesmello.github.demoviewmodelsavestate

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import viniciusalvesmello.github.demoviewmodelsavestate.MainData.Companion.SAVE_STATE_VIEW_MODEL_FIRST_TEXT_KEY
import viniciusalvesmello.github.demoviewmodelsavestate.MainData.Companion.SAVE_STATE_VIEW_MODEL_SECOND_TEXT_KEY

class MainViewModel(private val state: SavedStateHandle) : ViewModel() {
    
    private val _mainData: MutableLiveData<MainData> = MutableLiveData()
    val mainData: LiveData<MainData>
        get() = _mainData
    
    fun getSavedMainData() {
        val firstText: String = state.get(SAVE_STATE_VIEW_MODEL_FIRST_TEXT_KEY) ?: ""
        val secondText: String = state.get(SAVE_STATE_VIEW_MODEL_SECOND_TEXT_KEY) ?: ""
        _mainData.value = MainData(
            firstText = firstText,
            secondText = secondText
        )
    }
    
    fun updateMainData(mainData: MainData) {
        _mainData.value = mainData
        state.set(SAVE_STATE_VIEW_MODEL_FIRST_TEXT_KEY, mainData.firstText)
        state.set(SAVE_STATE_VIEW_MODEL_SECOND_TEXT_KEY, mainData.secondText)
    }
    
}