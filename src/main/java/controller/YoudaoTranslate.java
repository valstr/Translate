package controller;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

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
	public Map<String, Object> voice(String content) throws ParseException,
			IOException {

		JSONObject json = httpUtil
				.doPostStr("aaa",content);
		System.out.println(json);
		Map<String, Object> map = json;
		return map;
	}
}
