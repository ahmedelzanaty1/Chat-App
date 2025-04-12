package com.example.chatapplication.presentation.base

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.chatapplication.presentation.utils.ErrorDialog
import com.example.chatapplication.presentation.utils.LoadingDialogs

@Composable
inline fun< reified vm : BaseViewModel> BaseComposable(content : @Composable (viewModel : vm) -> Unit) {
    val viewmodel : vm = hiltViewModel()
    content(viewmodel)
    LoadingDialogs(showLoading = viewmodel.loadingState)
    ErrorDialog(error = viewmodel.dialogState)



}