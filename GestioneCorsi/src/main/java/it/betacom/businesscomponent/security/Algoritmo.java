package it.betacom.businesscomponent.security;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Algoritmo {
	public static String convertiMD5(String password) {
		try {
			//Permette di ricevere l'algoritmo da usare 
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] array = md.digest(password.getBytes(Charset.forName("UTF-8")));
			StringBuffer buffer = new StringBuffer();
			//Genera codifica pass a seconda dei caratteri che ho capassato
			String salt = "B4£#@Miz<<z8Rd6$1NpW9i7sL%3Tx"; //Fare sempre randomica
			for(int i = 0; i < array.length; i++) 
				buffer.append(String.format("%x", array[i])+salt.toCharArray()[i]);
			return buffer.toString();
		} catch(NoSuchAlgorithmException exc) {
			return null;
		}
	}
}
