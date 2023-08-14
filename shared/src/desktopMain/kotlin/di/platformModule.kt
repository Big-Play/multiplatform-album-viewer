package di

import DesktopClient
import co.touchlab.kermit.LogWriter
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.core.module.Module
import org.koin.dsl.module
import util.getLoggerWithTag

actual val platformModule: Module = module {
    single { DesktopClient(json = get(), kermitLogger = getLoggerWithTag("DesktopClient")) }
}

actual val logWriters: List<LogWriter> = listOf()