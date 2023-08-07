package com.faith.domain;/**
 * @Author: faith
 * @Description: TODO
 * @DateTime: 2023/5/31 16:13
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
 *@time:2023/5/3116:13
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("teacher")
public class Teacher implements Serializable
{
    @TableId("id")
    private Long id;
    @TableField("teacherName")
    private String teacherName;
}
