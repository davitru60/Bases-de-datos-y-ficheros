package Editorial
import ConexionBD

class EditorialDAOImp:EditorialDAO {
    private val conexion = ConexionBD(Constantes.url, Constantes.user, Constantes.password)
    override fun todasLasEditoriales(): ArrayList<Editorial> {
        TODO("Not yet implemented")
    }

    override fun insertarLista(lista: ArrayList<Editorial>): ArrayList<Editorial> {
        TODO("Not yet implemented")
    }
}