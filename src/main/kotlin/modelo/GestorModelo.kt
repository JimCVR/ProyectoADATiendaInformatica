package aplicacion.modelo

import java.sql.Connection
import java.sql.DriverManager

class GestorModelo private constructor() {
    companion object {
        private var instance: GestorModelo? = null

        fun getInstance(): GestorModelo {

            if (instance == null) {
                instance = GestorModelo()
            }

            return instance!!
        }

    }

    private val url: String = "jdbc:mysql://localhost/"
    private val bd: String = "oficinaDB"
    private val user: String = "root"
    private val pass: String = ""

    @Volatile
    private var conn: Connection? = null

    fun conect(): Connection {
        if (conn == null || !conn!!.isClosed()) {
            Class.forName("com.mysql.cj.jdbc.Driver")
            conn = DriverManager.getConnection(url + bd, user, pass)

            println("___/Conexion realizada correctamente")
        } else if (conn!!.isClosed()) {
            Class.forName("com.mysql.cj.jdbc.Driver")
            conn = DriverManager.getConnection(url + bd, user, pass)

            println("___/Conexion realizada correctamente")
        } else {
            println("___/Ya existe una conexion\\___")
        }
        return conn!!
    }

    fun disconect() {
        if (conn != null) {
            conn!!.close()
        }
    }
}