package Encodeanddecode;

import org.apache.commons.codec.binary.Base64;

public class EncodeandDecode {

	public static void main(String[] args) {
		
		String str = "ravalika@123";
		
		byte[] encodedString = Base64.encodeBase64(str.getBytes());
		System.out.println("encoded string:"+new String(encodedString));
		
		byte[] decodedString = Base64.decodeBase64(encodedString);
		System.out.println("encoded string:"+new String(decodedString));

	}

}
