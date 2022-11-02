package com.example.material3

import android.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest

@Composable
fun ColiImageView(
    url: String
) {

    Image(
        painter = rememberAsyncImagePainter(model = url), contentDescription = "",
        modifier = Modifier
            .clip(MaterialTheme.shapes.large)
            .fillMaxWidth()
            .aspectRatio(3f / 2f) // image resolution is 300/200
    )

    /*AsyncImage(
        modifier = Modifier.size(100.dp),
        model = ImageRequest.Builder(LocalContext.current)
            .data(url)
            .placeholder(R.drawable.ic_menu_compass)
            .build(),
        contentDescription = stringResource(R.string.copy),
        contentScale = ContentScale.None,
    )*/

}