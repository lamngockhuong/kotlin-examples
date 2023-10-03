package com.ngockhuong.someutils.utils.en

import com.ngockhuong.someutils.utils.en.ENConst.Companion.zoneId
import java.time.LocalDateTime
import java.time.ZoneId

object ENDateTimeUtils {
    fun getNow(): LocalDateTime {
        return LocalDateTime.now(zoneId)
    }

    fun getSytemNow(format: String): String {
        val df = dateTimeFormatter(format)
        return df.format(LocalDateTime.now())
    }

    fun toZone(source: LocalDateTime): LocalDateTime {
        return LocalDateTime.from(source)
            .atZone(ZoneId.systemDefault()) // current zone
            .withZoneSameInstant(ZoneId.of("America/New_York")) // new zone
            .toLocalDateTime()
    }
}
