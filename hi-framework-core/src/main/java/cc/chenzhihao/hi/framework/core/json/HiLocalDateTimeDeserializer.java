package cc.chenzhihao.hi.framework.core.json;

import cc.chenzhihao.hi.framework.core.util.DateUtil;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.time.LocalDateTime;

/**
 * @author jacksonchenzhihao
 * @date 2021-11-18 20:23
 */
public class HiLocalDateTimeDeserializer extends JsonDeserializer<LocalDateTime> {

    public final static HiLocalDateTimeDeserializer INSTANCE = new HiLocalDateTimeDeserializer();

    @Override
    public LocalDateTime deserialize(JsonParser parser, DeserializationContext context) throws IOException {
        long milli;
        try {
            milli = parser.getLongValue();
        } catch (Exception e) {
            return null;
        }
        return DateUtil.millTimestamp2LocalDateTime(milli);
    }
}
