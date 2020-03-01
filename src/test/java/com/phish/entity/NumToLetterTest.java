package com.phish.entity;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 * 
 * @ClassName:  NumToLetterTest   
 * @Description:TODO(描述这个类的作用)   
 * @author: Gary Chu
 * @date:   2020年3月1日 下午3:24:13      
 * @Copyright:
 */
@RunWith(Parameterized.class)
public class NumToLetterTest {

	/** 转换类 */
	private static NumToLetter numToLetter;
	/** 个位数输入数据 */
	private List<Integer> singleInput;
	/** 个位数输出期望（字符集长度） */
	private long singleExpected;
	/** 非个位数输入数据 */
	private List<Integer> multInput;
	/** 非个位数输出期望（字符集长度） */
	private long multExpected;
	

	public NumToLetterTest(List<Integer> singleInput, long singleExpected, List<Integer> multInput, long multExpected) {
		super();
		this.singleInput = singleInput;
		this.singleExpected = singleExpected;
		this.multInput = multInput;
		this.multExpected = multExpected;
	}

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		numToLetter = new NumToLetter();
	}

	@Parameters
	public static Collection data(){
		Object[][] data = new Object[][]{
			{Arrays.asList(2,3), 9, Arrays.asList(23,45), 81},
			{Arrays.asList(1,2,3), 9, Arrays.asList(1,23), 9},
			{Arrays.asList(0,1,2,3), 9, Arrays.asList(10,23), 9},
			{Arrays.asList(0,1,7,8), 12, Arrays.asList(23,45,67), 972},
			{Arrays.asList(0,1,7,9), 16, Arrays.asList(11,10,97), 16},
		};
		return Arrays.asList(data);
	}
	
	@Test
	public void singleDigitConvertTest() {
		List<String> rs = numToLetter.singleDigitConvert(singleInput);
		assertEquals(singleExpected, rs.size());
	}
	
	@Test
	public void mulitidigitConvertTest() {
		List<String> rs = numToLetter.mulitidigitConvert(multInput);
		assertEquals(multExpected, rs.size());
	}

}
