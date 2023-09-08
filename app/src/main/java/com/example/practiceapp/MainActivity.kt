package com.example.practiceapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.practiceapp.data.DataSource
import com.example.practiceapp.model.Topic
import com.example.practiceapp.ui.theme.PracticeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PracticeAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    PracticeApp()
                }
            }
        }
    }
}

@Composable
fun PracticeApp() {
    PracticeList(
        practiceList = DataSource.topics
    )
}

@Composable
fun PracticeCard(
    topic: Topic,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
    ) {
        Row {
            Image(
                painter = painterResource(id = topic.imageResourceId),
                contentDescription = stringResource(id = topic.stringResourceId),
                modifier = Modifier
                    .height(68.dp),
                contentScale = ContentScale.Crop
            )
            Column(
                modifier = Modifier
                    .padding(start = 16.dp, top = 16.dp, end = 16.dp)
            ) {
                Text(
                    modifier = Modifier
                        .padding(bottom = 8.dp),
                    text = stringResource(id = topic.stringResourceId),
                    style = MaterialTheme.typography.bodyMedium
                )
                Row {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_grain),
                        contentDescription = null
                    )
                    Text(
                        modifier = Modifier
                            .padding(start = 8.dp, top = 4.dp)
                            .wrapContentHeight(Alignment.CenterVertically),
                        text = "${topic.views}",
                        style = MaterialTheme.typography.labelMedium
                    )
                }
            }
        }
    }
}

@Composable
fun PracticeList(
    practiceList: List<Topic>
) {
    LazyVerticalGrid(
        modifier = Modifier.padding(8.dp),
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(practiceList) { item ->
            PracticeCard(
                topic = item
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PracticeAppPreview() {
    PracticeApp()
}