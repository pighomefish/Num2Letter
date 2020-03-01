package com.phish.common;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 组合转换器
 * @ClassName:  Converter   
 * @Description:根据“映射规则”，将“输入数字集合”转换为“输出字符组合集合”
 * @author: Gary Chu
 * @date:   2020年3月1日 下午12:15:14      
 */
public class Converter {
	
	/** 映射规则 */
	private Map<Integer, List<String>> mapping = null;
	
	/** 输入数字集合 */
	private List<Integer> numbers = null;
	
	/** 输出字符组合集合 */
	private List<String> combinations = null;
	
	
	public Map<Integer, List<String>> getMapping() {
		return mapping;
	}

	public List<Integer> getNumbers() {
		return numbers;
	}

	public void setNumbers(List<Integer> numbers) {
		this.numbers = numbers;
	}

	public List<String> getCombinations() {
		return combinations;
	}

	
	/**
	 * 构造器，设置映射规则
	 * @param mapping	映射规则
	 */
	public Converter(Map<Integer, List<String>> mapping) {
		super();
		this.mapping = mapping;
	}

	/**
	 * 构造器，设置映射规则 和 输入数字集合
	 * @param mapping	映射规则
	 * @param numbers	输入数字集合
	 */
	public Converter(Map<Integer, List<String>> mapping, List<Integer> numbers) {
		super();
		this.mapping = mapping;
		this.numbers = numbers;
	}
	
	/**
	 * 组合转换
	 * @Title: convert   
	 * @Description: 将数字组合转换为字母组合，此方法调用前提：mapping、numbers非空
	 * @return:所有可能的字母组合
	 * @throws	NullPointerException mapping 或 numbers未赋值
	 */
	public List<String> convert() {
		//1、排除空参数
		if(this.mapping == null || this.numbers == null) {
			throw new NullPointerException("mapping 或 numbers未赋值");
		}
		
		//2、数据处理
		this.combinations = convert(0, null);
		return this.combinations;
	}
	
	/**
	 *组合转换（递归）
	 * @Title: convert   
	 * @Description: 通过index记录每次递归this.numbers的下标，一次递归是将一个数字的字母集合拼入结果集中；
	 * 				当index=this.numbers.size()时，递归结束；
	 * 
	 * @param: @param index	this.numbers的下标，调用时请传入：0
	 * @param: @param rs	结果集，调用时请传入：null
	 * @return:      
	 * @throws	IllegalArgumentException	传入数字不存在this.mapping时，抛出参数异常
	 */
	private List<String> convert(int index, List<String> rs) {
		
		if(rs == null) rs = new ArrayList<String>();	//第一次递归
		
		//1、判断nums下标---跳出递归
		if(index >= this.numbers.size()) return rs;
		
		//2、获取数字
		int num = this.numbers.get(index);
		if(!this.mapping.containsKey(num)) 	//校验输入数字是否存在mapping中
			throw new IllegalArgumentException();		
		
		//3、移动标志位
		index++;
		
		//4、获取字母集
		List<String> letters = this.mapping.get(num);
		if(letters.isEmpty()) return convert(index, rs);	//字符集为空，进入下一次递归
		
		//5、拼装结果集
		List<String> newRs = new ArrayList<String>();
		for(int i=0; i<letters.size(); i++) {
			String letter = letters.get(i);
			
			if(!rs.isEmpty()) {
				
				for(String item : rs) newRs.add(item + letter);
				
			}else {
				newRs.add(letter);
			}
		}
		
		//6、递归
		return convert(index, newRs);
	}

	
	
	
	
	
	
	
	
	
	
}
