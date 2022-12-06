package controlador

import aplicacion.modelo.GestorModelo
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
            gestor.cargarDriver()
            val cn: Connection = gestor.establecerConexion()!!
            val ps =
                cn.prepareStatement("delete from empleados where id = '" + id.lowercase() + "'")
            ps.executeUpdate()
        } catch (s: SQLException) {
            s.printStackTrace()
        }finally {
            gestor.cerrarConexion()
        }
    }

    fun update(){

        try {
            gestor.cargarDriver()
            val cn: Connection = gestor.establecerConexion()!!
            val ps =
                cn.prepareStatement("update empleados set " + columna + "= ? where id = '" + id.lowercase() + "'")
            ps.setString(1, valor)
            ps.executeUpdate()
        } catch (s: SQLException) {
            s.printStackTrace()
        }finally {
            gestor.cerrarConexion()
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

