package com.willlee.crypto;

import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import com.willlee.utils.Base64Util;

public class AymmetricCryptographic {
	public static KeyPair getKeyPair() throws Exception {
		KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
		keyPairGenerator.initialize(512);
		KeyPair generateKeyPair = keyPairGenerator.generateKeyPair();
		return generateKeyPair;
	}

	public static byte[] publicEncrypt(byte[] content, PublicKey key) throws NoSuchAlgorithmException,
			NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
		Cipher cipher = Cipher.getInstance("RSA");
		cipher.init(Cipher.ENCRYPT_MODE, key);
		byte[] bytes = cipher.doFinal(content);
		return bytes;
	}

	public static byte[] privateDecrypt(byte[] content, PrivateKey key) throws NoSuchAlgorithmException,
			NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
		Cipher cipher = Cipher.getInstance("RSA");
		cipher.init(Cipher.DECRYPT_MODE, key);
		byte[] bytes = cipher.doFinal(content);
		return bytes;
	}

	public static byte[] sign(byte[] content, PrivateKey key) throws NoSuchAlgorithmException, NoSuchPaddingException,
			InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
		MessageDigest messageDigest = MessageDigest.getInstance("md5");
		byte[] bytes = messageDigest.digest(content);
		Cipher cipher = Cipher.getInstance("rsa");
		cipher.init(Cipher.ENCRYPT_MODE, key);
		byte[] encryptBytes = cipher.doFinal(bytes);
		return encryptBytes;
	}

	public static boolean verify(byte[] content, byte[] sign, PublicKey key) throws InvalidKeyException,
			NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
		MessageDigest md = MessageDigest.getInstance("md5");
		byte[] bytes = md.digest(content);

		Cipher cipher = Cipher.getInstance("rsa");
		cipher.init(Cipher.DECRYPT_MODE, key);
		byte[] decryptBytes = cipher.doFinal(sign);
		if (Base64Util.encode(bytes).equals(Base64Util.encode(decryptBytes))) {
			return true;
		} else {
			return false;
		}
	}
	
}
