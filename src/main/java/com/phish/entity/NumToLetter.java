package com.phish.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.phish.common.Converter;

/**
 * 数字组合转换字母组合
 * @ClassName:  NumToLetter   
 * @author: Gary Chu
 * @date:   2020年3月1日 下午3:08:59      
 */
public class NumToLetter {

	/**
	 * 个位数映射集[0,9]
	 */
	private Map<Integer, List<String>> singleMapping;

	/**
	 * 构造方法，设置个位数映射集
	 */
	public NumToLetter() {
		singleMapping = new HashMap<Integer, List<String>>();
		singleMapping.put(0, new ArrayList<String>());
		singleMapping.put(1, new ArrayList<String>());
		singleMapping.put(2, Arrays.asList("a","b","c"));
		singleMapping.put(3, Arrays.asList("d","e","f"));
		singleMapping.put(4, Arrays.asList("g","h","i"));
		singleMapping.put(5, Arrays.asList("j","k","l"));
		singleMapping.put(6, Arrays.asList("m","n","o"));
		singleMapping.put(7, Arrays.asList("p","q","r","s"));
		singleMapping.put(8, Arrays.asList("t","u","v"));
		singleMapping.put(9, Arrays.asList("w","x","y","z"));
	}
	
	/**
	 * 个位数转换
	 * @Title: singleDigitConvert   
	 * @Description: TODO(描述这个方法的作用)   
	 * @param: @param numbers	数字集合
	 * @return: 字母集合 
	 */
	public List<String> singleDigitConvert(List<Integer> numbers) {
		//1、构造转换器
		Converter converter = new Converter(this.singleMapping, numbers);
		//2、执行转换，返回转换结果
		return converter.convert();
	}
	
	/**
	 * 非个位数转换
	 * @Title: mulitidigitConvert 
	 * @param: @param numbers	数字集合	
	 * @return: 字母集合
	 */
	public List<String> mulitidigitConvert(List<Integer> numbers) {
		//1、新映射集
		Map<Integer, List<String>> multMapping = new HashMap<Integer, List<String>>();
		
		//2、组装新映射集
		for(Integer num : numbers) {
			//数字拆分为个位
			List<Integer> nums = multToSingle(num);
			
			//获取单个数字的字符集
			List<String> combinations = singleDigitConvert(nums);
			
			//插入新映射
			multMapping.put(num, combinations);
		}
		
		//3、构造转换器
		Converter converter = new Converter(multMapping, numbers);
		
		//4、执行转换，返回转换结果
		return converter.convert();
	}
	
	/**
	 * 非个位数拆分为个位数集合
	 * @Title: multToSingle   
	 * @Description: TODO(描述这个方法的作用)   
	 * @param: @param num	非个位数  
	 * @return:	个位数集合
	 */
	private List<Integer> multToSingle(Integer num){
		
		List<Integer> rs = new ArrayList<Integer>();
		
		boolean isLoop = true;
		while(isLoop) {
			Integer single = num % 10;
			rs.add(single);
			
			num = num / 10;
			if(num == 0) isLoop = false;
		}
		
		return rs;
	}
	
	
	
	
	
	
	
	
	
	
}
