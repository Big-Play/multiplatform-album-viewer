import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.toComposeImageBitmap
import di.initializeKoin
import moe.tlaster.precompose.PreComposeApplication

actual fun getPlatformName(): String = "iOS"

actual fun ByteArray.toImageBitmap(): ImageBitmap {
    return org.jetbrains.skia.Image.makeFromEncoded(this).toComposeImageBitmap()
}

fun MainViewController() = PreComposeApplication("IOS TITLE"){ App() }

fun InitializeKoin() = initializeKoin {  }