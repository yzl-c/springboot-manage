package owner.yuzl.manage.entity.base;

import java.util.List;

/**
 * @Author：yzl_c
 * @Date：2020/1/2 16:17
 * @Description：分页实体类
 */
public class BasePage<T> {
    private static final long serialVersionUID = 5760097915453738435L;
    public static final int DEFAULT_PAGE_SIZE = 10;
    /**
     * 每页显示个数 
     */
    private int pageSize;
    /**
     * 当前页数 
     */
    private int currentPage;
    /**
     * 当前页数第一条下标
     */
    private int currentBeginIndex;
    /**
     * 总页数 
     */
    private int totalPage;
    /**
     * 总记录数 
     */
    private int totalCount;
    /**
     * 结果列表 
     */
    private List<T> dataList;

    public BasePage(){
        this.currentPage = 1;
        this.pageSize = DEFAULT_PAGE_SIZE;
        this.currentBeginIndex = (this.currentPage - 1) * pageSize;
    }

    public BasePage(int currentPage, int pageSize){
        this.currentPage = currentPage <= 0 ? 1 : currentPage;
        this.pageSize = pageSize <= 0 ? 1 : pageSize;
        this.currentBeginIndex = (this.currentPage - 1) * pageSize;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        //设置了totalCount就可以计算出总totalPage  
        this.totalCount = totalCount;
        int countRecords = this.getTotalCount();
        int totalPages = countRecords % pageSize == 0 ? countRecords / pageSize : (countRecords / pageSize + 1);
        setTotalPage(totalPages);
    }

    public List<T> getDataList() {
        return dataList;
    }
    public void setDataList(List<T> dataList) {
        this.dataList = dataList;
    }

    public int getCurrentBeginIndex() {
        return currentBeginIndex;
    }

    public void setCurrentBeginIndex(int currentBeginIndex) {
        this.currentBeginIndex = currentBeginIndex;
    }
}
