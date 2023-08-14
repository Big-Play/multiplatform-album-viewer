package di

import IosClient
import co.touchlab.kermit.LogWriter
import co.touchlab.kermit.NSLogWriter
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.darwin.Darwin
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.core.module.Module
import org.koin.dsl.module
import util.getLoggerWithTag

actual val platformModule: Module = module {
    single { IosClient(json = get(), kermitLogger = getLoggerWithTag("IosClient")) }
}

actual val logWriters: List<LogWriter> = listOf(NSLogWriter())