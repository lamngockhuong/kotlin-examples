package com.ngockhuong.someutils.utils.en

import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.*

class ENConst {
    companion object {
        val zoneId: ZoneId = ZoneId.of("America/New_York")
        val ymdFormatter: DateTimeFormatter = createFormatter("yyyyMMdd")
        val ymdWithSlashFormatter: DateTimeFormatter = createFormatter("yyyy/MM/dd")
        val ymdShortWithSlashFormatter: DateTimeFormatter = createFormatter("yy/MM/dd")
        val ymdWithHyphenFormatter: DateTimeFormatter = createFormatter("yyyy-MM-dd")
        val datetimeFormatter: DateTimeFormatter = createFormatter("yyyy-MM-dd HH:mm:ss")
        val datetimeWithoutSecondFormatter: DateTimeFormatter = createFormatter("yyyy-MM-dd HH:mm")
        val datetimeWithoutSecondWithSlashFormatter: DateTimeFormatter = createFormatter("yyyy/MM/dd HH:mm")
        val ymWithHyphenFormatter: DateTimeFormatter = createFormatter("yyyy-MM")
        val mdFormatter: DateTimeFormatter = createFormatter("MM/dd")
        val mdNotPaddingFormatter: DateTimeFormatter = createFormatter("M/d")
        val mdhmFormatter: DateTimeFormatter = createFormatter("MM/dd HH:mm")
        val hmFormatter: DateTimeFormatter = createFormatter("HH:mm")
        val hmWithoutColonFormatter: DateTimeFormatter = createFormatter("HHmm")
        val hmWithoutZeroPaddingFormatter: DateTimeFormatter = createFormatter("H:mm")
        val hmsFormatter: DateTimeFormatter = createFormatter("HH:mm:ss")
        val datetimeCompressFormatter: DateTimeFormatter = createFormatter("yyyyMMddHHmmss")
        val dayFormatter: DateTimeFormatter = createFormatter("dd")
        val dayNotPaddingFormatter: DateTimeFormatter = createFormatter("d")
        val dayOfTheWeekFormatter: DateTimeFormatter = createFormatter("EE")


        private fun createFormatter(format: String): DateTimeFormatter {
            return dateTimeFormatter(format).apply { withZone(zoneId) }
        }
    }
}

fun dateTimeFormatter(format: String): DateTimeFormatter {
    return DateTimeFormatter.ofPattern(format, Locale.US)
}
