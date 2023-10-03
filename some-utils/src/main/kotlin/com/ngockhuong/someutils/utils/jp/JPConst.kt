package com.ngockhuong.someutils.utils.jp

import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.*

class JPConst {
    companion object {
        val zoneId: ZoneId = ZoneId.of("Asia/Tokyo")
        val ymdFormatter: DateTimeFormatter = createFormatter("yyyyMMdd")
        val ymdWithSlashFormatter: DateTimeFormatter = createFormatter("yyyy/MM/dd")
        val ymdShortWithSlashFormatter: DateTimeFormatter = createFormatter("yy/MM/dd")
        val ymdWithHyphenFormatter: DateTimeFormatter = createFormatter("yyyy-MM-dd")
        val ymdNotPaddingJpFormatter: DateTimeFormatter = createFormatter("yyyy年M月d日")
        val datetimeFormatter: DateTimeFormatter = createFormatter("yyyy-MM-dd HH:mm:ss")
        val datetimeWithoutSecondFormatter: DateTimeFormatter = createFormatter("yyyy-MM-dd HH:mm")
        val datetimeWithoutSecondWithSlashFormatter: DateTimeFormatter = createFormatter("yyyy/MM/dd HH:mm")
        val datetimeWithoutSecondJpFormatter: DateTimeFormatter = createFormatter("yyyy年MM月dd日HH:mm")
        val datetimeWithoutSecondNotPaddingJpFormatter: DateTimeFormatter = createFormatter("yyyy年M月d日HH:mm")
        val ymWithHyphenFormatter: DateTimeFormatter = createFormatter("yyyy-MM")
        val ymJpFormatter: DateTimeFormatter = createFormatter("yyyy年MM月")
        val ymJpNotPaddingFormatter: DateTimeFormatter = createFormatter("yyyy年M月")
        val mdFormatter: DateTimeFormatter = createFormatter("MM/dd")
        val mdNotPaddingFormatter: DateTimeFormatter = createFormatter("M/d")
        val mmddWithDayOfTheWeek: DateTimeFormatter = createFormatter("MM/dd(EE)")
        val mdNotPaddingWithDayOfTheWeek: DateTimeFormatter = createFormatter("M/d(EE)")
        val mdWithDayOfTheWeek: DateTimeFormatter = createFormatter("M/d (EE)")
        val mdWithDayOfTheWeekJp: DateTimeFormatter = createFormatter("MM月dd日(EE)")
        val mdhmNotPaddingFormatter: DateTimeFormatter = createFormatter("M月d日 HH:mm")
        val mdhmNotPaddingWithSlashFormatter: DateTimeFormatter = createFormatter("M/d(EE) HH:mm")
        val mdhmWithDayOfTheWeek: DateTimeFormatter = createFormatter("MM/dd(EE) H:mm")
        val monthNotPadding: DateTimeFormatter = createFormatter("M")
        val mdhmFormatter: DateTimeFormatter = createFormatter("MM/dd HH:mm")
        val hmFormatter: DateTimeFormatter = createFormatter("HH:mm")
        val hmWithoutColonFormatter: DateTimeFormatter = createFormatter("HHmm")
        val hmWithoutZeroPaddingFormatter: DateTimeFormatter = createFormatter("H:mm")
        val hmsFormatter: DateTimeFormatter = createFormatter("HH:mm:ss")
        val datetimeCompressFormatter: DateTimeFormatter = createFormatter("yyyyMMddHHmmss")
        val dayFormatter: DateTimeFormatter = createFormatter("dd")
        val dayNotPaddingFormatter: DateTimeFormatter = createFormatter("d")
        val dayOfTheWeekWithBracketsFormatter: DateTimeFormatter = createFormatter("(EE)")
        val dayOfTheWeekFormatter: DateTimeFormatter = createFormatter("EE")

        private fun createFormatter(format: String): DateTimeFormatter {
            return dateTimeFormatter(format).apply { withZone(zoneId) }
        }
    }
}

fun dateTimeFormatter(format: String): DateTimeFormatter {
    return DateTimeFormatter.ofPattern(format, Locale.JAPAN)
}
