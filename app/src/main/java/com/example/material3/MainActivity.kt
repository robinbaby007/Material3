package com.example.material3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.UiMode
import androidx.compose.ui.unit.dp
import com.example.material3.ui.theme.Material3Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Material3Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MyList()
                }
            }
        }
    }
}

@Composable
fun MyList() {
    LazyColumn {
        items(
            key = { it.id },
            items = loadList() ?: arrayListOf()
        ) { data ->
            CustomCard(
                title = "Sample ${data.id}",
                url = data.url,
                modifier = Modifier,
                description = LocalContext.current.getString(R.string.description)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Material3Theme {
        MyList()
    }
}

fun loadList(): MutableList<ImageModel> {
    val imageList = mutableStateListOf<ImageModel>()
    for (i in 1..10) {
        imageList.add(ImageModel(i, "https://picsum.photos/id/${i}/300/200"))

    }
    return imageList
}