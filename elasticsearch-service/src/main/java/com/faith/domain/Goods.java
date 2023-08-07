package com.faith.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

/**
 * @description:
 * @author:faith
 * @time:2023/6/1314:45
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("t_goods")
public class Goods {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    private String url;
    private BigDecimal price;
    private String title;
    private String Shop;
}
