package com.example.favorite.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.ArrowCircleLeft
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.example.favorite.data.local.model.DataEntity
import com.example.shared.components.MultiStateView
import org.koin.compose.viewmodel.koinViewModel

class FavoriteView: Screen {
    @Composable
    override fun Content() {
        val navigation = LocalNavigator.currentOrThrow
        val modifier = Modifier
        val favViewModel = koinViewModel<FavoriteViewModel>()
        val scrollState = rememberScrollState()
        Scaffold(
            topBar = {
                Row(modifier = modifier.height(60.dp).fillMaxWidth().background(color = Color.LightGray.copy(0.5f)).padding(8.dp), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Start) {
                    IconButton(
                        onClick = { navigation?.pop() },
                        enabled = true,
                        modifier = modifier.size(48.dp)
                    ) {

                        Icon(
                            imageVector = Icons.Filled.ArrowBackIosNew,
                            contentDescription = "Favorite"
                        )
                    }
                }
            }
        ) {
            Box( modifier = modifier
                .fillMaxSize().padding(8.dp)){
                MultiStateView(
                    modifier = modifier.fillMaxSize(),
                    state = favViewModel.stateListData,
                ){ it->
                    Column(
                        modifier = modifier
                            .fillMaxSize()
                            .verticalScroll(scrollState)
                    ){
                        Row(
                            modifier = modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ){
                            Text("${it.size} Item", style = TextStyle(
                                fontWeight = FontWeight.Bold,
                                color = Color.Black,
                                fontSize = 20.sp
                            ))
                        }
                        Spacer(modifier = modifier.height(16.dp))

                        it.forEach { item ->
                            ObjectFrames(
                                obj = item,
                                favViewModel
                            )
                            Spacer(modifier.height(8.dp))
                        }
                    }
                }
            }
        }
    }

    @Composable
    private fun ObjectFrames(
        obj: DataEntity,
        favoriteViewModel: FavoriteViewModel,
        modifier: Modifier = Modifier,
    ) {
        Column(
        ) {
            Row(modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {

                Text(modifier = modifier.weight(0.85f), text = obj.title, style = MaterialTheme.typography.subtitle1.copy(fontWeight = FontWeight.Bold))
                IconButton(
                    onClick = {
                        favoriteViewModel.deleteFromFav(obj)
                    },
                    enabled = true,
                    modifier = modifier.size(48.dp).weight(0.15f)
                ) {


                Icon(
                    imageVector = Icons.Filled.Close,
                    contentDescription = "UnFavorite"
                )

                }
            }

            Text(obj.artistDisplayName, style = MaterialTheme.typography.body2)
            Text(obj.objectDate, style = MaterialTheme.typography.caption)
        }
    }
}