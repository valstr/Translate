package controller;

import java.io.IOException;
import java.net.URLEncoder;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartRequest;

import com.alibaba.fastjson.JSONObject;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

import common.MD_5;
import common.VeDate;
import common.httpUtil;

@Controller
@RequestMapping("/youdao")
public class YoudaoTranslate {

	@ResponseBody
	@RequestMapping(value = "/translate")
	public Map<String, Object> translate(String content) throws ParseException,
			IOException {
		String keyfrom = "1540827344";
		String key = "sanguo0708";
		String doctype = "json"; // 返回数据格式
		String version = "1.1"; // 有道版本号
		String q = URLEncoder.encode(content, "GBK"); //翻译内容URLEncode编码

		JSONObject json = httpUtil
				.doGetStr("http://fanyi.youdao.com/openapi.do?keyfrom=<"
						+ keyfrom + ">&key=<" + key + ">&type=data&doctype=<"
						+ doctype + ">&version=" + version + "&q=" + q);
		System.out.println(json);
		Map<String, Object> map = json;
		return map;
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/voice")
	public Map<String, Object> voice(String filePath,String a) throws ParseException,
			IOException, NoSuchAlgorithmException {
		
		String CLOUD_url="test.api.hcicloud.com:8888";
		JSONObject configJson = new JSONObject();;
		configJson.put("capkey", (a=="1")?"asr.cloud.freetalk":"asr.cloud.freetalk.english");
		configJson.put("audioformat", "");
		
		
		JSONObject posthead = new JSONObject();;
		posthead.put("x-app-key", "205d543c");
		posthead.put("x-sdk-version", "3.8");
		posthead.put("x-request-date", VeDate.getStringDate());
		posthead.put("x-task-config", 1);
		posthead.put("x-session-key",MD_5.EncoderByMd5(VeDate.getStringDate()+"c495a9724b65c938c7ff140ffcf60dbc"));
		posthead.put("x-udid", "101:1234567890");
        
        
		
		
		
		JSONObject postJson = new JSONObject();;
    	postJson.put("x-app-key", "205d543c");
        String postParams = postJson.toString();
		
		JSONObject json = httpUtil
				.doPostxml(CLOUD_url+"/asr/Recognise",postParams);
		System.out.println(json);
		Map<String, Object> map = json;
		return map;
	}
}
