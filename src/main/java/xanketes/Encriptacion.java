package xanketes;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.spec.KeySpec;
import java.util.Base64;

public class Encriptacion {
    private static final String ALGORITHM = "DES";
    private static final String CLAVE = "asdf234f";

    /** Encripta una cadena usando DES
     * @param cadena Cadena a encriptar
     * @return Cadena encriptada
     */
    public static String encriptar(String cadena) {
        try {
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            SecretKey secretKey = generarClaveSecreta(CLAVE);
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            return Base64.getEncoder().encodeToString(cipher.doFinal(cadena.getBytes(StandardCharsets.UTF_8)));
        } catch (Exception e) {
            System.out.println("Error encriptando: " + e);
        }
        return null;
    }

    /** Desencripta una cadena usando DES
     * @param strToDecrypt Cadena a desencriptar
     * @return Cadena desencriptada
     */
    public static String desencriptar(String strToDecrypt) {
        try {
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            SecretKey secretKey = generarClaveSecreta(CLAVE);
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
        } catch (Exception e) {
            System.out.println("Error desencriptando: " + e);
        }
        return null;
    }

    /** Genera una clave secreta para usar con DES
     * @param claveSecreta Clave secreta para encriptar
     * @return Clave secreta que se pueda usar con DES
     * @throws Exception Si hay un error generando la clave secreta
     */
    private static SecretKey generarClaveSecreta(String claveSecreta) throws Exception {
        // Aquí se genera la clave de encriptacion, cambiando el algoritmo.
        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBEWithMD5AndDES");
        KeySpec spec = new PBEKeySpec(claveSecreta.toCharArray(), claveSecreta.getBytes(), 65536, 64);
        SecretKey tmp = factory.generateSecret(spec);
        return new SecretKeySpec(tmp.getEncoded(), "DES");
    }
}