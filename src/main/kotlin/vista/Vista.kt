package vista

class Vista {
    fun menuPrincipal(){
        println("Bienvenido")
        println("***********")
        println("1.Ir al area de Proveedores")
        println("2.Ir al Inventario")
    }
    fun menuProveedor(){
        println("Area de Proveedores")
        println("*********************")
        println("1.Consultar productos")
        println("2.Consultar producto")
        println("3.Actualizar producto")
        println("4.Borrar producto")
        println("*********************")
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



    fun basedeDatosCaida() {
        println("Error. Base de datos caida")
    }

    fun noProdStock() {
        println("No existen productos")
    }

    fun errorGeneral() {
        println("Error general")
    }

    fun mainMenu():Int {
        println("Bienvenido. Elije una opción")
        println("1. Mostrar productos con stock")
        println("0. Salir")
        return readln().trim().toInt()
    }

    fun salir() {
        println("Adios")
    }


}