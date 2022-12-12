import controlador.AppController
import modelo.clases.Producto
import modelo.clases.Proveedor
import vista.Vista

fun main(){
    val vista:Vista= Vista()
    val controller:AppController = AppController()
    controller.onStart()

    //controller.onExit()
    //SELECTS
    //controller.onSelectAllProducto()
    //controller.onSelectProveedor()
    //controller.onSelectAllProveedor()
    //controller.onSelectProductoId("p001")
    //controller.onSelectProveedorId("pr001")
    //controller.onSelectProdDisponible()
    //controller.onSelectProdNoDisponible()

    //INSERTS
   // controller.onInsertProducto(Producto("p14","raton",0,5.80,"PERICO","pr001"))
   //controller.onInsertProveedor(Proveedor("p010","trust","calle mayor",111222444))

    //UPDATES

    //controller.onUpdateExistencias("p12",10)
    //controller.onUpdatePrecio("p12",50.9)
    //controller.onUpdateDirProveedor("p010","calle de la ensenada ada ada")
   //controller.onUpdateTelProveedor("p010",956852587)

    //DELETES
    // controller.onDeleteProveedor("p010")
    //controller.onDeleteProductoId("p1")
   // controller.onDeleteProductoTipo("PERICO")
}