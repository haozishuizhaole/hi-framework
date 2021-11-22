package cc.chenzhihao.hi.framework.core.json;

import cc.chenzhihao.hi.framework.core.util.DateUtil;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.time.LocalTime;

/**
 * @author jacksonchenzhihao
 * @date 2021-11-18 20:23
 */
public class HiLocalTimeDeserializer extends JsonDeserializer<LocalTime> {

    public final static HiLocalTimeDeserializer INSTANCE = new HiLocalTimeDeserializer();

    @Override
    public LocalTime deserialize(JsonParser parser, DeserializationContext context) throws IOException {
        String timeStr;
        try {
            timeStr = parser.getValueAsString();
        } catch (Exception e) {
            return null;
        }
        return DateUtil.parseLocalTime(timeStr, DateUtil.PATTERN_LOCAL_TIME);
    }
}
