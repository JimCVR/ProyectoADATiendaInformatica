package controlador

import aplicacion.modelo.GestorModelo
import modelo.clases.Producto
import modelo.clases.Proveedor
import modelo.sentencias.SentenciasSQL
import vista.Vista
import java.sql.Connection
import java.sql.ResultSet
import java.sql.SQLException

class AppController() {

    private val vista: Vista = Vista()
    private val gestor = GestorModelo.getInstance()
    private fun onSelectProducto(query:String) {
        val listaProducto: MutableList<Producto> =  mutableListOf()
        try {

            val cn: Connection = gestor.conect()
            val ps = cn.prepareStatement(query)
            val rs: ResultSet = ps.executeQuery()
            while (rs.next()) {
                listaProducto.add(Producto(
                    rs.getString(1),
                    rs.getString(2),
                    rs.getInt(3),
                    rs.getDouble(4),
                    rs.getString(5),
                    rs.getString(6))
                )
            }
        } catch (s: SQLException) {
            s.printStackTrace()
        } finally {
            vista.mostrarProducto(listaProducto)
            gestor.disconect()
        }
    }
    fun onSelectAllProducto() {
        onSelectProducto(SentenciasSQL.selectAllProducto)
    }
    fun onSelectProductoId(id:String) {
        val listaProducto: MutableList<Producto> =  mutableListOf()
        try {

            val cn: Connection = gestor.conect()
            val ps = cn.prepareStatement(SentenciasSQL.selectProductoId)
            ps.setString(1,id)
            val rs: ResultSet = ps.executeQuery()
            while (rs.next()) {
                listaProducto.add(Producto(
                    rs.getString(1),
                    rs.getString(2),
                    rs.getInt(3),
                    rs.getDouble(4),
                    rs.getString(5),
                    rs.getString(6))
                )
            }
        } catch (s: SQLException) {
            s.printStackTrace()
        } finally {
            vista.mostrarProducto(listaProducto)
            gestor.disconect()
        }
    }
    fun onSelectProdDisponible() {
        onSelectProducto(SentenciasSQL.selectProdDisponible)
    }
    fun onSelectProdNoDisponible() {
        onSelectProducto(SentenciasSQL.selectProdNoDisponible)
    }
    fun onSelectAllProveedor() {
        val listaProveedor: MutableList<Proveedor> =  mutableListOf()
        try {
            val cn: Connection = gestor.conect()
            val ps =
                cn.prepareStatement(SentenciasSQL.selectAllProveedor)
            val rs = ps.executeQuery()
            while (rs.next()) {
                listaProveedor.add(
                    Proveedor(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                    )
                )
            }

        } catch (s: SQLException) {
            s.printStackTrace()
        } finally {
            vista.mostrarProveedor(listaProveedor)
            gestor.disconect()
        }

    }
    fun onSelectProveedorId(id:String){
        val listaProveedor: MutableList<Proveedor> =  mutableListOf()
        try {
            val cn: Connection = gestor.conect()
            val ps =
                cn.prepareStatement(SentenciasSQL.selectProveedorId)
            ps.setString(1,id)
            val rs = ps.executeQuery()
            while (rs.next()) {
                listaProveedor.add(
                    Proveedor(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                    )
                )
            }
        } catch (s: SQLException) {
            s.printStackTrace()
        } finally {
            vista.mostrarProveedor(listaProveedor)
            gestor.disconect()
        }
    }


    fun onInsertProducto(producto: Producto) {
        try {
            val cn: Connection = gestor.conect()
            val ps = cn.prepareStatement(SentenciasSQL.insertProduct)
            ps.setString(1, producto.id)
            ps.setString(2, producto.nombre)
            ps.setInt(3, producto.existencias)
            ps.setDouble(4, producto.precio)
            ps.setString(5, producto.tipo)
            ps.setString(6, producto.idProveedor)

            ps.executeUpdate()

        } catch (s: SQLException) {
            s.printStackTrace()
        } finally {
            vista.insertRealizado()
            gestor.disconect()
        }
    }

