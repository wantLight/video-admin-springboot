package com.xiajun.admin.pojo.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 视频信息表
 * </p>
 *
 * @author lx
 *
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)

public class VideosVO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;


    private String userId;


    private String audioId;


    private String videoDesc;


    private String videoPath;


    private Float videoSeconds;


    private Integer videoWidth;


    private Integer videoHeight;


    private String coverPath;


    private Long likeCounts;

    //初始化为0 待审核
    private Integer status;

    @JsonFormat(pattern = "yyyy-MM-dd mm:HH:ss")
    private Date createTime;

    private String faceImage;
    private String nickname;


}
