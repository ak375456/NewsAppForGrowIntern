import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import arrow.core.right
import coil.compose.AsyncImage
import com.example.newsapp.news.domain.model.Article
import com.example.newsapp.news.presenetation.news_screen.NewsViewState
import com.example.newsapp.util.components.LoadingDialog
import java.text.SimpleDateFormat
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewsCard(
    new: Article
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        // Image at the top
        AsyncImage(
            model = new.urlToImage ?: "",
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            contentScale = ContentScale.Crop
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = formatPublishedAt(new.publishedAt),
                style = MaterialTheme.typography.bodySmall
            )
            Box(
                modifier = Modifier
                    .background(
                        color = MaterialTheme.colorScheme.inversePrimary,
                        shape = RoundedCornerShape(15.dp)
                    )
                    .padding(5.dp)
            ) {
                Text(
                    text = new.author ?: "Unknown",
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }

        Text(
            text = new.title,
            style = TextStyle(
                fontSize = 16.sp,
                fontWeight = FontWeight.ExtraBold
            ) ,
            modifier = Modifier.padding(top = 8.dp)
        )
        Spacer(modifier = Modifier.height(18.dp))

        Text(
            text = new.description ?: "No Description",
            style = TextStyle(
                fontSize = 10.sp
            ) ,
            modifier = Modifier.padding(top = 4.dp)
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End // Align both items to the right
        ) {
            val context = LocalContext.current
            val intent = remember { Intent(Intent.ACTION_VIEW, Uri.parse(new.url)) }
            Text("READ MORE", modifier = Modifier.align(Alignment.CenterVertically))
            IconButton(
                onClick = {
                    context.startActivity(intent)
                }
            ) {
                Icon(
                    Icons.Default.ArrowForward, "",
                    tint = Color.Black,
                    modifier = Modifier
                        .background(
                            color = MaterialTheme.colorScheme.onSecondaryContainer,
                            shape = CircleShape)
                        .padding(8.dp)
                        .align(Alignment.CenterVertically),
                )
            }


        }
    }
}

@Composable
fun NewsContent(state: NewsViewState) {
    LoadingDialog(isLoading = state.isLoading)
    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding)
        ) {
            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ) {
                items(state.news) { news ->
                    NewsCard(new = news)
                }
            }
        }
    }
}

fun formatPublishedAt(publishedAt: String): String {
    val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.getDefault()) // Assuming ISO 8601 format
    val outputFormat = SimpleDateFormat("dd MMM yyyy", Locale.getDefault()) // Date format without time

    val date = inputFormat.parse(publishedAt) ?: return "Invalid date"
    return outputFormat.format(date)
}
