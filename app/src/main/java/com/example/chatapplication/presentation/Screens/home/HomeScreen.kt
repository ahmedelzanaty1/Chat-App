package com.example.chatapplication.presentation.Screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.example.chatapplication.R
import com.example.chatapplication.presentation.Screens.home.componant.HomeLazyVerticalGrid
import com.example.chatapplication.presentation.ViewModel.HomeViewModel
import com.example.chatapplication.presentation.base.BaseComposable
import com.example.chatapplication.presentation.componant.TopBar
import com.example.chatapplication.presentation.theme.mainblue

@Composable
fun HomeScreen(navController: NavController, modifier: Modifier = Modifier) {
    BaseComposable<HomeViewModel> { viewModel ->
        LaunchedEffect (viewModel.roomliststate){
            viewModel.listenerRoom()
        }
        Scaffold(topBar = { TopBar(title = "Home") } , floatingActionButton = {
            FloatingActionButton(onClick = {
                navController.navigate("add_room")
            } ,
                containerColor = mainblue ,
                contentColor = Color.White , shape = CircleShape){
                Image(painter = painterResource(id = R.drawable.add_ic) ,
                    contentDescription = "")
            }
        }) {innerpadding ->
            Column(
                modifier = Modifier.padding(innerpadding).fillMaxSize().paint(
                    painter = painterResource(id = R.drawable.background1),
                    contentScale = ContentScale.Crop
                )
            ) {
               HomeLazyVerticalGrid(homeViewModel = viewModel , modifier = modifier.padding(innerpadding)){
                   room ->
                   navController.navigate("chat_room/${room.id}")
               }
            }

        }
    }

}