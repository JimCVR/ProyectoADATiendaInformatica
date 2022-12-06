package modelo.sentencias

object SentenciasSQL {

    //Sentencias productos
    val selectAllProducto:String = "SELECT * FROM producto"
    val insertProduct:String = "INSERT INTO producto VALUES(?,?,?,?,?)"
    val deleteProdForId:String = "DELETE FROM producto WHERE id=?"
    val updateCantProd:String = "UPDATE producto SET existencias=? WHERE id=?"
    val updatePriceProd:String = "UPDATE producto SET precio=? WHERE id=?"

    //Sentencias Proveedores
    val updateDirProveedor:String = "UPDATE proveedor SET direccion=? WHERE id=?"
    val updateTelProveedor:String = "UPDATE proveedor SET telefono=? WHERE id=?"
}