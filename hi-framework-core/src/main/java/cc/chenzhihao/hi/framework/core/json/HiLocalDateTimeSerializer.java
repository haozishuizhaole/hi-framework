package cc.chenzhihao.hi.framework.core.json;

import cc.chenzhihao.hi.framework.core.util.DateUtil;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.time.LocalDateTime;

/**
 * @author jacksonchenzhihao
 * @date 2021-11-18 20:23
 */
public class HiLocalDateTimeSerializer extends JsonSerializer<LocalDateTime> {

    public static final HiLocalDateTimeSerializer INSTANCE = new HiLocalDateTimeSerializer();

    @Override
    public void serialize(LocalDateTime value, JsonGenerator g, SerializerProvider provider) throws IOException {
        if (value == null) {
            g.writeNull();
        } else {
            g.writeString(String.valueOf(DateUtil.millTimestamp(value)));
        }
    }
}
