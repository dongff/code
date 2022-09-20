package cn.com.utils;

import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

public final class EncrypRSA {

	private static final char[] HEX_LOOKUP_STRING = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a',
			'b', 'c', 'd', 'e', 'f' };

	private static final int MAX_ENCRYPT_BLOCK = 117;

	private static final int MAX_DECRYPT_BLOCK = 128;

	public static final String SIGN_ALGORITHMS = "SHA1WithRSA";

	// 数字签名，密钥算法
	public static final String RSA_KEY_ALGORITHM = "RSA";

	/**
	 * 本方法用于产生1024位RSA公私钥对。
	 *
	 * @return 私钥、公钥
	 */
	public static String[] genRSAKeyPair() {
		KeyPairGenerator rsaKeyGen = null;
		KeyPair rsaKeyPair = null;
		try {
			rsaKeyGen = KeyPairGenerator.getInstance(RSA_KEY_ALGORITHM);
			SecureRandom random = new SecureRandom();
			random.setSeed(("" + System.currentTimeMillis() * Math.random() * Math.random()).getBytes());
			rsaKeyGen.initialize(1024, random);
			rsaKeyPair = rsaKeyGen.genKeyPair();
			PublicKey rsaPublic = rsaKeyPair.getPublic();
			PrivateKey rsaPrivate = rsaKeyPair.getPrivate();

			String privateAndPublic[] = new String[2];
			privateAndPublic[0] = bytesToHexStr(rsaPrivate.getEncoded());
			privateAndPublic[1] = bytesToHexStr(rsaPublic.getEncoded());

			System.out.println("私钥:" + privateAndPublic[0]);
			System.out.println("公钥:" + privateAndPublic[1]);

			return privateAndPublic;
		} catch (Exception e) {

			return null;
		}
	}

	public static String bytesToHexStr(byte[] bcd) {
		StringBuffer s = new StringBuffer(bcd.length * 2);
		byte[] arr$ = bcd;
		int len$ = bcd.length;

		for (int i$ = 0; i$ < len$; ++i$) {
			byte aBcd = arr$[i$];
			s.append(HEX_LOOKUP_STRING[aBcd >>> 4 & 15]);
			s.append(HEX_LOOKUP_STRING[aBcd & 15]);
		}

		return s.toString();
	}

	public static byte[] hexStrToBytes(String s) {
		byte[] bytes = new byte[s.length() / 2];

		for (int i = 0; i < bytes.length; ++i) {
			bytes[i] = (byte) Integer.parseInt(s.substring(2 * i, 2 * i + 2), 16);
		}

		return bytes;
	}

	/**
	 * 得到私钥对象
	 *
	 * @param key
	 *            密钥字符串（经过16进制编码）
	 * @throws Exception
	 */
	public static PrivateKey getPrivateKey(String key) throws Exception {
		try {
			byte[] keyBytes = hexStrToBytes(key.trim());
			PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(keyBytes);
			KeyFactory keyFactory = KeyFactory.getInstance(RSA_KEY_ALGORITHM);
			return keyFactory.generatePrivate(keySpec);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * 得到公钥对象
	 *
	 * @param key
	 *            密钥字符串（经过16进制编码）
	 * @throws Exception
	 */
	public static PublicKey getPublicKey(String key) throws Exception {
		try {
			byte[] keyBytes = hexStrToBytes(key.trim());
			X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
			KeyFactory keyFactory = KeyFactory.getInstance(RSA_KEY_ALGORITHM);
			return keyFactory.generatePublic(keySpec);
		} catch (Exception e) {

			throw e;
		}
	}

	/**
	 * 本方法使用SHA1withRSA签名算法产生签名
	 *
	 * @param privateKey
	 *            privateKey 签名时使用的私钥(16进制编码)
	 * @param src
	 *            src 签名的原字符串
	 * @return String 签名的返回结果(16进制编码)。当产生签名出错的时候，返回null。
	 */
	public static String sign(PrivateKey privateKey, String src, String encode) throws Exception {
		try {
			Signature sigEng = Signature.getInstance(SIGN_ALGORITHMS);
			sigEng.initSign(privateKey);
			sigEng.update(src.getBytes(encode));
			byte[] signature = sigEng.sign();
			return bytesToHexStr(signature);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * 本方法使用SHA1withRSA签名算法验证签名
	 *
	 * @param publicKey
	 *            pubKey 验证签名时使用的公钥(16进制编码)
	 * @param sign
	 *            sign 签名结果(16进制编码)
	 * @param src
	 *            src 签名的原字符串
	 * @throws NoSuchAlgorithmException
	 * @throws InvalidKeyException
	 *             验证失败时抛出异常
	 */
	public static boolean verify(PublicKey publicKey, String sign, String src, String encode) throws Exception {
		Signature sigEng = Signature.getInstance("SHA1withRSA");
		sigEng.initVerify(publicKey);
		sigEng.update(src.getBytes(encode));
		byte[] sign1 = hexStrToBytes(sign);
		if (!sigEng.verify(sign1)) {
			throw new RuntimeException("验证签名失败");
		}
		return true;
	}

	/**/ public static void main(String[] args) throws Exception {
		// 生成公私钥
		String[] genRSAKeyPair = genRSAKeyPair();

		String aaa = "{\"version\":\"1.0\",\"billno\":\"13652141\",\"orderId\":\"2018112008081840203148132\"}";

		// 用私钥加签
		// String ccc = sign(
		// getPrivateKey(
		// "9b9e19a8d6597afffbd34ae14b1f81db291d165b370268212b20394ef0a49c23a015596027a2815405d74bae0e35e79108afa9aeb3a96351eb884abfc180fa826fb3e7183f1b299641962405722271da4fb96970de95fe949de2541fff77a4de1d7b712ffc50ab6129679713ee4e2125595a3f53c169881287af9e6f22a662d7"),
		// aaa, "UTF-8");

		String sgin = "9b9e19a8d6597afffbd34ae14b1f81db291d165b370268212b20394ef0a49c23a015596027a2815405d74bae0e35e79108afa9aeb3a96351eb884abfc180fa826fb3e7183f1b299641962405722271da4fb96970de95fe949de2541fff77a4de1d7b712ffc50ab6129679713ee4e2125595a3f53c169881287af9e6f22a662d7";

		String pub = "30819f300d06092a864886f70d010101050003818d00308189028181009f75b6c023e26303fc7ad588935d4f929c26bc1bd6b4d18ab6bc097165ef9243104ceda85f99dc37a7581f052d54f692b14ee16c87506440681813d774089dcd8bb1bcc3ae1411ca9f20ceb2f5ea1e5addefa0023777510a701c95661131944a74646cb585eeb21a0f74086a28227efa1380b0ed0c763ea7c504d875c31fd51f0203010001";
		// 用公钥解签
		boolean verify = verify(getPublicKey(pub), sgin, aaa, "UTF-8");

		System.out.println(verify);
	}

}
