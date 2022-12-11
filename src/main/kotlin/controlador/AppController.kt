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
    fun onSelectProducto(query: String) {
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
                    rs.getString(5))
                )
            }
        } catch (s: SQLException) {
            s.printStackTrace()
        } finally {
            vista.mostrarProducto(listaProducto)
            gestor.disconect()
        }
    }


    fun onSelectProveedor() {
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

    fun onInsertProducto(query: String, producto: Producto) {
        try {
            val cn: Connection = gestor.conect()
            val ps = cn.prepareStatement(query)
            ps.setString(1, producto.id)
            ps.setString(2, producto.nombre)
            ps.setInt(3, producto.existencias)
            ps.setDouble(4, producto.precio)
            ps.setString(5, producto.tipo)
            ps.setString(5, producto.idProveedor)

            ps.executeUpdate()

        } catch (s: SQLException) {
            s.printStackTrace()
        } finally {
            gestor.disconect()
        }
    }

    fun onInsertProveedor(query: String, proveedor: Proveedor) {
        try {

            val cn: Connection = gestor.conect()
            val ps = cn.prepareStatement(query)
            ps.setString(1, proveedor.id)
            ps.setString(2, proveedor.nombre)
            ps.setString(3, proveedor.direccion)
            ps.setInt(4, proveedor.telefono)

            ps.executeUpdate()

        } catch (s: SQLException) {
            s.printStackTrace()
        } finally {
            gestor.disconect()
        }
    }

    fun onUpdateExistencias(producto: Producto,cant:Int){
        var nLineas:Int=0
        try {
            val cn: Connection = gestor.conect()
            gestor.conect()
            val ps =
                cn.prepareStatement(SentenciasSQL.updateCantProd)
            ps.setInt(1, cant)
            ps.setString(2, producto.id)
            nLineas = ps.executeUpdate()
        } catch (s: SQLException) {
            s.printStackTrace()
        }finally {
            //vista.updateRealizado(nLineas)
            gestor.disconect()
        }
    }

    fun onUpdatePrecio(producto:Producto ,precio:Double){
        var nLineas:Int=0
        try {
            val cn: Connection = gestor.conect()
            gestor.conect()
            val ps =
                cn.prepareStatement(SentenciasSQL.updatePriceProd)
            ps.setDouble(1, precio)
            ps.setString(2, producto.id)
            nLineas=ps.executeUpdate()
        } catch (s: SQLException) {
            s.printStackTrace()
        }finally {
            //vista.updateRealizado(nLineas)
            gestor.disconect()
        }
    }

    fun onUpdateDirProveedor(proveedor: Proveedor ,direccion:String){
        var nLineas:Int=0
        try {
            val cn: Connection = gestor.conect()
            gestor.conect()
            val ps =
                cn.prepareStatement(SentenciasSQL.updateDirProveedor)
            ps.setString(1, direccion)
            ps.setString(2, proveedor.id)
            nLineas=ps.executeUpdate()
        } catch (s: SQLException) {
            s.printStackTrace()
        }finally {
            //vista.updateRealizado(nLineas)
            gestor.disconect()
        }
    }

    fun onUpdateTelProveedor(proveedor: Proveedor ,telefono:Int){
        var nLineas:Int=0
        try {
            val cn: Connection = gestor.conect()
            gestor.conect()
            val ps =
                cn.prepareStatement(SentenciasSQL.updateTelProveedor)
            ps.setInt(1, telefono)
            ps.setString(2, proveedor.id)
            nLineas=ps.executeUpdate()
        } catch (s: SQLException) {
            s.printStackTrace()
        }finally {
            //vista.updateRealizado(nLineas)
            gestor.disconect()
        }
    }

    fun onDeleteProductoId(producto:Producto){
        var nLineas:Int=0
        val cn: Connection = gestor.conect()
        try {
            cn!!.autoCommit = false
            gestor.conect()
            val ps =
                cn.prepareStatement(SentenciasSQL.deleteProductoId)
            ps.setString(1,producto.id)
            nLineas=ps.executeUpdate()
        } catch (s: SQLException) {
            s.printStackTrace()
        }finally {
            cn!!.commit()
            //vista.deleteRealizado(nLineas)
            gestor.disconect()
        }
    }

    fun onDeleteProductoTipo(producto:Producto){
        var nLineas:Int=0
        val cn: Connection = gestor.conect()
        try {
            cn!!.autoCommit = false
            gestor.conect()
            val ps =
                cn.prepareStatement(SentenciasSQL.deleteProductoTipo)
            ps.setString(1,producto.tipo)
            nLineas=ps.executeUpdate()
        } catch (s: SQLException) {
            s.printStackTrace()
        }finally {
            cn!!.commit()
            //vista.deleteRealizado(nLineas)
            gestor.disconect()
        }
    }

    fun onDeleteProveedor(proveedor: Proveedor){
        var nLineas:Int=0
        val cn: Connection = gestor.conect()
        try {
            cn!!.autoCommit = false
            gestor.conect()
            val ps =
                cn.prepareStatement(SentenciasSQL.deleteProveedorId)
            ps.setString(1,proveedor.id)
            nLineas=ps.executeUpdate()
        } catch (s: SQLException) {
            s.printStackTrace()
        }finally {
            cn!!.commit()
            //vista.deleteRealizado(nLineas)
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

    fun onStart(){
        val opcion = vista.menuPrincipal()
    }

    fun onExit() {
        val gestor: GestorModelo = GestorModelo.getInstance()
        gestor.disconect()
        vista.salir()
    }

}

