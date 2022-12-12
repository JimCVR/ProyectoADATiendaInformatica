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
                "\nElige una opción:" +
                "\n1.Mostrar lista de proveedores." +
                "\n2.Mostrar información de un proveedor." +
                "\n3.Añadir nuevo proveedor."+
                "\n4.Actualizar datos de un proveedor (telefono o dirección)." +
                "\n5.Borrar un proveedor.")
        var error:Boolean = false
        do{
            var opc: Int = readln().toInt()
            when(opc){
                1 -> AppController().onSelectAllProveedor()
                2 -> {
                    println("Id del proveedor:")
                    var id: String = readln().toString()
                    AppController().onSelectProveedorId(id)
                }
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
                    AppController().onInsertProveedor(nuevoProv)
                }
                4 -> {
                    println("¿Actualizar teléfono(1) o dirección(2)?")
                    var opcAct: Int = readln().toInt()
                    while(true){
                        println("Id del proveedor:")
                        var id: String = readln().toString()
                        if(opcAct == 1){
                            println("Nuevo teléfono:")
                            var telefono:Int = readln().toInt()
                            AppController().onUpdateTelProveedor(id,telefono)
                        }else if(opcAct == 2){
                            println("Nueva dirección:")
                            var direccion:String = readln().toString()
                            AppController().onUpdateDirProveedor(id,direccion)
                        }else{
                            println("Opción no válida, elige de nuevo (1 o 2):")
                            continue;
                        }
                    }
                }
                5 -> {
                    println("Id del proveedor:")
                    var id: String = readln().toString()
                    AppController().onDeleteProveedor(id)
                }
            }
        }while (!error)

    }
    fun menuProducto(){
        println("INVENTARIO" +
                "\nElige una opcion" +
                "\n1.Mostrar lista de productos." +
                "\n2.Consultar producto por id." +
                "\n3.Consultar productos por disponibilidad"+
                "\n4.Insertar un nuevo producto." +
                "\n5.Actualizar existencias." +
                "\n6.Actualizar precio." +
                "\n7.Eliminar un producto.")
        var error:Boolean = false
        do{
            var opc: Int = readln().toInt()
            when(opc){
                1 -> AppController().onSelectAllProducto()
                2 ->{
                    println("Id del producto:")
                    var id:String = readln().toString()
                    AppController().onSelectProductoId(id)
                    }
                3 ->{
                    println("Productos disponibles:")
                    AppController().onSelectProdDisponible()
                    println("\nProductos fuera de stock:")
                    AppController().onSelectProdNoDisponible()
                }
                4 ->{
                    println("Id:")
                    var id:String = readln().toString()
                    println("Nombre:")
                    var nombre:String = readln().toString()
                    println("Existencias:")
                    var existencias:Int = readln().toInt()
                    println("Precio:")
                    var precio:Double = readln().toDouble()
                    println("Tipo:")
                    var tipo:String = readln().toString()
                    println("Id del proveedor:")
                    var idProv:String = readln().toString()
                    var producto:Producto = Producto(id,nombre,existencias,precio,tipo,idProv)
                    AppController().onInsertProducto(producto)
                }
                5 -> {
                    println("Id:")
                    var id:String = readln().toString()
                    println("Existencias:")
                    var existencias:Int = readln().toInt()
                    AppController().onUpdateExistencias(id,existencias)
                }
                6 -> {
                    println("Id:")
                    var id:String = readln().toString()
                    println("Nuevo precio:")
                    var precio:Double = readln().toDouble()
                    AppController().onUpdatePrecio(id,precio)
                }
                7 ->{
                    println("¿Borrar productos por id(1) o por tipo(2)?")
                    var opcAct: Int = readln().toInt()
                    while(true){
                        if(opcAct == 1){
                            println("Id:")
                            var id:String = readln().toString()
                            AppController().onDeleteProductoId(id)
                        }else if(opcAct == 2){
                            println("Tipo:")
                            var tipo:String = readln().toString()
                            AppController().onDeleteProductoTipo(tipo)
                        }else{
                            println("Opción no válida, elige de nuevo (1 o 2):")
                            continue;
                        }
                    }
                }
            }
        }while(!error)
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