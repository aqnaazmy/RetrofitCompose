package com.aqnaazmy.retrofitcompose.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberImagePainter
import com.aqnaazmy.retrofitcompose.data.api.model.Photos
import com.aqnaazmy.retrofitcompose.viewModel.HomeViewModel

@Composable
fun Home () {

    val homeViewModel = viewModel( modelClass = HomeViewModel::class.java)
    val state by homeViewModel.state.collectAsState()

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(8.dp)
    ){
        if (state.isEmpty()){
            item(span = { GridItemSpan(maxLineSpan) }){
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    CircularProgressIndicator()
                }
            }
        }
        items (state) {photos : Photos ->
            PhotosListItem(photos = photos)
        }
    }
}

@Composable
fun PhotosListItem (photos : Photos){
    val imagePainter = rememberImagePainter(data = photos.thumbnailUrl)

    Card (
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
    ) {
        Box(
            modifier = Modifier
                .aspectRatio(1f)
        ){
            Image(
                painter =imagePainter,
                contentDescription ="image",
                modifier = Modifier
                    .size(250.dp)

            )
            Surface(
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = .3f),
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter),
                contentColor = MaterialTheme.colorScheme.surface
            ) {

                Column (
                    modifier = Modifier
                        .padding(4.dp)
                ) {
                    Text(
                        text = photos.title,
                        fontSize = 12.sp
                    )
                }

            }
        }

    }
}
