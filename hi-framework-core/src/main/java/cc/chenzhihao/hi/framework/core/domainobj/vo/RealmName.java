package cc.chenzhihao.hi.framework.core.domainobj.vo;

import cc.chenzhihao.hi.framework.core.exception.Exceptions;
import cc.chenzhihao.hi.framework.core.mark.ValueObject;
import cc.chenzhihao.hi.framework.core.regex.UrlRegex;
import cc.chenzhihao.hi.framework.core.util.Precondition;

import java.util.Objects;
import java.util.regex.Pattern;

/**
 * 域名 值对象
 *
 * @author jacksonchenzhihao
 * @date 2021-11-17 20:36
 */

public class RealmName implements ValueObject {

    /**
     * 值
     */
    private final String value;

    /**
     * 域名模式
     */
    private final RealmMode realmMode;

    public RealmName(String value, RealmMode realmMode) {
        this.value = value;
        this.realmMode = Objects.nonNull(realmMode) ? realmMode : RealmMode.NORMAL;
        Precondition.checkArgument(realmMode.match(value), "域名非法");
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RealmName)) {
            return false;
        }
        RealmName realmName = (RealmName) o;
        return value.equals(realmName.value) && realmMode == realmName.realmMode;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, realmMode);
    }

    @Override
    public String toString() {
        return "RealmName{" +
                "value='" + value + '\'' +
                ", realmMode=" + realmMode +
                '}';
    }

    public enum RealmMode {

        /**
         * 普通域名
         */
        NORMAL(UrlRegex.REALM_NAME_PATTERN),

        /**
         * 带协议和端口号的域名
         */
        WITH_PROTOCOL_AND_PORT(UrlRegex.REALM_NAME_WITH_PROTOCOL_AND_PORT_PATTERN);

        private final Pattern pattern;

        RealmMode(Pattern pattern) {
            this.pattern = pattern;
        }

        public boolean match(String realmName) {
            return pattern.matcher(realmName).matches();
        }
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        RealmName realmName;
        try {
            realmName = (RealmName) super.clone();
        } catch (CloneNotSupportedException e) {
            throw Exceptions.toSystemException(e);
        }
        return realmName;
    }
}
