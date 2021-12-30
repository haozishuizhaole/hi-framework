package cc.chenzhihao.hi.framework.core.util;

import cc.chenzhihao.hi.framework.core.exception.Exceptions;
import cc.chenzhihao.hi.framework.core.json.HiLocalDateDeserializer;
import cc.chenzhihao.hi.framework.core.json.HiLocalDateSerializer;
import cc.chenzhihao.hi.framework.core.json.HiLocalDateTimeDeserializer;
import cc.chenzhihao.hi.framework.core.json.HiLocalDateTimeSerializer;
import cc.chenzhihao.hi.framework.core.json.HiLocalTimeDeserializer;
import cc.chenzhihao.hi.framework.core.json.HiLocalTimeSerializer;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * JSON工具类
 *
 * @author jacksonchenzhihao
 * @date 2021-11-18 19:17
 */
public class JsonUtil {

    private final static ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    static {
        OBJECT_MAPPER.registerModule(javaTimeModule());
        OBJECT_MAPPER.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
        OBJECT_MAPPER.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
    }

    private static JavaTimeModule javaTimeModule() {
        JavaTimeModule module = new JavaTimeModule();
        module.addSerializer(LocalDateTime.class, HiLocalDateTimeSerializer.INSTANCE);
        module.addDeserializer(LocalDateTime.class, HiLocalDateTimeDeserializer.INSTANCE);
        module.addSerializer(LocalDate.class, HiLocalDateSerializer.INSTANCE);
        module.addDeserializer(LocalDate.class, HiLocalDateDeserializer.INSTANCE);
        module.addSerializer(LocalTime.class, HiLocalTimeSerializer.INSTANCE);
        module.addDeserializer(LocalTime.class, HiLocalTimeDeserializer.INSTANCE);
        return module;
    }

    private JsonUtil() {
        throw new UnsupportedOperationException("JsonUtil can not be instantiate");
    }

    /**
     * 对象转JSON字符串
     *
     * @param value 对象
     * @return JSON字符串
     */
    public static String toJsonString(Object value) {
        return toJsonString(value, false);
    }

    /**
     * 对象转JSON字符串
     *
     * @param value  对象
     * @param pretty 是否美化展示
     * @return JSON字符串
     */
    public static String toJsonString(Object value, boolean pretty) {
        ObjectWriter writer = OBJECT_MAPPER.writer();
        if (pretty) {
            writer = OBJECT_MAPPER.writerWithDefaultPrettyPrinter();
        }
        String result;
        try {
            result = writer.writeValueAsString(value);
        } catch (JsonProcessingException e) {
            throw Exceptions.toSystemException(e);
        }
        return result;
    }

    public static <T> T toObject(String json, Class<T> clazz) {
        T result;
        try {
            result = OBJECT_MAPPER.readValue(json, clazz);
        } catch (JsonProcessingException e) {
            throw Exceptions.toSystemException(e);
        }
        return result;
    }

    public static JsonNode toTree(String json) {
        JsonNode node;
        try {
            node = OBJECT_MAPPER.readTree(json);
        } catch (JsonProcessingException e) {
            throw Exceptions.toSystemException(e);
        }
        return node;
    }
}
