package com.phish.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * 转换工具
 * @ClassName:  ConvertUtils   
 * @Description:输入数字输出字母组合
 * @author: Gary Chu
 * @date:   2020年2月29日 下午10:17:11     
 */
public class ConvertUtils {
	
	static String[] mapping = {
			"",
			"", "abc", "def",
			"ghi", "jkl", "mno",
			"pqrs", "tuv", "wxyz"
			};

	
	/**
	 * 字母组合方法（递归）
	 * @Title: simpleConvert   
	 * @Description: 通过index记录每次递归nums的下标，一次递归是将一个数字的字母集合拼入结果集中；当index=nums.length时，递归结束；
	 * @param: @param nums	输入数字集合
	 * @param: @param index	nums的下标，调用时请传入：0
	 * @param: @param rs	结果集，调用时请传入：null
	 * @param: @throws IllegalArgumentException 传入数字超出范围（0-9）抛出异常
	 * @return: List<String>      
	 * @throws
	 */
	private static List<String> simpleConvert(int[] nums, int index, List<String> rs) throws IllegalArgumentException{
		
		//1、判断nums下标---跳出递归
		if(index >= nums.length) return rs;
		
		
		//2、获取数据
		int num = nums[index];
		if(num > 9 || num < 0) throw new IllegalArgumentException();	//排除非法数字
		
		//3、移动标志位
		index++;

		//4、获取字母集
		String letters = mapping[num];
		if(letters.isEmpty()) return simpleConvert(nums, index, rs);	//字符集为空，进入下一次递归
		
		//5、拼装结果集
		List<String> newRs = new ArrayList<String>();
		for(int i=0; i<letters.length(); i++) {
			String letter = letters.charAt(i) + "";
			
			if(rs != null && !rs.isEmpty()) {	//第一次递归或为空
				
				for(String item : rs) newRs.add(item + letter);
			
			}else {
				newRs.add(letter);
			}
		}
		
		//6、递归
		return simpleConvert(nums, index, newRs);
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		int[] nums = {1, 2, 5, 0};
		
		List<String> rs = simpleConvert(nums, 0, null);
		
		
		
		for(int i=0; i<rs.size(); i++) {
			if(i % 3 == 0) System.out.println();
			
			System.out.print(rs.get(i));
			System.out.print(",");
		}
	}
	
}
