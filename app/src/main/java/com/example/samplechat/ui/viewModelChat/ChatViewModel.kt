package com.example.samplechat.ui.viewModelChat

import androidx.lifecycle.ViewModel
import com.example.samplechat.data.database.room.AppDatabase
import com.example.samplechat.data.utils.SingleLiveEvent

class ChatViewModel : ViewModel() {
    private var state: SingleLiveEvent<ChatState> = SingleLiveEvent()
    private lateinit var db: AppDatabase

    fun getChat() {
        state.value = ChatState.IsLoding(true)

    }



    fun getState() = state
}

/**
 * TODO: menampung data yang di dapatkan
 */
sealed class ChatState {
    data class Error(var err: String) : ChatState()
    data class ShoewToals(var message: String) : ChatState()
    data class IsLoding(var state: Boolean = false) : ChatState()
    data class Failed(var message: String) : ChatState()
    object Reset : ChatState()
}