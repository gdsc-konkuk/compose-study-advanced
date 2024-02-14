package kr.ac.konkuk.gdsc.picsum.feature.list.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import kr.ac.konkuk.gdsc.picsum.R
import kr.ac.konkuk.gdsc.picsum.designsystem.GDSCTheme
import kr.ac.konkuk.gdsc.picsum.designsystem.preview.ComponentPreview

@Composable
fun PhotoCard(
    photoUrl: String,
    author: String,
    onPress: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = GDSCTheme.colors.surface
        ),
        modifier = modifier.clickable { onPress() }
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AsyncImage(
                model = photoUrl,
                contentDescription = "Photo from $photoUrl",
                placeholder = painterResource(id = R.drawable.ic_launcher_foreground),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .height(140.dp)
                    .padding(16.dp)
                    .clip(RoundedCornerShape(12.dp))
            )
            Text(
                text = author,
                style = GDSCTheme.typography.medium1,
                color = GDSCTheme.colors.onSurface80
            )
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

@ComponentPreview
@Composable
private fun PhotoCardPreview() {
    GDSCTheme {
        PhotoCard(
            photoUrl = "https://picsum.photos/id/0/5000/3333",
            author = "Alejandro Escamilla",
            onPress = {}
        )
    }
}
