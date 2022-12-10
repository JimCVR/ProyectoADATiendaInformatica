package vista

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
                "elije" +
                "1.Mostrar lista de proveedores" +
                "")

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