package com.log4j2.admin.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 菜单表
 * </p>
 *
 * @author jian
 * @since 2019-10-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="SysMenu对象", description="菜单表")
public class SysMenu implements Serializable {


    private static final long serialVersionUID = 2542931672133235930L;
    @ApiModelProperty(value = "id")
    @TableId("id")
    private String id;

    @ApiModelProperty(value = "标题")
    private String title;

    @ApiModelProperty(value = "页面路径")
    private String href;

    @ApiModelProperty(value = "字体来源")
    @TableField("fontFamily")
    private String fontFamily;

    @ApiModelProperty(value = "字体图标")
    private String icon;

    @ApiModelProperty(value = "设置是否打开")
    private Boolean spread;

    @ApiModelProperty(value = "是否选中")
    @TableField("isCheck")
    private Boolean isCheck;

    @ApiModelProperty(value = "打开方式 _blank：覆盖当前窗口")
    private String target;

    @ApiModelProperty(value = "父id")
    private String pid;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "更新时间")
    private Date updateTime;


}
