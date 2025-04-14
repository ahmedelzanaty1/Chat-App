package com.example.chatapplication.presentation.Screens.addroom

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.chatapplication.R
import com.example.chatapplication.presentation.ViewModel.AddRoomViewModel
import com.example.chatapplication.presentation.base.BaseComposable
import com.example.chatapplication.presentation.componant.ChatAuthTextField
import com.example.chatapplication.presentation.componant.TopBar
import com.example.chatapplication.presentation.theme.mainblue

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddRoomScreen(navController: NavController,modifier: Modifier = Modifier) {
    BaseComposable<AddRoomViewModel> { viewModel ->
        Scaffold(
            topBar = {
                TopBar(title = "Chat Application", hasButtonBack = true, onClick = {
                    navController.navigateUp()
                })
            }
        ) { innerpadding ->
            innerpadding
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize().paint(
                    painter = painterResource(id = R.drawable.background1),
                    contentScale = ContentScale.Crop
                )
            ) {
                Card(
                    modifier = Modifier.padding(innerpadding).padding(35.dp).fillMaxWidth(0.85f),
                    colors = CardDefaults.cardColors(containerColor = Color.White)
                ) {
                    Text(
                        text = "Add New Room", color = Color.Black,
                        modifier = Modifier.align(Alignment.CenterHorizontally).padding(10.dp)
                    )
                    Image(
                        painter = painterResource(id = R.drawable.add_room_ic),
                        contentDescription = "add room",
                        modifier = Modifier.align(Alignment.CenterHorizontally)
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    ChatAuthTextField(label = "Room Name",
                        error = viewModel.roomNameErrorState.value,
                        state = viewModel.roomNameState)

                    ExposedDropdownMenuBox(
                        expanded = viewModel.expandedState.value,
                        onExpandedChange = { value ->
                            viewModel.expandedState.value = value
                        },
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        OutlinedTextField(
                            value = viewModel.categoryNameState.value,
                            onValueChange = {},
                            readOnly = true,
                            modifier = Modifier.menuAnchor().fillMaxWidth(),
                            trailingIcon = {
                                ExposedDropdownMenuDefaults.TrailingIcon(expanded = viewModel.expandedState.value)
                            }
                        )
                        ExposedDropdownMenu(
                            expanded = viewModel.expandedState.value,
                            onDismissRequest = {
                                viewModel.expandedState.value = false
                            }
                        ) {
                            viewModel.categoryList.forEach { category ->
                                DropdownMenuItem(
                                    text = {
                                        Row {
                                            Image(
                                                painter = painterResource(id = category.roomImage),
                                                contentDescription = "category",
                                                modifier = Modifier.padding(7.dp).size(50.dp)
                                            )
                                            Text(text = category.roomName)
                                        }
                                    },
                                    onClick = {
                                        viewModel.categoryNameState.value = category.roomName
                                        viewModel.categorySelected.value = category.toString()
                                        viewModel.expandedState.value = false
                                    }
                                )
                            }
                        }
                    }

                    //Spacer(modifier = Modifier.height(4.dp))
                    ChatAuthTextField(label = "Room Description",
                        error = viewModel.roomDescErrorState.value,
                        state = viewModel.roomDescState)

                }
                Button(onClick = {
                    viewModel.addRoom()
                } , colors =
                ButtonDefaults.buttonColors(containerColor = mainblue), modifier =
                Modifier.align(Alignment.CenterHorizontally)) {
                    Text(text = "Add Room")
                }

            }
            if (viewModel.isDone.value){
                navController.navigateUp()
            }

        }
    }
}