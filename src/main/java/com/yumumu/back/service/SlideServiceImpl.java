package com.yumumu.back.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.yumumu.back.dao.SlideDao;
import model.Slide;
import org.springframework.beans.factory.annotation.Autowired;
import response.ApiResponse;
import service.SlideService;

@Service(
        version = "1.0.0",
        application = "${dubbo.application.id}",
        protocol = "${dubbo.protocol.id}"
)
public class SlideServiceImpl implements SlideService {


    @Autowired
    private SlideDao slideDao;


    @Override
    public ApiResponse<Slide> getSlideById(Integer id) {
        ApiResponse<Slide> slideApiResponse = new ApiResponse<>(slideDao.findSlideById(id));
        return slideApiResponse;
    }

    @Override
    public ApiResponse<Slide> createSlide(Slide slide) {
        return null;
    }

    @Override
    public ApiResponse<Slide> updateSlide(Slide slide) {
        return null;
    }

    @Override
    public ApiResponse<Boolean> deleteSlideById(Integer id) {
        return null;
    }
}
