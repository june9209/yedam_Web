package com.yedam;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

public class CommonUtil {

	public static void printParameter(HttpServletRequest request) {
		
		// 파라미터 전체 출력
		Map<String, String[]> map = request.getParameterMap();
		Set<String> set = map.keySet();
		Iterator<String> iterator = set.iterator();
		
		while(iterator.hasNext()) {
			String key = iterator.next();
			String[] value = map.get(key);
			System.out.print(key + " : ");
			for (String h : value) {
				System.out.print(h + ", ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
