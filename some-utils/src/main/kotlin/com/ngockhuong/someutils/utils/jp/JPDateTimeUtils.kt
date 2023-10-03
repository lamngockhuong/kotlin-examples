package com.ngockhuong.someutils.utils.jp

import com.ngockhuong.someutils.utils.jp.JPConst.Companion.zoneId
import java.time.LocalDateTime
import java.time.ZoneId

object JPDateTimeUtils {
    fun getNow(): LocalDateTime {
        return LocalDateTime.now(zoneId)
    }

    fun getSystemNow(format: String): String {
        val df = dateTimeFormatter(format)
        return df.format(LocalDateTime.now())
    }

    fun toZone(source: LocalDateTime): LocalDateTime {
        return LocalDateTime.from(source)
            .atZone(ZoneId.systemDefault()) // current zone
            .withZoneSameInstant(ZoneId.of("Asia/Tokyo")) // new zone
            .toLocalDateTime()
    }
}
