package cc.chenzhihao.hi.framework.core.json;

import cc.chenzhihao.hi.framework.core.util.DateUtil;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.time.LocalTime;

/**
 * @author jacksonchenzhihao
 * @date 2021-11-18 20:23
 */
public class HiLocalTimeSerializer extends JsonSerializer<LocalTime> {

    public static final HiLocalTimeSerializer INSTANCE = new HiLocalTimeSerializer();

    @Override
    public void serialize(LocalTime value, JsonGenerator g, SerializerProvider provider) throws IOException {
        if (value == null) {
            g.writeNull();
        } else {
            g.writeString(DateUtil.formatLocalTime(value, DateUtil.PATTERN_LOCAL_TIME));
        }
    }
}
