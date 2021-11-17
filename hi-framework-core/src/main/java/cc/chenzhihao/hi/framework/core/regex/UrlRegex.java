package cc.chenzhihao.hi.framework.core.regex;

import java.util.regex.Pattern;

/**
 * 域名、网址 正则
 *
 * @author jacksonchenzhihao
 * @date 2021-11-17 21:16
 */
public class UrlRegex {

    public static final Pattern REALM_NAME_PATTERN = Pattern.compile("^(?=^.{3,255}$)[a-zA-Z0-9][-a-zA-Z0-9]{0,62}(\\.[a-zA-Z0-9][-a-zA-Z0-9]{0,62})+$");

    public static final Pattern REALM_NAME_WITH_PROTOCOL_AND_PORT_PATTERN = Pattern.compile("^(?=^.{3,255}$)(http(s)?://)?(www\\.)?[a-zA-Z0-9][-a-zA-Z0-9]{0,62}(\\.[a-zA-Z0-9][-a-zA-Z0-9]{0,62})+(:\\d+)*(/\\w+\\.\\w+)*$");

}
