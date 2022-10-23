package br.com.gotoviagens.util;
/*
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
*/

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class SenhaUtil {
	
	// CRIPTOGRAFA A SENHA
	// CONVERTE A SENHA QUE O USUÁRIO INSERIR NA VIEW
	
    public static String encode(String senha) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(senha);
    }

    public static boolean matches(String senha, String hash) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        return encoder.matches(senha, hash);
    }
	
	
	/*
	public static String md5(String senha) throws NoSuchAlgorithmException {
		MessageDigest messagedig = MessageDigest.getInstance("MD5");
		BigInteger hash = new BigInteger(1, messagedig.digest(senha.getBytes()));
		
		// QUANTIDADE DE CARACTERES DA SENHA CRIPTOGRAFADA
		return hash.toString(16);
	}
	*/

}
