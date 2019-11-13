package com.log4j2.admin.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * <p>
 * 权限表
 * </p>
 *
 * @author jian
 * @since 2019-10-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="SysPermission对象", description="权限表")
public class SysPermission implements Serializable {


    private static final long serialVersionUID = -621817085341971177L;
    @ApiModelProperty(value = "id")
    @TableId("id")
    private String id;

    @ApiModelProperty(value = "权限名称")
    private String name;

    @ApiModelProperty(value = "权限链接")
    private String url;

    @ApiModelProperty(value = "状态")
    private String status;

    @ApiModelProperty(value = "权限类型")
    private String type;

    @ApiModelProperty(value = "描述")
    private String remarks;

    @ApiModelProperty(value = "权限代码")
    private String code;

    @ApiModelProperty(value = "创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    @ApiModelProperty(value = "更新时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    @ApiModelProperty(value = "父ID ")
    @TableField("parentId")
    private String parentId;

    @TableField(exist = false)
    private Set<SysRole> roles = new HashSet<>();

}
