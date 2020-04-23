package net.admol.jingling.demo.time;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
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
        LocalTime time = LocalTime.of(23,59,58);
        log.info("指定时间 time:{}",time);
        LocalTime time2 = LocalTime.parse("23:59:58");
        log.info("指定时间 time2:{}",time2);
        LocalDateTime now = LocalDateTime.now().withDayOfMonth(1);
        log.info("当前日期时间 now:{}",now);


    }
}
