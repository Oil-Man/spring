package com.oilman.springmvc4.converter;

import com.oilman.springmvc4.entity.DataObject;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.nio.charset.Charset;

/**
 * 描述：自定义消息转化器
 * Created by wangcw on 2019/4/15.
 */
public class MyHttpMessageConverter extends AbstractHttpMessageConverter<DataObject>{
    public MyHttpMessageConverter(){
        //自定义消息转化器能够处理的媒体类型
        super(new MediaType("application", "x-dataObject", Charset.forName("utf-8")));
    }

    //定义支持处理的class
    @Override
    protected boolean supports(Class<?> clazz) {
        return DataObject.class.isAssignableFrom(clazz);
    }

    /**
     * 描述：request参数预处理方法
     * @param clazz ：该参数匹配控制器方法参数，如果参数接收的是指定的类型（如DataObject，一般配合@RequestBody使用），
     *                则在进入Controller方法处理前会进入该方法进行request参数的预处理
     * @param httpInputMessage
     * @return
     * @throws IOException
     * @throws HttpMessageNotReadableException
     */
    @Override
    protected DataObject readInternal(Class<? extends DataObject> clazz, HttpInputMessage httpInputMessage) throws IOException, HttpMessageNotReadableException {
        System.out.println("进入readInternal");
        String temp = StreamUtils.copyToString(httpInputMessage.getBody(), Charset.forName("utf-8"));
        String[] arrs = temp.split("-");
        System.out.println("退出readInternal");
        return new DataObject(Long.valueOf(arrs[0]), arrs[1]);
    }

    /**
     * 描述：response参数预处理方法
     * @param object ：泛型参数，只有Controller方法返回值是该类型时（一般配合@ResponseBody使用），才会进入该方法
     * @param httpOutputMessage
     * @throws IOException
     * @throws HttpMessageNotWritableException
     */
    @Override
    protected void writeInternal(DataObject object, HttpOutputMessage httpOutputMessage) throws IOException, HttpMessageNotWritableException {
        System.out.println("进入writeInternal");
        String out = "hello:" + object.getId() + "-" + object.getName();
        System.out.println("退出writeInternal");
        httpOutputMessage.getBody().write(out.getBytes());
    }
}
