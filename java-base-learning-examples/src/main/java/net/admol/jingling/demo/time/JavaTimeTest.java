package net.admol.jingling.demo.time;

import lombok.extern.slf4j.Slf4j;

import java.time.*;
import java.time.temporal.TemporalAdjusters;

/**
 * @author : jingling
 * @Date : 2018/5/27
 */
@Slf4j
public class JavaTimeTest {

    public static void main(String[] args) {
        LocalDate nowDate  = LocalDate.now();
        log.info("当前日期 nowDate:{}",nowDate);
        log.info("本月第一天 date:{}",nowDate.withDayOfMonth(1));
        log.info("本月第一天 date:{}",nowDate.with(TemporalAdjusters.lastDayOfMonth()));
        log.info("本月天数 days:{}",nowDate.lengthOfMonth());
        LocalTime nowTime =LocalTime.now();
        log.info("当前时间 nowTime:{}",nowTime);
        log.info("当前时间 nowTime:{}",nowTime.withNano(0));
        LocalTime localTime = LocalTime.of(23,59,58);
        log.info("指定时间 time:{}",localTime);
        LocalTime time2 = LocalTime.parse("23:59:58");
        log.info("指定时间 time2:{}",time2);
        LocalDateTime now = LocalDateTime.now().withDayOfMonth(1);
        log.info("当前日期时间 now:{}",now);

        final Clock clock = Clock.systemUTC();
        System.out.println( clock.instant() );
        System.out.println( clock.millis() );
        System.out.println( clock.millis()  == System.currentTimeMillis());

        // Get the local date and local time
        final LocalDate date = LocalDate.now();
        final LocalDate dateFromClock = LocalDate.now( clock );
        System.out.println( date );
        System.out.println( dateFromClock );
        // Get the local date and local time
        final LocalTime time = LocalTime.now();
        final LocalTime timeFromClock = LocalTime.now( clock );
        System.out.println( time );
        System.out.println( timeFromClock );

        // Get the local date/time
        final LocalDateTime datetime = LocalDateTime.now();
        final LocalDateTime datetimeFromClock = LocalDateTime.now( clock );
        System.out.println( datetime );
        System.out.println( datetimeFromClock );

        // Get the zoned date/time
        final ZonedDateTime zonedDatetime = ZonedDateTime.now();
        final ZonedDateTime zonedDatetimeFromClock = ZonedDateTime.now( clock );
        final ZonedDateTime zonedDatetimeFromZone = ZonedDateTime.now( ZoneId.of( "America/Los_Angeles" ) );
        System.out.println( zonedDatetime );
        System.out.println( zonedDatetimeFromClock );
        System.out.println( zonedDatetimeFromZone );

        // Get duration between two dates
        final LocalDateTime from = LocalDateTime.of( 2014, Month.APRIL, 16, 0, 0, 0 );
        final LocalDateTime to = LocalDateTime.of( 2015, Month.APRIL, 16, 23, 59, 59 );
        final Duration duration = Duration.between( from, to );
        System.out.println( "Duration in days: " + duration.toDays() );
        System.out.println( "Duration in hours: " + duration.toHours() );
    }
}
