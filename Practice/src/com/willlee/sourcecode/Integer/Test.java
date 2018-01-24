package com.willlee.sourcecode.Integer;

public class Test {

	final static int[] sizeTable = { 9, 99, 999, 9999, 99999, 999999, 9999999,
			99999999, 999999999, Integer.MAX_VALUE };

	// Requires positive x
	static int stringSize(int x) {
		for (int i = 0;; i++)
			if (x <= sizeTable[i])
				return i + 1;
	}

	// i要转换的int，index是数组的大小，buf是char数组
	static void getChars(int i, int index, char[] buf) {
		int q, r;
		int charPos = index;
		// 存储负号
		char sign = 0;

		// 如果是负数，那么取正，然后用sign存储负号
		if (i < 0) {
			sign = '-';
			i = -i;
		}

		// 每次循环过后，都会将i中的走后两位保存到字符数组buf中的最后两位中，读者可以将数字i设置为12345678测试一下，
		// 第一次循环结束之后，buf[7] = 8,buf[6]=7。第二次循环结束之后，buf[5] = 6,buf[4] = 5。
		while (i >= 65536) {
			q = i / 100;
			// really: r = i - (q * 100);
			r = i - ((q << 6) + (q << 5) + (q << 2));
			i = q;
			// 取DigitOnes[r]的目的其实取数字r%10的结果
			buf[--charPos] = DigitOnes[r];
			// 取DigitTens[r]的目的其实是取数字r/10的结果
			buf[--charPos] = DigitTens[r];
		}

		// Fall thru to fast mode for smaller numbers
		// assert(i <= 65536, i);
		// 循环将其他数字存入字符数组中空余位置
		for (;;) {
			// 这里其实就是除以10。取数52429和16+3的原因在后文分析。
			q = (i * 52429) >>> (16 + 3);
			// r = i-(q*10) ...
			r = i - ((q << 3) + (q << 1));
			// 将数字i的最后一位存入字符数组，
			// 还是12345678那个例子，这个for循环第一次结束后，buf[3]=4。
			buf[--charPos] = digits[r];
			i = q;
			// for循环结束后，buf内容为“12345678”；
			if (i == 0)
				break;
		}
		if (sign != 0) {
			buf[--charPos] = sign;
		}
	}

	// 其中用到的几个数组

	// 100以内的数字除以10的结果（取整），
	// 比如取DigitTens[78]，返回的是数字7
	// 只要是70-79的数字，返回的都是7，依次类推，所以总结出规律，其实就是返回的对应数字除10取整的结果。
	final static char[] DigitTens = { '0', '0', '0', '0', '0', '0', '0', '0',
			'0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '2',
			'2', '2', '2', '2', '2', '2', '2', '2', '2', '3', '3', '3', '3',
			'3', '3', '3', '3', '3', '3', '4', '4', '4', '4', '4', '4', '4',
			'4', '4', '4', '5', '5', '5', '5', '5', '5', '5', '5', '5', '5',
			'6', '6', '6', '6', '6', '6', '6', '6', '6', '6', '7', '7', '7',
			'7', '7', '7', '7', '7', '7', '7', '8', '8', '8', '8', '8', '8',
			'8', '8', '8', '8', '9', '9', '9', '9', '9', '9', '9', '9', '9',
			'9', };

	// 100以内的数字对10取模的结果，
	// 比如取DigitTens[78]，返回的8
	final static char[] DigitOnes = { '0', '1', '2', '3', '4', '5', '6', '7',
			'8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0',
			'1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3',
			'4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6',
			'7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
			'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2',
			'3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5',
			'6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8',
			'9', };
	final static char[] digits = { '0', '1', '2', '3', '4', '5', '6', '7', '8',
			'9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l',
			'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y',
			'z' };

	public static String toString(int i) {
		if (i == Integer.MIN_VALUE)
			return "-2147483648";
		int size = (i < 0) ? stringSize(-i) + 1 : stringSize(i);
		char[] buf = new char[size];
		getChars(i, size, buf);
		return new String(buf);
	}

	public static void main(String[] args) {
		// Integer DecimalI = Integer.decode("+10");
		// Integer OctI = Integer.decode("-010");
		// Integer HexI = Integer.decode("-0x10");
		// Integer HexI1 = Integer.decode("#10");
		// System.out.println(DecimalI);
		// System.out.println(OctI);
		// System.out.println(HexI);
		// System.out.println(HexI1);
		char[] a = new char[9];
		getChars(123456789, 9, a);
	}
}
