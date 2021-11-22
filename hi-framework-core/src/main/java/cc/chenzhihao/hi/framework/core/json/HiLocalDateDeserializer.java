package cc.chenzhihao.hi.framework.core.json;

import cc.chenzhihao.hi.framework.core.util.DateUtil;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.time.LocalDate;

/**
 * @author jacksonchenzhihao
 * @date 2021-11-18 20:23
 */
public class HiLocalDateDeserializer extends JsonDeserializer<LocalDate> {

    public final static HiLocalDateDeserializer INSTANCE = new HiLocalDateDeserializer();

    @Override
    public LocalDate deserialize(JsonParser parser, DeserializationContext context) throws IOException {
        long milli;
        try {
            milli = parser.getLongValue();
        } catch (Exception e) {
            return null;
        }
        return DateUtil.millTimestamp2LocalDate(milli);
    }
}
