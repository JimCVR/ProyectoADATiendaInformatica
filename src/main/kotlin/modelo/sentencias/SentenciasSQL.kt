package modelo.sentencias

object SentenciasSQL {

    //Sentencias productos
    val selectAllProducto:String = "SELECT * FROM producto"
    val insertProduct:String = "INSERT INTO producto VALUES(?,?,?,?,?)"
    val updateCantProd:String = "UPDATE producto SET existencias=? WHERE id=?"
    val updatePriceProd:String = "UPDATE producto SET precio=? WHERE id=?"
    val deleteProductoId:String = "DELETE FROM producto WHERE id=?"
    val deleteProductoTipo:String = "DELETE FROM producto WHERE tipo=?"

    //Sentencias Proveedores
    val updateDirProveedor:String = "UPDATE proveedor SET direccion=? WHERE id=?"
    val updateTelProveedor:String = "UPDATE proveedor SET telefono=? WHERE id=?"
    val deleteProveedorId:String = "DELETE FROM proveedor WHERE id=?"
    val deleteProveedorNombre:String = "DELETE FROM proveedor WHERE nombre=?"


}