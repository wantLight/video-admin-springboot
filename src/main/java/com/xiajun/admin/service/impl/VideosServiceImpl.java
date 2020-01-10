package com.xiajun.admin.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiajun.admin.mapper.VideosMapper;
import com.xiajun.admin.pojo.Videos;
import com.xiajun.admin.pojo.vo.EchartsVo;
import com.xiajun.admin.pojo.vo.VideosVO;
import com.xiajun.admin.service.IVideosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 视频信息表 服务实现类
 * </p>
 *
 * @author lx
 * @since
 */
@Service
public class VideosServiceImpl extends ServiceImpl<VideosMapper, Videos> implements IVideosService {
    @Autowired
    private VideosMapper videosMapper;


    @Override
    public Page<VideosVO> page(Page<VideosVO> page) {
        return page.setRecords(videosMapper.queryAllVideos(page));
    }

    @Override
    public List<EchartsVo> getVideoNum() {

        return videosMapper.getVideoNum();
    }
}
