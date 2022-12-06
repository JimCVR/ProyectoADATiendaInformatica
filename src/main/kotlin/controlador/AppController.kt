package controlador

import aplicacion.modelo.GestorModelo
import modelo.clases.Producto
import modelo.clases.Proveedor
import modelo.sentencias.SentenciasSQL
import vista.Vista
import java.sql.Connection
import java.sql.ResultSet
import java.sql.SQLException

class AppController(val vista: Vista) {

    private val gestor = GestorModelo.getInstance()
    fun selectProducto(query: String) {
        try {

            val cn: Connection = gestor.conect()
            val ps = cn.prepareStatement(query)
            val rs: ResultSet = ps.executeQuery()
            while (rs.next()) {
                println(rs.getString(1))
                println(rs.getString(2))
                println(rs.getInt(3))
                println(rs.getDouble(4))
                println(rs.getString(5))
            }
        } catch (s: SQLException) {
            s.printStackTrace()
        } finally {
            gestor.disconect()
        }
    }


    fun selectProveedor() {
        try {
            val cn: Connection = gestor.conect()
            val ps =
                cn.prepareStatement(SentenciasSQL.selectAllProducto)
            val rs = ps.executeQuery()
            while (rs.next()) {
                println(rs.getString(1))
                println(rs.getString(2))
                println(rs.getString(3))
                println(rs.getInt(4))
                println(rs.getString(5))
            }

        } catch (s: SQLException) {
            s.printStackTrace()
        } finally {
            gestor.disconect()
        }

    }

    fun insertProducto(query: String, producto: Producto) {
        try {

            val cn: Connection = gestor.conect()
            val ps = cn.prepareStatement(query)
            ps.setString(1, producto.id)
            ps.setString(2, producto.nombre)
            ps.setInt(3, producto.existencias)
            ps.setDouble(4, producto.precio)
            ps.setString(5, producto.tipo)

            ps.executeUpdate()

        } catch (s: SQLException) {
            s.printStackTrace()
        } finally {
            gestor.disconect()
        }
    }

    fun insertProveedor(query: String, proveedor: Proveedor) {
        try {

            val cn: Connection = gestor.conect()
            val ps = cn.prepareStatement(query)
            ps.setString(1, proveedor.id)
            ps.setString(2, proveedor.nombre)
            ps.setString(3, proveedor.direccion)
            ps.setInt(4, proveedor.telefono)
            ps.setString(5, proveedor.idProd)

            ps.executeUpdate()

        } catch (s: SQLException) {
            s.printStackTrace()
        } finally {
            gestor.disconect()
        }
    }

    fun onUpdateExistencias(producto: Producto,cant:Int){

        try {
            val cn: Connection = gestor.conect()
            gestor.conect()
            val ps =
                cn.prepareStatement(SentenciasSQL.updateCantProd)
            ps.setInt(1, cant)
            ps.setString(2, producto.id)
            ps.executeUpdate()
        } catch (s: SQLException) {
            s.printStackTrace()
        }finally {
            gestor.disconect()
        }
    }

    fun onUpdatePrecio(producto:Producto ,precio:Double){

        try {
            val cn: Connection = gestor.conect()
            gestor.conect()
            val ps =
                cn.prepareStatement(SentenciasSQL.updateCantProd)
            ps.setDouble(1, precio)
            ps.setString(2, producto.id)
            ps.executeUpdate()
        } catch (s: SQLException) {
            s.printStackTrace()
        }finally {
            gestor.disconect()
        }
    }

    fun onUpdateDirProveedor(proveedor: Proveedor ,direccion:String){

        try {
            val cn: Connection = gestor.conect()
            gestor.conect()
            val ps =
                cn.prepareStatement(SentenciasSQL.updateDirProveedor)
            ps.setString(1, direccion)
            ps.setString(2, proveedor.id)
            ps.executeUpdate()
        } catch (s: SQLException) {
            s.printStackTrace()
        }finally {
            gestor.disconect()
        }
    }

    fun onUpdateTelProveedor(proveedor: Proveedor ,telefono:Int){

        try {
            val cn: Connection = gestor.conect()
            gestor.conect()
            val ps =
                cn.prepareStatement(SentenciasSQL.updateDirProveedor)
            ps.setInt(1, telefono)
            ps.setString(2, proveedor.id)
            ps.executeUpdate()
        } catch (s: SQLException) {
            s.printStackTrace()
        }finally {
            gestor.disconect()
        }
    }
    /*fun onAllProducts() {
        val gestor: GestorModelo = GestorModelo.getInstance()
        gestor.conect()

        if (listaProductos == null) {
            vista.basedeDatosCaida()
        } else if (listaProductos.size == 0) {
            vista.noProdStock()
        } else if (listaProductos.size > 0) {
            for (producto in listaProductos) {
                vista.showProduct(producto)
            }
        } else {
            vista.errorGeneral()
        }
    }*/

    fun onStart(): Int {
        val opcion = vista.mainMenu()
        return opcion
    }

    fun onExit() {
        val gestor: GestorModelo = GestorModelo.getInstance()
        gestor.disconect()
        vista.salir()
    }
}

