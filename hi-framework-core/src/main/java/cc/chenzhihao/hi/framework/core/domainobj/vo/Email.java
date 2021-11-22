package cc.chenzhihao.hi.framework.core.domainobj.vo;

import cc.chenzhihao.hi.framework.core.mark.ValueObject;
import cc.chenzhihao.hi.framework.core.regex.Regex;
import cc.chenzhihao.hi.framework.core.util.Precondition;

import java.util.Objects;

/**
 * Email 值对象
 *
 * @author jacksonchenzhihao
 * @date 2021-11-22 20:33
 */
public class Email implements ValueObject {

    private final String value;

    public Email(String value) {
        this.value = value;
        Precondition.checkArgument(Regex.EMAIL_PATTERN.matcher(value).matches(), "email非法");
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Email)) {
            return false;
        }
        Email email = (Email) o;
        return value.equals(email.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
