package com.govmaz.utils;

import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;


public class RestUtil {
  public static  Object requestApi(String url,Map<String,Object> param,RestTemplate restTemplate){
    Map<String,Object> result = new HashMap<>();
    try{
      //4. 设置header的Get请求
      HttpHeaders headers = new HttpHeaders();
//      headers.add("authorization","bearer " + bosAuthService.getToken(false));
      ResponseEntity<Map> response = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<String>(headers), Map.class,param);
      if(response.getStatusCode().is2xxSuccessful()){
        Map<String, Object> body = response.getBody();
        if (body.get("code") != null) {
          Integer respCode = Integer.parseInt(body.get("code").toString());
          if (!respCode.equals(200)) {
            String msg = body.get("message").toString();
            result.put("code",respCode);
            result.put("msg",msg);
            return result;
          }
        }
        result.put("code",200);
        result.put("msg","ok");
        result.put("data",body.get("data"));
        return result;
      }else {
        result.put("code",response.getStatusCode());
        result.put("msg","接口调用失败，状态码："+response.getStatusCode());
        return result;
      }
    } catch (Exception e){
      result.put("code",500);
      result.put("msg","接口调用失败，错误描述："+e.getMessage());
      return result;
    }
  }

  public static  Object postApi(String url,Map<String,Object> param,RestTemplate restTemplate){
    Map<String,Object> result = new HashMap<>();
    try{
      //4. 设置header的Get请求
      HttpHeaders headers = new HttpHeaders();
//      headers.add("authorization","bearer " + bosAuthService.getToken(false));
      ResponseEntity<Map> response = restTemplate.exchange(url, HttpMethod.POST, new HttpEntity<String>(headers), Map.class,param);
      if(response.getStatusCode().is2xxSuccessful()){
        Map<String, Object> body = response.getBody();
//        if (body.get("code") != null) {
//          Integer respCode = Integer.parseInt(body.get("code").toString());
//          if (!respCode.equals(200)) {
//            String msg = body.get("message").toString();
//            result.put("code",respCode);
//            result.put("msg",msg);
//            return result;
//          }
//        }
        result.put("code",200);
        result.put("msg","ok");
        result.put("data",body);
//        result.put("data",body.get("data"));
        return result;
      }else {
        result.put("code",response.getStatusCode());
        result.put("msg","接口调用失败，状态码："+response.getStatusCode());
        return result;
      }
    } catch (Exception e){
      result.put("code",500);
      result.put("msg","接口调用失败，错误描述："+e.getMessage());
      return result;
    }
  }
}
