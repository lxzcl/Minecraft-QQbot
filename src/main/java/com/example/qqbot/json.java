package com.example.qqbot;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class json {

    public String Json() {
        String text = "";
        try {
            /* 以GET方法获取json数据 */
            CloseableHttpClient httpClient = new DefaultHttpClient();
            HttpGet httpGet = new HttpGet("http://192.168.3.7/json.php?host=mymc.xyz&port=25565");
            HttpResponse response = httpClient.execute(httpGet);
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                text = EntityUtils.toString(entity, "UTF-8");
                EntityUtils.consume(entity);
            }
            JSONObject jsonObject = JSON.parseObject(text);
            String status=(String) jsonObject.get("status");
            if(status.equals("Online")){
                //ping
                String pin = (String) jsonObject.getJSONObject("queryinfo").getString("processed");
                double ping = Double.valueOf(pin);
                ping = ping * 100;
                //ipv4,6地址
                address ip=new address();
                address6 ip6=new address6();
                cpu c=new cpu();
                String re = "服务器状态：" + status + "\n" +
                        "服务器在线人数：" + (String) jsonObject.getJSONObject("players").getString("online") + "\n" +
                        "服务器延时：" + (int) ping + "ms" + "\n"+
                        c.cpu()+"\n"+
                        c.Mem()+"\n"+
                        ip.add()+ip6.add();
                log.info(re);
                return re;
            }
            return "服务器好像寄了再输入试试！";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "获取失败";
    }
}
