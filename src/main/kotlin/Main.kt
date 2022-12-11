import controlador.AppController
import vista.Vista

fun main(){
    val vista:Vista= Vista()
    val controller:AppController = AppController(vista)
   // controller.onSelectProveedor()
   controller.onStart()

    //controller.onExit()
}