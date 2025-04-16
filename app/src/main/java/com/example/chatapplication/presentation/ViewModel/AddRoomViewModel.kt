package com.example.chatapplication.presentation.ViewModel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.chatapplication.constants.Destinations
import com.example.chatapplication.domain.entity.Room
import com.example.chatapplication.domain.use.AddRoomUseCse
import com.example.chatapplication.presentation.Screens.addroom.entity.Category
import com.example.chatapplication.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddRoomViewModel @Inject constructor(
    private val addRoom : AddRoomUseCse
) : BaseViewModel(){
    val roomNameState = mutableStateOf("")
    val roomNameErrorState = mutableStateOf("")
    val roomDescState = mutableStateOf("")
    val roomDescErrorState = mutableStateOf("")
    val expandedState = mutableStateOf(false)
    val categoryList : List<Category> = Category.getCategories()
    val isDone = mutableStateOf(false)
    val categoryNameState = mutableStateOf(categoryList[0].roomName)
    val categoryImageState = mutableStateOf(categoryList[0].roomImage)
    val categorySelected = mutableStateOf( categoryList[0].roomId)

fun Validate() : Boolean{
    if (roomNameState.value.isEmpty()){
        roomNameErrorState.value = "Room name is required"
        return false
    }else{
        roomNameErrorState.value = ""
    }
    if (roomDescState.value.isEmpty()){
        roomDescErrorState.value = "Room description is required"
        return false
    }else {
        roomDescErrorState.value = ""
    }
    return true
}
    fun addRoom() {
        if (Validate()) {
            viewModelScope.launch {
                showLoading()
                val room = Room(
                    name = roomNameState.value,
                    description = roomDescState.value,
                    categoryId = categorySelected.value,
                    categoryName = categoryNameState.value,
                    userId = "currentUserId"
                )
                addRoom(room, onSuccess = {
                    hideLoading()
                    isDone.value = true
                }, onError = {
                    hideLoading()
                    showError(it.toString())
                })
            }
        }
    }



}
