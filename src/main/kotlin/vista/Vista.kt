package vista

import controlador.AppController
import modelo.clases.Producto
import modelo.clases.Proveedor

class Vista {
    fun menuPrincipal(){
        println("Bienvenido, elija una opción:" +
                "\n1.Gestionar proveedores"+
                "\n2.Gestionar productos" +
                "\n0.Salir")
        var error:Boolean = false
        do {
            var opc: Int = readln().toInt()
            when(opc){
                1 -> menuProveedor()
                2 -> menuProducto()
                0 -> error=true
                else -> {
                    println("Opción incorrecta, introduzca otra:")
                }
            }
        } while (!error);
    }
    fun menuProveedor(){
        println("ÁREA DE PROVEEDORES" +
                "\nelije" +
                "\n1.Mostrar lista de proveedores." +
                "\n2.Mostrar información de un proveedor." +
                "\n3.Añadir nuevo proveedor."+
                "\n4.Actualizar datos de un proveedor (telefono o dirección)." +
                "\n5.Borrar un proveedor.")
        var error:Boolean = false
        do{
            var opc: Int = readln().toInt()
            when(opc){
                1 -> AppController().onSelectProveedor()
                2 -> AppController().onSelectProveedor()
                3 -> {
                    println("Id:")
                    var id:String = readln().toString()
                    println("Nombre:")
                    var nombre:String = readln().toString()
                    println("Dirección:")
                    var direccion:String = readln().toString()
                    println("Teléfono:")
                    var telefono:Int = readln().toInt()
                    var nuevoProv: Proveedor = Proveedor(id,nombre,direccion,telefono)
                    AppController().onInsertProveedor("insert proveedor", nuevoProv)
                }
                4 -> {
                    println("¿Actualizar teléfono(1) o dirección(2)?")
                    var opcAct: Int = readln().toInt()
                    while(true)
                    if(opcAct == 1){

                        //AppController().onUpdateTelProveedor()
                    }else if(opcAct == 2){
                        //
                    }else{
                        println("Opción no válida, elije de nuevo (1 o 2):")
                        continue;
                    }
                }
                //5 -> //AppController().onDeleteProveedor()
            }
        }while (!error)

    }
    fun menuProducto(){
        println("Inventario")
        println("*********************")
        println("1.Consulta")
        println("1.1.Consultar productos")
        println("1.2.Consultar producto concreto")
        println("1.3.Consultar producto disponibles")
        println("1.4.Consultar producto fuera de stock")
        println("2.Insertar productos")
        println("3.Actualizar producto")

        println("4.Borrar producto")
        println("4.1.Borrar producto concreto")
        println("4.2.Borrar producto por tipo")

        println("5.Aumentar Stock")
        println("6.")
        println("*********************")
    }
fun mostrarProveedor(listaProveedor: MutableList<Proveedor>){

     listaProveedor.forEach(){ proveedor: Proveedor ->
         println(proveedor.id)
         println(proveedor.nombre)
         println(proveedor.direccion)
         println(proveedor.telefono)

    }
}
fun mostrarProducto(listaProducto: MutableList<Producto>){
    println("Muestra productos")
}

    fun basedeDatosCaida() {
        println("Error. Base de datos caida")
    }

    fun noProdStock() {
        println("No existen productos")
    }

    fun errorGeneral() {
        println("Error general")
    }



    fun salir() {
        println("Adios")
    }

}