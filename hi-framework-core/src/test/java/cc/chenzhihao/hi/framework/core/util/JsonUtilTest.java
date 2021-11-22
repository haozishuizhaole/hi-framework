package cc.chenzhihao.hi.framework.core.util;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * @author jacksonchenzhihao
 * @date 2021-11-18 19:28
 */
class JsonUtilTest {

    @Test
    void toJsonString() {
        User user = new User();
        user.setBirth(LocalDateTime.now());
        user.setBirthDay(LocalDate.now());
        user.setBirthTime(LocalTime.now());
        System.out.println("----JsonUtil.toJsonString(user)");
        System.out.println(JsonUtil.toJsonString(user));
        System.out.println("----JsonUtil.toJsonString(user,true)");
        System.out.println(JsonUtil.toJsonString(user, true));
    }


    static class User {
        private LocalDateTime birth;
        private LocalDate birthDay;
        private LocalTime birthTime;

        public LocalDateTime getBirth() {
            return birth;
        }

        public void setBirth(LocalDateTime birth) {
            this.birth = birth;
        }

        public LocalDate getBirthDay() {
            return birthDay;
        }

        public void setBirthDay(LocalDate birthDay) {
            this.birthDay = birthDay;
        }

        public LocalTime getBirthTime() {
            return birthTime;
        }

        public void setBirthTime(LocalTime birthTime) {
            this.birthTime = birthTime;
        }
    }

}