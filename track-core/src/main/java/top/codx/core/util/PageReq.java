package top.codx.core.util;

import com.github.pagehelper.IPage;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Arrays;

/**
 * @author lch mailto:{yulwins@163.com}
 * @since 2023-04-28 10:31
 */
@Data
public class PageReq implements IPage {

    public static final String ASC = "ASC";

    public static final String DESC = "DESC";

    /**
     * 最大分页大小，如果分页大小大于500，则用500作为分页的大小。防止有人直接传入一个较大的数，导致服务器内存溢出宕机
     */
    public static final Integer MAX_PAGE_SIZE = 500;

    /**
     * 当前页
     */
    @NotNull(message = "pageNum 不能为空")
    @ApiModelProperty(name = "当前页", notes = "当前页")
    private Integer pageNum = 1;

    @NotNull(message = "pageSize 不能为空")
    @ApiModelProperty(name = "每页大小", notes = "每页大小")
    private Integer pageSize = 10;

    @ApiModelProperty(name = "排序字段数组，用逗号分割", notes = "排序字段数组，用逗号分割")
    private String[] columns;

    @ApiModelProperty(name = "排序字段方式，用逗号分割，ASC正序，DESC倒序", notes = "排序字段方式，用逗号分割，ASC正序，DESC倒序")
    private String[] orders;

    @Override
    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    @Override
    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        if (pageSize > MAX_PAGE_SIZE) {
            this.pageSize = MAX_PAGE_SIZE;
            return;
        }
        this.pageSize = pageSize;
    }

    @Override
    public String getOrderBy() {
        return order(this.columns, this.orders);
    }

    public String[] getColumns() {
        return columns;
    }

    public void setColumns(String[] columns) {
        this.columns = columns;
    }

    public String[] getOrders() {
        return orders;
    }

    public void setOrders(String[] orders) {
        this.orders = orders;
    }

    public static String order(String[] columns, String[] orders) {

        if (columns == null || columns.length == 0) {
            return "";
        }

        StringBuilder stringBuilder = new StringBuilder();

        for (int x = 0; x < columns.length; x++) {

            String column = columns[x];
            String order;

            if (orders != null && orders.length > x) {
                order = orders[x].toUpperCase();
                if (!(order.equals(ASC) || order.equals(DESC))) {
                    throw new IllegalArgumentException("非法的排序策略：" + orders[x]);
                }
            } else {
                order = ASC;
            }

            // 判断列名称的合法性，防止SQL注入。只能是【字母，数字，下划线】
            if (PrincipalUtil.isField(column)) {
                throw new IllegalArgumentException("非法的排序字段名称：" + column);
            }

            // 驼峰转换为下划线
            column = humpConversionUnderscore(column);

            if (x != 0) {
                stringBuilder.append(", ");
            }
            stringBuilder.append(column).append(" ").append(order);
        }
        return stringBuilder.toString();
    }

    public static String humpConversionUnderscore(String value) {
        StringBuilder stringBuilder = new StringBuilder();
        char[] chars = value.toCharArray();
        for (char character : chars) {
            if (Character.isUpperCase(character)) {
                stringBuilder.append("_");
                character = Character.toLowerCase(character);
            }
            stringBuilder.append(character);
        }
        return stringBuilder.toString();
    }

    @Override
    public String toString() {
        return "PageDTO{" +
                "pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                ", columns=" + Arrays.toString(columns) +
                ", orders=" + Arrays.toString(orders) +
                '}';
    }
}
