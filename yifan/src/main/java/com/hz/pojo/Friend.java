package com.hz.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Friend implements Serializable {

    private Long friendId;
    private String friendTitle;
    private String friendDesc;
    private String friendUrl;
    private String friendImg;
    private LocalDateTime friendTime;

}
