package modelo.sentencias

class SentenciasSQL {
    val selectAllProducto:String = "SELECT * FROM producto"
    val insertProduct:String = "INSERT INTO producto VALUES(?,?,?,?,?)"
    val deleteProdForId:String = "DELETE FROM producto WHERE id=?"
    val updateCantProd:String = "UPDATE SET existencias=? WHERE id=?"

}