//
//import java.text.SimpleDateFormat
//import java.util.*
//import java.util.logging.LogRecord
//
//
//class LogFormatter : Formatter() {
//    fun format(record: LogRecord): String {
//        val builder = StringBuilder()
//        builder.append(ANSI_YELLOW)
//        builder.append("[")
//        builder.append(calcDate(record.millis))
//        builder.append("]")
//        builder.append(" [")
//        builder.append(record.sourceClassName)
//        builder.append("]")
//        builder.append(" [")
//        builder.append(record.level.name)
//        builder.append("]")
//        builder.append(ANSI_WHITE)
//        builder.append(" - ")
//        builder.append(record.message)
//        val params = record.parameters
//        if (params != null) {
//            builder.append("\t")
//            for (i in params.indices) {
//                builder.append(params[i])
//                if (i < params.size - 1) builder.append(", ")
//            }
//        }
//        builder.append(ANSI_RESET)
//        builder.append("\n")
//        return builder.toString()
//    }
//
//    private fun calcDate(millisecs: Long): String {
//        val date_format = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
//        val resultdate = Date(millisecs)
//        return date_format.format(resultdate)
//    }
//
//    companion object {
//        // ANSI escape code
//        const val ANSI_RESET = "\u001B[0m"
//        const val ANSI_BLACK = "\u001B[30m"
//        const val ANSI_RED = "\u001B[31m"
//        const val ANSI_GREEN = "\u001B[32m"
//        const val ANSI_YELLOW = "\u001B[33m"
//        const val ANSI_BLUE = "\u001B[34m"
//        const val ANSI_PURPLE = "\u001B[35m"
//        const val ANSI_CYAN = "\u001B[36m"
//        const val ANSI_WHITE = "\u001B[37m"
//    }
//}