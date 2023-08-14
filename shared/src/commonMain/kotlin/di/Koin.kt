package di

import co.touchlab.kermit.LogWriter
import co.touchlab.kermit.Logger
import co.touchlab.kermit.StaticConfig
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import model.CharacterRepo
import model.remote.character.CharacterApi
import model.remote.character.CharacterApiImpl
import org.koin.core.KoinApplication
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module
import ui.characterList.CharacterViewModel
import util.kermitLoggerModule

fun initializeKoin(appDeclaration: KoinAppDeclaration): KoinApplication {

    val allModules = mutableListOf<Module>().apply {
        add(appModule)
        add(platformModule)
    }

    val koinApp = startKoin {
        appDeclaration()
        modules(allModules)
    }

    return koinApp
}

val appModule = module {
    single { Json { ignoreUnknownKeys = true } }
    kermitLoggerModule(
        baseLogger = Logger(
            config = StaticConfig(logWriterList = logWriters)
        )
    )
    single<CharacterApi> { CharacterApiImpl(client = get()) }
    single { CharacterRepo(api = get()) }
}

expect val logWriters: List<LogWriter>
expect val platformModule: Module