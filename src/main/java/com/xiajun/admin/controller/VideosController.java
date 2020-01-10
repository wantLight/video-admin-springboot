package com.xiajun.admin.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xiajun.admin.enums.VideoStatusEnum;
import com.xiajun.admin.pojo.UsersReport;
import com.xiajun.admin.pojo.Videos;
import com.xiajun.admin.pojo.vo.EchartsVo;
import com.xiajun.admin.pojo.vo.VideosVO;
import com.xiajun.admin.service.impl.UsersReportServiceImpl;
import com.xiajun.admin.service.impl.VideosServiceImpl;
import com.xiajun.admin.utils.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 视频信息表 前端控制器
 * </p>
 *
 * @author lx
 * @since
 */
@RestController
@RequestMapping("/videos")
public class VideosController {
    @Autowired
    private VideosServiceImpl videoService;
    @Autowired
    private UsersReportServiceImpl usersReportService;



    @PostMapping("/reportList")
    public IPage<UsersReport> reportList(IPage<UsersReport> page) {

        page = usersReportService.page(page);
        return page;
    }


    @PostMapping("/forbidVideo")
    public JSONResult forbidVideo(@RequestBody Videos videos) {
        //videos.setStatus(VideoStatusEnum.FORBID.value);
        videoService.updateById(videos);
        QueryWrapper<UsersReport> wrapper = new QueryWrapper<>();
        wrapper.eq("deal_video_id",videos.getId());
        usersReportService.remove(wrapper);
        return JSONResult.ok();
    }

    @PostMapping(value="/list")
    public JSONResult showAll(Page<VideosVO> page) {

        Page<VideosVO> allVideos = videoService.page(page);
        return JSONResult.ok(allVideos);
    }

    /**
     * 得到视频量统计
     *
     * 每月 视频总数
     * 视频可播放
     * 视频被封禁
     *
     * @return
     */
    @PostMapping(value="/getVideoNum")
    public JSONResult getVideoNum() {
        List<EchartsVo> videoNum = videoService.getVideoNum();
        //todo 查分成数组返回给前端处理2
        Integer[] total = (Integer[]) videoNum.stream().map(echartsVo -> echartsVo.getTotal()).toArray();
        Integer[] success = (Integer[]) videoNum.stream().map(echartsVo -> echartsVo.getSuccess()).toArray();
        Integer[] wait = (Integer[]) videoNum.stream().map(echartsVo -> echartsVo.getWait()).toArray();
        Integer[] error = (Integer[]) videoNum.stream().map(echartsVo -> echartsVo.getError()).toArray();
        Integer[] month = (Integer[]) videoNum.stream().map(echartsVo -> echartsVo.getMonth()).toArray();

        Map<String,Integer[]> result = new HashMap(8);
        result.put("total",total);
        result.put("success",success);
        result.put("wait",wait);
        result.put("error",error);
        result.put("month",month);
        return JSONResult.ok(result);
    }
}

