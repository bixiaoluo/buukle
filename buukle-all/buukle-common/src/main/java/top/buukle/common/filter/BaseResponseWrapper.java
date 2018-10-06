package top.buukle.common.filter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

import java.io.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.WriteListener;


/**
 * 返回值输出代理类
 *
 * @Title: BaseResponseWrapper
 * @Description:
 * @author kokJuis
 * @date 上午9:52:11
 */
public class BaseResponseWrapper extends HttpServletResponseWrapper{

    private ByteArrayOutputStream cacheStream = new ByteArrayOutputStream(); //缓冲区，用来存放后台数据
    private PrintWriter pw =new PrintWriter(cacheStream);
    private ServletOutputStream outputStream ;


    public BaseResponseWrapper(HttpServletResponse response) throws IOException {
        super(response);
        outputStream = response.getOutputStream();
    }

    @Override
    public ServletOutputStream getOutputStream() throws IOException {
        return new ServletOutputStream(){
            @Override
            public boolean isReady() {
                return false;
            }

            @Override
            public void setWriteListener(WriteListener writeListener) {

            }

            @Override
            public void write(int b) throws IOException {
                cacheStream.write(b);
                outputStream.write(b);
            }
        };
    }
    public void flush(){
        try {
            pw.flush();
            pw.close();
            cacheStream.flush();
            cacheStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getResult() {
        return cacheStream.toString();
    }
}

