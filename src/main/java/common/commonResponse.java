package common;

import java.util.HashMap;
import java.util.Map;

public class commonResponse {
	
	
	/**
	 * token
	 * @return
	 */
	public static Map<String, Object> getResonse0(){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", 0);
		map.put("msg", "token错误"); 
		return map; 
	}
	
	/**
	 * 成功
	 * @return
	 */
	public static Map<String, Object> getResonse1(){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", 1); 
		map.put("msg", "成功");
		return map;
	}
	
	/**
	 * app成功
	 * @return
	 */
	public static Map<String, Object> getResonse1_1(){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", 1);
		map.put("msg", "成功");
		return map;
	}
	
	/**
	 * 错误
	 * @return
	 */
	public static Map<String, Object> getResonse500(){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", 500);
		map.put("msg", "错误");
		return map;
	}

}
