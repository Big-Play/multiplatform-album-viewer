package drivers

import app.cash.sqldelight.db.SqlDriver

expect class DriverFactory {
    fun createDriver(): SqlDriver
}

fun createDatabase(driverFactory: DriverFactory): CharacterDatabase {
    return {
        val driver = driverFactory.createDriver()
        val database = CharacterDatabase(driver)
    }
}