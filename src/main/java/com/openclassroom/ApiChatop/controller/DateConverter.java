package com.openclassroom.ApiChatop.controller;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

/*
 * Convert the date to the local zone
 *
 * */
public class DateConverter {

    public Date convertToDateViaInstant(LocalDate dateToConvert) {
        ZoneId defaultZoneId = ZoneId.systemDefault();
        return Date.from(dateToConvert.atStartOfDay(defaultZoneId).toInstant());
    }
}
