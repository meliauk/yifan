package com.hz.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.security.Principal;

@ApiModel(value="user对象")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {

    @TableId(type = IdType.AUTO)
    private Integer uId;
    @ApiModelProperty("姓名")
    private String uName;
    @ApiModelProperty("密码")
    private String uPassword;
    @ApiModelProperty("描述")
    private String uDesc;
    @ApiModelProperty("邮箱")
    private String uEmail;
    @ApiModelProperty("权限")
    private String uPower;
    @ApiModelProperty("状态")
    private Integer uState;


}
