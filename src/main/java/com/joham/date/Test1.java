package com.joham.date;

import org.apache.commons.lang.StringUtils;

import java.time.LocalDate;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 星期几
 *
 * @author joham
 */
public class Test1 {

    public static void main(String[] args) {
        System.out.println("星期" + LocalDate.now().getDayOfWeek().getValue());
        if (7 == LocalDate.now().getDayOfWeek().getValue()) {
            System.out.println(11);
        }
    }
}
