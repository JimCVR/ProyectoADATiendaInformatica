import controlador.AppController
import vista.Vista

fun main(){
    var controller: AppController = AppController(Vista())
    controller.onStart()
    controller.onExit()
}