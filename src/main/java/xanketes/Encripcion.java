package xanketes;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.spec.KeySpec;
import java.util.Base64;

/**
 * Clase con métodos para encriptar y desencriptar
 */
public class Encripcion {
    private static final String ALGORITHM = "AES";
    private static final String CLAVE = "asdf234fsdva%l9asdnklfa@f4f_adfafaAAaad;";

    public static String encriptar(String cadena) {
        try {
            // Creamos un objeto Cipher con el algoritmo deseado
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            //Aquí generamos la clave secreta que va a usar cipher
            SecretKey secretKey = generarClaveSecreta(CLAVE);
            // Inicializamos el cipher en modo encriptación con la clave secreta
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            // Devolvemos la cadena encriptada en base64
            return Base64.getEncoder().encodeToString(cipher.doFinal(cadena.getBytes(StandardCharsets.UTF_8)));
        } catch (Exception e) {
            System.out.println("Error encriptando: " + e.toString());
        }
        return null;
    }

    /** Desencripta una cadena
     * @param strToDecrypt Cadena a desencriptar
     * @return Cadena desencriptada
     */
    public static String desencriptar(String strToDecrypt) {
        try {
            // Creamos un objeto Cipher con el algoritmo deseado
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            // Generamos la clave secreta que va a usar cipher
            SecretKey secretKey = generarClaveSecreta(CLAVE);
            // Inicializamos el cipher en modo desencriptación con la clave secreta
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            // Devolvemos la cadena desencriptada
            return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
        } catch (Exception e) {
            System.out.println("Error desencriptando: " + e.toString());
        }
        return null;
    }

    /** Genera una clave secreta a partir de una cadena, que se pueda usar con AES
     * @param claveSecreta Clave secreta para encriptar
     * @return Clave secreta generada
     * @throws Exception Si hay un error generando la clave secreta
     */
    private static SecretKey generarClaveSecreta(String claveSecreta) throws Exception {
        // Creamos un objeto SecretKeyFactory con el algoritmo deseado
        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
        // Generamos la clave secreta a partir de la clave secreta y unos parámetros
        KeySpec spec = new PBEKeySpec(claveSecreta.toCharArray(), claveSecreta.getBytes(), 65536, 256);
        // Devolvemos la clave secreta generada
        SecretKey tmp = factory.generateSecret(spec);
        return new SecretKeySpec(tmp.getEncoded(), "AES");
    }
}
