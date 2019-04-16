package com.oilman.springmvc4.controller;

import com.oilman.springmvc4.entity.DataObject;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 描述：简单控制器
 * Created by wangcw on 2019/4/11.
 */
@Controller
public class HelloController {

    @RequestMapping("/hello")
    public String hello(){
        System.out.println("===================");
        return "index";
    }

    @RequestMapping("/path")
    @ResponseBody
    public Map<String, Object> getPath(HttpServletRequest request){
        Map<String, Object> map = new HashMap<>();
        map.put("user.dir",System.getProperty("user.dir"));
        map.put("request.getContextPath", request.getContextPath());
        map.put("request.getRequestURI", request.getRequestURI());
        map.put("request.getRequestURL", request.getRequestURL());
        map.put("request.getServletContext().getContextPath", request.getServletContext().getContextPath());
        map.put("request.getServletContext().getRealPath", request.getServletContext().getRealPath(""));
        map.put("request.getServletContext().getContextPath", request.getServletContext().getContextPath());
        map.put("classpath", this.getClass().getClassLoader().getResource("").getPath());
        return map;
    }

    @RequestMapping("/error")
    public void error(@ModelAttribute("msg") String msg, DataObject object){
        throw new RuntimeException("非法访问！" + "@ModelAttribute:"
                + msg + " id="+object.getId() + " name=" + object.getName());
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String upload(@RequestParam("file") MultipartFile multipartFile, HttpServletRequest request){
        if (multipartFile != null){
            String ctxPath = request.getServletContext().getRealPath("/WEB-INF/classes");
            System.out.println(ctxPath);
            File file = new File(ctxPath+"/static/upload", multipartFile.getOriginalFilename());
            try {
                FileUtils.writeByteArrayToFile(file, multipartFile.getBytes());
                request.setAttribute("filePath", "/static/upload/"+file.getName());
            } catch (IOException e) {
                e.printStackTrace();
                return "error/page";
            }
        }
        return "fileUpload";
    }

}
