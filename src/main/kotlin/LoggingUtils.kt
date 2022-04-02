import java.util.*
import java.util.logging.*

object LoggingUtils {
    val LOGGER = Logger.getLogger(
        LoggingUtils::class.java.name
    )
    const val ANSI_GREEN = "\u001B[32m"

    init {
        val handler = ConsoleHandler()
        handler.formatter = object : SimpleFormatter() {
            val format = "[%1\$tF %1\$tT] [%2$-7s] %3\$s %n"
            override fun formatMessage(record: LogRecord): String {
                return String.format(
                    ANSI_GREEN + format,
                    Date(record.millis),
                    record.level.localizedName,
                    record.message
                )
            }
        }
        LOGGER.useParentHandlers = false
        LOGGER.addHandler(handler)
    }
}