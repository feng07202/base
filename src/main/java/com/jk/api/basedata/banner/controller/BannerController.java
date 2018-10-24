package com.jk.api.basedata.banner.controller;

import com.jk.api.dependency.common.abs.AbstractController;
import com.jk.framework.base.entity.DataTransferObject;
import com.jk.framework.base.head.Header;
import com.jk.framework.base.rst.ResponseDto;
import com.jk.framework.base.utils.Check;
import com.jk.services.basedata.api.BannerService;
import com.jk.services.basedata.model.BannerEntity;
import com.jk.services.basedata.model.BannerReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author:zhangzhengguang
 * @date:2017/10/26
 * @description:banner
 **/
@Controller
@RequestMapping("banner")
public class BannerController extends AbstractController {

    @Autowired
    private BannerService bannerService;

    /**
     * @author:zhangzhengguang
     * @date:2017/10/26
     * @description:查询banner列表
     **/
    @RequestMapping(value = "/listBanner", method = RequestMethod.GET)
    public
    @ResponseBody
    ResponseDto listBanner(HttpServletRequest request, HttpServletResponse response) {
        BannerReq req = getEntity(request, BannerReq.class);
        Header header = getHeader(request);
        if(Check.NuNObj(req)){
        return new ResponseDto("参数异常",DataTransferObject.ERROR);
        }
        req.setAppCode(header.getApplicationCode());
        DataTransferObject<List<BannerEntity>> result = bannerService.listBanner(req);
        return result.trans2Res();
    }


}	

