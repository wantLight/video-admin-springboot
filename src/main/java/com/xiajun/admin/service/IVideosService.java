package com.xiajun.admin.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xiajun.admin.pojo.Videos;
import com.xiajun.admin.pojo.vo.EchartsVo;
import com.xiajun.admin.pojo.vo.VideosVO;

import java.util.List;

/**
 * <p>
 * 视频信息表 服务类
 * </p>
 *
 * @author lx
 * @since
 */
public interface IVideosService extends IService<Videos> {

    Page<VideosVO> page(Page<VideosVO> page);

    List<EchartsVo> getVideoNum();

}
