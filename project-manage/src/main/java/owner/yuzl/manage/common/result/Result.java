package owner.yuzl.manage.common.result;


import lombok.Data;

import java.util.HashMap;

/**
 * @Author：yzl_c
 * @Date：2020/1/18 21:50
 * @Description：返回数据实体类
 */
@Data
public class Result {

    private Object data;
    private HashMap<String,Object> meta =new HashMap<>();

    public Result(Object data, String msg, Integer status) {
        meta.put("msg",msg);
        meta.put("status",status);
        this.data = data;
    }

}
