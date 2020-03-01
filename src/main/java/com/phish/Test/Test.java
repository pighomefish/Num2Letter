package com.phish.Test;

import java.util.Arrays;
import java.util.List;

import com.phish.entity.NumToLetter;

public class Test {

	public static void main(String[] args) {
		NumToLetter numToLetter = new NumToLetter();
//		List<String> singleList = numToLetter.singleDigitConvert(Arrays.asList(1,3,4,0));
//		
//		for(int i=0; i<singleList.size(); i++) {
//			String str = singleList.get(i);
//			System.out.print(str);
//			System.out.print("，");
//			if((i+1) % 3 == 0) System.out.println();
//		}
		
		List<String> multList = numToLetter.mulitidigitConvert(Arrays.asList(0,22,1,42,1));
	
		for(int i=0; i<multList.size(); i++) {
			String str = multList.get(i);
			System.out.print(str);
			System.out.print("，");
			if((i+1) % 3 == 0) System.out.println();
		}
	}
	
}