    fun onInsertProveedor(proveedor: Proveedor) {
        try {

            val cn: Connection = gestor.conect()
            val ps = cn.prepareStatement(SentenciasSQL.insertProveedor)
            ps.setString(1, proveedor.id)
            ps.setString(2, proveedor.nombre)
            ps.setString(3, proveedor.direccion)
            ps.setInt(4, proveedor.telefono)

            ps.executeUpdate()

        } catch (s: SQLException) {
            s.printStackTrace()
        } finally {
            vista.insertRealizado()
            gestor.disconect()
        }
    }

    fun onUpdateExistencias(id:String,cant:Int){
        var nLineas:Int=0
        try {
            val cn: Connection = gestor.conect()
            val ps =
                cn.prepareStatement(SentenciasSQL.updateCantProd)
            ps.setInt(1, cant)
            ps.setString(2, id)
            nLineas = ps.executeUpdate()
        } catch (s: SQLException) {
            s.printStackTrace()
        }finally {
            vista.updateRealizado(nLineas)
            gestor.disconect()
        }
    }

    fun onUpdatePrecio(id:String ,precio:Double){
        var nLineas:Int=0
        try {
            val cn: Connection = gestor.conect()
            val ps =
                cn.prepareStatement(SentenciasSQL.updatePriceProd)
            ps.setDouble(1, precio)
            ps.setString(2, id)
            nLineas=ps.executeUpdate()
        } catch (s: SQLException) {
            s.printStackTrace()
        }finally {
            vista.updateRealizado(nLineas)
            gestor.disconect()
        }
    }

    fun onUpdateDirProveedor(id:String,direccion:String){
        var nLineas:Int=0
        try {
            val cn: Connection = gestor.conect()
            val ps =
                cn.prepareStatement(SentenciasSQL.updateDirProveedor)
            ps.setString(1, direccion)
            ps.setString(2, id)
            nLineas=ps.executeUpdate()
        } catch (s: SQLException) {
            s.printStackTrace()
        }finally {
            vista.updateRealizado(nLineas)
            gestor.disconect()
        }
    }

    fun onUpdateTelProveedor(id:String ,telefono:Int){
        var nLineas:Int=0
        try {
            val cn: Connection = gestor.conect()
            val ps =
                cn.prepareStatement(SentenciasSQL.updateTelProveedor)
            ps.setInt(1, telefono)
            ps.setString(2, id)
            nLineas=ps.executeUpdate()
        } catch (s: SQLException) {
            s.printStackTrace()
        }finally {
            vista.updateRealizado(nLineas)
            gestor.disconect()
        }
    }

    fun onDeleteProductoId(id:String){
        var nLineas:Int=0
        val cn: Connection = gestor.conect()
        try {
            cn.autoCommit = false
            val ps = cn.prepareStatement(SentenciasSQL.deleteProductoId)
            ps.setString(1,id)
            nLineas=ps.executeUpdate()
        } catch (s: SQLException) {
            s.printStackTrace()
        }finally {
            cn.commit()
            vista.deleteRealizado(nLineas)
            gestor.disconect()
        }
    }

    fun onDeleteProductoTipo(tipo:String){
        var nLineas:Int=0
        val cn: Connection = gestor.conect()
        try {
            cn.autoCommit = false
            val ps =
                cn.prepareStatement(SentenciasSQL.deleteProductoTipo)
            ps.setString(1,tipo)
            nLineas=ps.executeUpdate()
        } catch (s: SQLException) {
            s.printStackTrace()
        }finally {
            cn.commit()
            vista.deleteRealizado(nLineas)
            gestor.disconect()
        }
    }

    fun onDeleteProveedor(id:String){
        var nLineas:Int=0
        val cn: Connection = gestor.conect()
        try {
            cn.autoCommit = false
            val ps =
                cn.prepareStatement(SentenciasSQL.deleteProveedorId)
            ps.setString(1,id)
            nLineas=ps.executeUpdate()
        } catch (s: SQLException) {
            s.printStackTrace()
        }finally {
            cn.commit()
            vista.deleteRealizado(nLineas)
            gestor.disconect()
        }
    }

    fun onStart(){
        vista.menuPrincipal()
    }

    fun onExit() {
        val gestor: GestorModelo = GestorModelo.getInstance()
        gestor.disconect()
        vista.salir()
    }

}