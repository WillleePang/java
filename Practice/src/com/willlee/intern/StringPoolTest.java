package com.willlee.intern;

public class StringPoolTest {
	public void testStringPoolWithLongString() {
		long i = 0;
		while (true) {
			String longString = "This is a very long string, very very long string to test the gc behavior of the string constant pool"
					+ i;
			longString.intern();
			i++;
		}
	}

	public static void main(String[] args) {
		// StringPoolTest stringPoolTest = new StringPoolTest();
		// stringPoolTest.testStringPoolWithLongString();

		 String str2 = new String("Hello");
		 String str1 = "Hello";
		 System.out.println(str1 == str2.intern());
		 String s1 = new String("ab");
		 s1.intern();
		 String s3 = new String("ab");
		 s3.intern();
		 String s4 = "ab";

		 System.out.println(s1 == s4);
		 System.out.println(s3 == s4);

//		String str1 = new StringBuilder("¼ÆËã»ú").append("Èí¼þ").toString();
//		System.out.println(str1.intern() == str1);
//
//		String str2 = new StringBuilder("ja").append("va").toString();
//		System.out.println(str2.intern() == str2);
//		
//		String str3 = new StringBuilder("ja").append("va1").toString();
//		System.out.println(str3.intern() == str3);
		 
		 System.out.println(Runtime.getRuntime().maxMemory());
		 System.out.println(Runtime.getRuntime().freeMemory());
		 System.out.println(Runtime.getRuntime().totalMemory());  
		 
	}
}
