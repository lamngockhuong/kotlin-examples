package com.ngockhuong.someutils.controller

import com.ngockhuong.someutils.utils.en.ENConst
import com.ngockhuong.someutils.utils.en.ENDateTimeUtils
import com.ngockhuong.someutils.utils.jp.JPConst
import com.ngockhuong.someutils.utils.jp.JPDateTimeUtils
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDateTime

@RestController
@RequestMapping("date-time")
class DateTimeController {
    @GetMapping("jp")
    fun jpDateTime(): Map<String, Any> {
        val now = LocalDateTime.now() // Get current system date time
        val jpNow = JPDateTimeUtils.getNow() // Get current date time by JP zone
        return mapOf(
            "System date time now" to now,
            "JP date time now" to jpNow,
            "Convert from system datetime to JP datetime" to JPDateTimeUtils.toZone(now),
            "Format: dd/MM/yyyy HH:mm:ss" to JPDateTimeUtils.getSystemNow("dd/MM/yyyy HH:mm:ss"),
            "Format: yyyyMMdd" to JPConst.ymdFormatter.format(jpNow),
            "Format: yyyy/MM/dd" to JPConst.ymdWithSlashFormatter.format(jpNow),
        )
    }

    @GetMapping("en")
    fun enDateTime(): Map<String, Any> {
        val now = LocalDateTime.now() // Get current system date time
        val enNow = ENDateTimeUtils.getNow() // Get current date time by US zone
        return mapOf(
            "System date time now" to now,
            "US date time now" to enNow,
            "Convert from system datetime to US datetime" to ENDateTimeUtils.toZone(now),
            "Format: dd/MM/yyyy HH:mm:ss" to ENDateTimeUtils.getSytemNow("dd/MM/yyyy HH:mm:ss"),
            "Format: yyyy-MM-dd HH:mm:ss" to ENConst.datetimeFormatter.format(enNow),
            "Format: yyyy/MM/dd HH:mm" to ENConst.datetimeWithoutSecondWithSlashFormatter.format(enNow),
            "Format: d" to ENConst.dayNotPaddingFormatter.format(enNow),
            "Format: EE" to ENConst.dayOfTheWeekFormatter.format(enNow),
        )
    }
}
