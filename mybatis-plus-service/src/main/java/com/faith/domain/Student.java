package com.faith.domain;/**
 * @Author: faith
 * @Description: TODO
 * @DateTime: 2023/5/31 16:12
 **/

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 *@description:
 *@author:faith
 *@time:2023/5/3116:12
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("stu")
public class Student implements Serializable {
    @TableId(value = "id")
    private Long id;
    @TableField(value = "stuName")
    private String stuName;
    @TableField(value = "teacherId")
    private Long teacherId;
    private Data createTime;
    private Data updateTime;
}
