package owner.yuzl.manage.common.util;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @Author：yzl_c
 * @Date：2020/1/19 12:54
 * @Description：
 */
public class JsonUtils {
    private static ObjectMapper objectMapper = new ObjectMapper();
    /**
     * 对象转json
     * @param obj
     * @param <T>
     * @return
     */
    public static <T> String toJson(T obj){
         if (obj == null){
         }
        try {
            return obj instanceof String ? (String) obj : objectMapper.writeValueAsString(obj);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
