package controller;

import java.io.IOException;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

import common.Parameter;
import common.commonResponse;
import common.httpUtil;

@Controller
@RequestMapping("/translate")
public class Translate {
	
	@ResponseBody
	@RequestMapping(value = "/save")
	public Map<String, Object> save(String aa) {
//		service.save(user);
		Map<String, Object> map = commonResponse.getResonse1();
//		map.put("cont", user);
		return map;
	}

	/**
	 * @param enterprise
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/turn")
	public Map<String, Object> turn(Parameter parameter) throws ParseException,
			IOException {
		System.out.println(parameter);
		JSONObject json = httpUtil
				.doGetStr("http://api.avatardata.cn/Dictionary/Translate?key=acd28128434347ef861591d6eb17ea45&query="
						+ parameter.getQuery()
						+ "&from="
						+ parameter.getFrom()
						+ "&to=" + parameter.getTo());
		System.out.println(json);
		Map<String, Object> map = json;
		return map;
	}
}
