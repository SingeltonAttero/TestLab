package com.yakow.weber.myapplication.utils

import org.joda.time.DateTime
import org.joda.time.DateTimeZone
import org.joda.time.LocalDateTime
import org.joda.time.format.DateTimeFormat

/**
 * Created on 13.03.19
 * @author YWeber */
fun fromString(dateTime: String): DateTime? {
    if (dateTime.isEmpty()) {
        return null
    }
    val parse = DateTime.parse(dateTime)
    return LocalDateTime(parse).toDateTime(DateTimeZone.UTC)
}

fun userDateFormat(dateTime: DateTime?): String {
    val pattern = DateTimeFormat.forPattern("dd/MM/yyyy")
    return dateTime?.toString(pattern).orEmpty()
}