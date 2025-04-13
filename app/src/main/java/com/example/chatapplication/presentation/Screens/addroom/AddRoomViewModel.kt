package com.example.chatapplication.presentation.Screens.addroom

import androidx.compose.runtime.mutableStateOf
import com.example.chatapplication.presentation.Screens.addroom.entity.Category
import com.example.chatapplication.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AddRoomViewModel @Inject constructor() : BaseViewModel(){
    val roomNameState = mutableStateOf("")
    val roomNameErrorState = mutableStateOf("")
    val roomDescState = mutableStateOf("")
    val roomDescErrorState = mutableStateOf("")
    val expandedState = mutableStateOf(false)
    val categoryList : List<Category> = Category.getCategories()
    val categoryNameState = mutableStateOf(categoryList[0].roomName)
    val categoryImageState = mutableStateOf(categoryList[0].roomImage)
    val categorySelected = mutableStateOf( categoryList[0].roomId)




}