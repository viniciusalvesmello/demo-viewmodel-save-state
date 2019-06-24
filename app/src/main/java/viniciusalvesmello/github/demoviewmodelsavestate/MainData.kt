package viniciusalvesmello.github.demoviewmodelsavestate

data class MainData(
    var firstText: String = "",
    var secondText: String = ""
) {
    companion object {
        const val SAVE_STATE_VIEW_MODEL_FIRST_TEXT_KEY = "MAIN_DATA_FIRST_TEXT_KEY"
        const val SAVE_STATE_VIEW_MODEL_SECOND_TEXT_KEY = "MAIN_DATA_SECOND_TEXT_KEY"
    }
}