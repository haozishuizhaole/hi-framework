package cc.chenzhihao.hi.framework.core.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author jacksonchenzhihao
 * @date 2021-11-22 18:08
 */
class DateUtilTest {

    @Test
    void plusDays() {
        LocalDate source = LocalDate.of(2021, 1, 1);
        LocalDate target = LocalDate.of(2021, 1, 4);
        LocalDate test = DateUtil.plusDays(source, 3);
        Assertions.assertEquals(target, test);
    }

    @Test
    void diffYears() {
        LocalDate source = LocalDate.of(2001, 1, 1);
        LocalDate target = LocalDate.of(2021, 1, 4);
        long diffYears = DateUtil.diffYears(source, target);
        Assertions.assertEquals(diffYears, 20);
    }

    @Test
    void testDiffYears() {
        LocalDateTime source = LocalDateTime.of(2001, 1, 1, 11, 23, 45);
        LocalDateTime target = LocalDateTime.of(2021, 1, 4, 11, 23, 45);
        long diffYears = DateUtil.diffYears(source, target);
        Assertions.assertEquals(diffYears, 20);
    }

    @Test
    void diffMonths() {
        LocalDate source = LocalDate.of(2021, 1, 1);
        LocalDate target = LocalDate.of(2021, 8, 4);
        long diffMonths = DateUtil.diffMonths(source, target);
        Assertions.assertEquals(diffMonths, 7);

        LocalDate source1 = LocalDate.of(2021, 1, 1);
        LocalDate target1 = LocalDate.of(2022, 8, 4);
        long diffMonths1 = DateUtil.diffMonths(source1, target1);
        Assertions.assertEquals(diffMonths1, 19);
    }

    @Test
    void testDiffMonths() {
        LocalDateTime source = LocalDateTime.of(2021, 1, 1, 11, 23, 45);
        LocalDateTime target = LocalDateTime.of(2021, 4, 4, 11, 23, 45);
        long diffMonths = DateUtil.diffMonths(source, target);
        Assertions.assertEquals(diffMonths, 3);
    }

    @Test
    void diffWeeks() {
        LocalDateTime source = LocalDateTime.of(2021, 1, 1, 11, 23, 45);
        LocalDateTime target = LocalDateTime.of(2021, 1, 22, 11, 23, 45);
        long diffWeeks = DateUtil.diffWeeks(source, target);
        Assertions.assertEquals(diffWeeks, 3);
    }

    @Test
    void testDiffWeeks() {
        LocalDate source = LocalDate.of(2021, 1, 1);
        LocalDate target = LocalDate.of(2021, 1, 21);
        long diffWeeks = DateUtil.diffWeeks(source, target);
        Assertions.assertEquals(diffWeeks, 2);
    }

    @Test
    void diffDays() {
        LocalDate source = LocalDate.of(2021, 1, 1);
        LocalDate target = LocalDate.of(2021, 1, 21);
        long diffDays = DateUtil.diffDays(source, target);
        Assertions.assertEquals(diffDays, 20);
    }

    @Test
    void testDiffDays() {
        LocalDateTime source = LocalDateTime.of(2021, 1, 1, 1, 1, 1);
        LocalDateTime target = LocalDateTime.of(2021, 1, 21, 1, 1, 50);
        long diffDays = DateUtil.diffDays(source, target);
        Assertions.assertEquals(diffDays, 20);
    }
}