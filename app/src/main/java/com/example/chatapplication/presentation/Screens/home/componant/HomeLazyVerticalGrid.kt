package com.example.chatapplication.presentation.Screens.home.componant

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.chatapplication.R
import com.example.chatapplication.domain.entity.Room
import com.example.chatapplication.presentation.Screens.addroom.entity.Category
import com.example.chatapplication.presentation.ViewModel.HomeViewModel
import com.example.chatapplication.presentation.theme.mainblue

@Composable
fun HomeLazyVerticalGrid(homeViewModel: HomeViewModel, modifier: Modifier = Modifier
                         , onRoomClick: (room:Room) -> Unit) {
    LazyVerticalGrid(columns = GridCells.Fixed(2), modifier = modifier.padding(2.dp)) {
        items(homeViewModel.roomliststate.size) { room ->
            val room = homeViewModel.roomliststate[room]
            val category = try {
                Category.fromId(room.categoryId)
            } catch (e: IllegalArgumentException) {
                Category(room.categoryId, room.categoryName, R.drawable.movie)
            }

            Card(
                colors = CardDefaults.cardColors(containerColor = Color.White),
                modifier = modifier.padding(3.dp).size(200.dp).clickable {
                    onRoomClick(room)
                }
            ) {
                Column(
                    modifier = Modifier,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        modifier = Modifier
                            ,
                        painter = painterResource(id = category.roomImage),
                        contentDescription = null
                    )
                    Text(text = room.name , color = mainblue
                        , modifier = Modifier.align(Alignment.CenterHorizontally))
                }
            }
        }
    }
}