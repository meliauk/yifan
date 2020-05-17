package com.hz.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Blog implements Serializable {

    @TableId(type = IdType.AUTO)
    private Long blogId;
    private String blogTitle;
    private String blogDesc;
    private String blogContent;
    private String blogAuthor;
    private String blogCoverImg;
    private LocalDateTime blogTime;
    private Long blogRead;
    private Long blogComm;
    private Long blogLike;
    private Integer blogType;
    private String  blogPublishType;


}
