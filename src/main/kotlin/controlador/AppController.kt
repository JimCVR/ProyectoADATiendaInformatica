package controlador

import aplicacion.modelo.GestorModelo
import modelo.clases.Producto
import modelo.clases.Proveedor
import modelo.sentencias.SentenciasSQL
import vista.Vista
import java.sql.Connection
import java.sql.SQLException

class AppController(val vista: Vista) {

    private val gestor = GestorModelo.getInstance()
    fun selectAll(){
        try{

            val cn: Connection = gestor.conect()
            val ps = cn.prepareStatement("select * from empleados")
            val rs = ps.executeQuery()
            while(rs.next()){
                println(rs.getString(1))
                println(rs.getString(2))
                println(rs.getString(3))
                println(rs.getString(4))
            }
        }catch(s: SQLException){
            s.printStackTrace()
        }
        finally {
            gestor.disconect()
        }
    }




    fun select(){
        try {
            val cn: Connection = gestor.conect()
            val ps =
                cn.prepareStatement(SentenciasSQL)
            val rs = ps.executeQuery()
            while (rs.next()) {
                println(rs.getString(1))
                println(rs.getString(2))
                println(rs.getString(3))
                println(rs.getString(4))
            }

        } catch (s: SQLException) {
            s.printStackTrace()
        }finally {
            gestor.disconect()
        }

    }

    fun insert(){
        try {
            gestor.cargarDriver()
            val cn: Connection = gestor.establecerConexion()!!
            val ps = cn.prepareStatement()
            ps.setString(1, empleado.id.lowercase())
            ps.setString(2, empleado.nombre)
            ps.setString(3, empleado.oficio)
            ps.setString(4, empleado.departamento)
            ps.executeUpdate()

        } catch (s: SQLException) {
            s.printStackTrace()
        }finally {
            gestor.cerrarConexion()
        }
    }

    fun delete(id: String){
        try {


            val ps =
                cn.prepareStatement("delete from empleados where id = '" + id.lowercase() + "'")
            ps.executeUpdate()
        } catch (s: SQLException) {
            s.printStackTrace()
        }finally {
            gestor.cerrarConexion()
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

    fun onAllProducts(){
        val gestor: GestorModelo = GestorModelo.getInstance()
        gestor.conect()
        val listaProductos:List<Producto>?

        if(listaProductos == null){
            vista.basedeDatosCaida()
        }else if(listaProductos.size == 0){
            vista.noProdStock()
        }else if(listaProductos.size>0){
            for(producto in listaProductos){
                vista.showProduct(producto)
            }
        }else{
            vista.errorGeneral()
        }
    }

    fun onStart(): Int {
        val opcion  = vista.mainMenu()
        return opcion
    }

    fun onExit() {
        val gestor: GestorModelo = GestorModelo.getInstance()
        gestor.disconect()
        vista.salir()
    }

