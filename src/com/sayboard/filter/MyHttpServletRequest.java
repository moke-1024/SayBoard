package com.sayboard.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/**
 * @outhor moke
 * @date 2019-11-25
 */
public class MyHttpServletRequest extends HttpServletRequestWrapper {
    public String encode = null;
    public MyHttpServletRequest(HttpServletRequest request,String encode) {
        super(request);
        this.encode = encode;
    }

    @Override
    public Map<String, String[]> getParameterMap() {
        try {
            Map<String, String[]> map = super.getParameterMap();
            Map<String,String[]> rmap = new HashMap();
            for (Map.Entry<String,String[]> entry:map.entrySet()){
                String key = entry.getKey();
                String[] value = entry.getValue();
                String[] rvalue = new String[value.length];
                for (int i = 0; i < value.length; i++) {
                    byte[] bytes = new byte[0];
                    bytes = value[i].getBytes("iso8859-1");
                    String s = new String(bytes,encode);
                    rvalue[i] = s;
                }
                rmap.put(key,rvalue);
            }
            return rmap;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public String[] getParameterValues(String name) {
        Map<String, String[]> map = this.getParameterMap();
        String[] values = map.get(name);
        return values;
    }

    @Override
    public String getParameter(String name) {
        String[] rvalues = this.getParameterValues(name);
        return rvalues!=null?rvalues[0]:null;
    }
}
