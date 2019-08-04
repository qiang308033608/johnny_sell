package com.imooc.sell.controller;

import com.imooc.sell.enums.ResultEnums;
import com.imooc.sell.exception.SellException;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.URLEncoder;

@RestController
@RequestMapping("/wechat")
@Slf4j
public class WechatController {

    @Autowired
    private WxMpService wxMpService;

    @GetMapping("authorize")
    public String authorize(@RequestParam("returnUrl") String returnUrl){

        //1.配置
        //2.调用方法
        String url="http://lim666.natapp1.cc/sell/wechat/userInfo";
        String redirectUrl = wxMpService.oauth2buildAuthorizationUrl(url, WxConsts.OAUTH2_SCOPE_USER_INFO,
                                                                     URLEncoder.encode(returnUrl));
//        log.info("【微信页面授权】 获取code ,result={}",redirectUrl);
        return "redirectUrl:"+ redirectUrl;
    }
    @GetMapping("/userInfo")
    public String userInfo(@RequestParam("code") String code,
                         @RequestParam("state") String returnUrl){
        WxMpOAuth2AccessToken wxMpOAuth2AccessToken = new WxMpOAuth2AccessToken();
        try{
            wxMpOAuth2AccessToken  = wxMpService.oauth2getAccessToken(code);

        } catch (WxErrorException e){
            log.error("【微信页面授权】 {} ",e);
            throw new SellException(ResultEnums.WECHAT_MP_ERROR.getCode(),e.getError().getErrorMsg());
        }
        String openId=wxMpOAuth2AccessToken.getOpenId();

        return  "redirect:" + returnUrl + "?openId=" + openId;


    }
}
