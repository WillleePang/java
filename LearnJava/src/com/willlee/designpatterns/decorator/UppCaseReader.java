package com.willlee.designpatterns.decorator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FilterReader;
import java.io.IOException;
import java.io.Reader;

public class UppCaseReader extends FilterReader {
	public UppCaseReader(Reader in) {
		super(in);
	}

	@Override
	public int read(char[] cbuf, int off, int len) throws IOException {
		int result = super.read(cbuf, off, len);
		for (int i = off; i < len; i++) {
			if (cbuf[i] >= 'a' && cbuf[i] <= 'z') {
				cbuf[i] -= 32;
			}
		}
		return result;
	}

	public static void main(String[] args) throws IOException {
		Reader reader = new BufferedReader(new UppCaseReader(new FileReader(
				new File("src/files/HarryPotter.txt"))));
		int i = 0;
		while ((i = reader.read()) != -1) {
			System.out.print((char) i);
		}
	}
}
