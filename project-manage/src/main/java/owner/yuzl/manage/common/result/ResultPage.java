package owner.yuzl.manage.common.result;

import lombok.Data;

import java.util.List;

/**
 * @Author：yzl_c
 * @Date：2020/1/21 19:12
 * @Description：
 */
@Data
public class ResultPage {
    private Long total;

    private Integer pageNum;

    private List dataList;

    public ResultPage(Long total, Integer pageNum, List dataList) {
        this.total = total;
        this.pageNum = pageNum;
        this.dataList = dataList;
    }
}
