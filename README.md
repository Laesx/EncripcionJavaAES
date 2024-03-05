# Aplicación de Encriptación Simple en Java

Esta aplicación es un simple programa de encriptación y desencriptación que utiliza el algoritmo DES (Data Encryption Standard). El programa toma una entrada del usuario, la encripta utilizando DES y luego la desencripta para demostrar la funcionalidad del algoritmo.

## Cómo usar la aplicación

1. Ejecute el archivo `Main.java`. Esto iniciará la aplicación.
2. Cuando se le solicite, introduzca un mensaje para encriptar. Este mensaje puede ser cualquier cadena de texto.
3. La aplicación encriptará su mensaje utilizando el algoritmo DES y mostrará el mensaje encriptado.
4. A continuación, la aplicación desencriptará el mensaje encriptado y mostrará el mensaje original.

## Sobre el algoritmo DES

DES (Data Encryption Standard) es un algoritmo de cifrado simétrico (es decir, utiliza la misma clave para cifrar y descifrar los datos). Fue desarrollado en los años 70 por IBM y ha sido utilizado en una variedad de aplicaciones desde entonces.

El algoritmo DES utiliza una clave de 64 bits, aunque efectivamente sólo utiliza 56 bits ya que 8 de los bits se utilizan para la detección de errores. DES es un algoritmo de bloque, lo que significa que cifra los datos en bloques de un tamaño determinado (64 bits en el caso de DES).

Aunque DES fue considerado seguro durante mucho tiempo, las mejoras en la potencia de procesamiento han hecho que sea posible romper el cifrado DES mediante fuerza bruta. Como resultado, DES ha sido en gran medida reemplazado por algoritmos más seguros como AES.

## Estructura del código

El código consta de dos clases principales: `Main.java` y `Encriptacion.java`.

- `Main.java`: Esta es la clase principal que ejecuta la aplicación. Solicita al usuario que introduzca un mensaje, luego utiliza la clase `Encriptacion` para encriptar y desencriptar el mensaje.

- `Encriptacion.java`: Esta clase contiene los métodos para encriptar y desencriptar los datos. Utiliza el algoritmo DES para realizar estas operaciones.

## Código de ejemplo

Aquí se muestra cómo se utiliza la clase `Encriptacion` para encriptar y desencriptar un mensaje:

```java
String mensaje = "Este es un mensaje de prueba";
String mensajeEncriptado = Encriptacion.encriptar(mensaje);
System.out.println("Mensaje encriptado: " + mensajeEncriptado);

String mensajeDesencriptado = Encriptacion.desencriptar(mensajeEncriptado);
System.out.println("Mensaje desencriptado: " + mensajeDesencriptado);
```

En este ejemplo, el mensaje "Este es un mensaje de prueba" se encripta y luego se desencripta, mostrando tanto el mensaje encriptado como el mensaje original.
