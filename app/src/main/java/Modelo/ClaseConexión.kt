package Modelo

import java.lang.Exception
import java.sql.Connection
import java.sql.DriverManager

class ClaseConexión {

fun cadenaConexion():Connection?{
    try {
        val ip = "jdbc:oracle:thin:@10.10.0.54:1521:xe"
        val usuario = "system"
        val contrasena = "desarrollo"

        val conexion = DriverManager.getConnection(ip, usuario, contrasena)
        return conexion
    }
    catch (e: Exception){
        println("El error es este: $e")
        return null
    }
}

}