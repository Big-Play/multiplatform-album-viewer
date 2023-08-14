import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale


@Composable
fun RemoteImage(
    modifier: Modifier = Modifier,
    imageByteArray: ByteArray? = null,
    contentDescription: String? = null,
    contentScale: ContentScale = ContentScale.FillBounds
) {
    imageByteArray?.toImageBitmap()?.let {
        Image(
            modifier = modifier,
            bitmap = it,
            contentDescription = contentDescription,
            contentScale = contentScale
        )
    }
}
expect fun ByteArray.toImageBitmap(): ImageBitmap
expect suspend fun fetchImageAsByteArray(url: String): ByteArray