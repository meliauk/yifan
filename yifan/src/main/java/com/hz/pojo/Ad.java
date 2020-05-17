package com.hz.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ad implements Serializable {

    private Integer adId;
    private String adTitle;
    private String adUrl;
    private String adImg;
    private LocalDateTime adGmtStart;
    private LocalDateTime adGmtEnd;
    private LocalDateTime adGmtCreate;
    private String adPos;
    private Integer adStatus;


}
