package Editorial

interface EditorialDAO {
    fun todasLasEditoriales():ArrayList<Editorial>
    fun insertarLista(lista:ArrayList<Editorial>):ArrayList<Editorial>
}