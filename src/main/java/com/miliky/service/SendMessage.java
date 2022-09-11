package com.miliky.service;

/**
 * @Author: Miliky
 * @Date: 2022/9/6 15:41
 * @Description: [爱意随风起，风止意难平。]
 */
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.miliky.entry.Limited;
import com.miliky.utils.HtmlParseUtil;
import com.miliky.utils.Utils;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

/**
 * Describe：发送消息的具体逻辑
 *
 * @author Administrator
 * @createTime 2022/08/22 21:31
 */
@Component
public class SendMessage {

    @Value("${wx.appID}")
    private String appId;

    @Value("${wx.appsecret}")
    private String appsecret;
    @Value("${wx.touser}")
    private String touser;
    @Value("${wx.template_id}")
    private String template_id;
    private int sendTimeNum = 0;
    public static List<String> parm = new ArrayList<>();

    SendMessage() {

        System.out.println("===========加载配置文件============");
        try {
            //留言文件的存放地址
            ClassPathResource classPathResource = new ClassPathResource("/static/like.txt");
            //获取文件
            File file = classPathResource.getFile();
            //获取路径
            String path = classPathResource.getPath();
            System.out.println("path:" + path);
            System.out.println("file:" + file);
            //转成输入流
            InputStream in = this.getClass().getClassLoader().getResourceAsStream(path);
            //获取文件流
            FileInputStream inputStream = new FileInputStream(file);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            String str = null;
            while ((str = bufferedReader.readLine()) != null) {
                parm.add(str);
            }

            inputStream.close();
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 功能描述: 获取token
     *
     * @param
     * @author Administrator 2022/8/22 21:39
     */
    private String getAccessToken() {

        try {
            String bodyStr = HtmlParseUtil.getUrlResult(
                    "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=" + appId + "&secret="
                            + appsecret);
            JSONObject bodyJson = JSON.parseObject(bodyStr);
            return bodyJson.getString("access_token");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public void sendMessageByTemplate() {

        try {
            OkHttpClient client = new OkHttpClient().newBuilder()
                    .build();
            MediaType mediaType = MediaType.parse("application/json");
            JSONObject requestData = new JSONObject();
            requestData.put("touser", touser);
            requestData.put("template_id", template_id);
            requestData.put("url", "");
            requestData.put("topcolor", "");
            //模板文件中的各个参数
            JSONObject data = new JSONObject();
//            //日期
//            JSONObject date = new JSONObject();
//            date.put("value", Utils.getNowDate() + " " + Utils.getWeekOfDate(new Date()));
//            date.put("color", "#005faf");
//            //天数
//            JSONObject dateNumbers = new JSONObject();
//            String s = Utils.toNowDatNum();
//            dateNumbers.put("value", s);
//            dateNumbers.put("color", "#005faf");
//            //文本
//            JSONObject text = new JSONObject();
//            text.put("value", "♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥\n" + parm.get(this.sendTimeNum));
//            text.put("color", "#f73131");
//
//            JSONObject weather = Utils.getWeather();
//            String tianqiStr = "";
//            if (weather != null) {
//                String high = weather.getString("high");
//                String low = weather.getString("low");
//                String fx = weather.getString("fx");
//                String fl = weather.getString("fl");
//                String type = weather.getString("type");
//                tianqiStr = type + ",最高温度：" + high + ",最低温度：" + low + "," + fx + fl;
//            }
            //天气
//            JSONObject tianqi = new JSONObject();
//            tianqi.put("value", tianqiStr);
//            tianqi.put("color", "#ff4d00");
//            data.put("date", date);
            //天数
//            data.put("dateNumbers", dateNumbers);
//            data.put("text", text);
//            data.put("tianqi", tianqi);


            JSONObject text = new JSONObject();
            List<Limited> forbiddenNumber = Utils.getForbiddenNumber();
            String str = "";
            for (Limited limited : forbiddenNumber) {
                str += limited.toString();
            }
            text.put("value", str);
            data.put("text", text);
            requestData.put("data", data);
            RequestBody body = RequestBody.create(mediaType, requestData.toJSONString());
            Request request = new Request.Builder()
                    .url("https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=" + this.getAccessToken())
                    .method("POST", body)
                    .addHeader("Content-Type", "application/json")
                    .build();
            Response response = client.newCall(request).execute();
            this.sendTimeNum++;//每天都发的不一样的留言
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
