package com.diode.mvc.filter;

import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.ResponseWrapper;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * @author unlikeha@163.com
 * @date 2020/5/20
 */
public class LogFilter extends OncePerRequestFilter {
    private static final Logger logger = LoggerFactory.getLogger("request");
    /**
     * 初始化
     */
    public LogFilter() {
        System.out.println("init LogFilter");
    }

    /**
     *  连接器方法
     * @param request
     * @param response
     * @param filterChain
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        Gson gson=new Gson();
        // 请求地址
        String uri = request.getRequestURI();
        // 请求的参数
        String requestParam = gson.toJson(request.getParameterMap());
        // 请求Body
        String bodyString = getBodyString(request);
        // 请求开始时间
        long begin = System.currentTimeMillis();
        // 打印请求信息
        logger.info("##### Request: Url：" + uri + " Request:  " +requestParam + " Body :"+ bodyString);
        filterChain.doFilter(request, response);
    }

    /**
     * 获取 HttpServletRequest 中 Body 参数
     * @param request
     * @return
     */
    private String getBodyString(HttpServletRequest request){
        BufferedReader br = null;
        StringBuilder sb = new StringBuilder();
        try{
            br = request.getReader();
            String str;
            while ((str = br.readLine()) != null){
                sb.append(str);
            }
            br.close();
        }catch (IOException e){
            e.printStackTrace();
        }
        finally{
            if (null != br){
                try{
                    br.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
        return sb.toString();
    }
}
