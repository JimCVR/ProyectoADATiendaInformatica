import controlador.AppController
import vista.Vista

fun main(){
    var controller: AppController = AppController(Vista())
   // controller.onSelectProveedor()
   controller.onStart()
    //controller.onExit()
}