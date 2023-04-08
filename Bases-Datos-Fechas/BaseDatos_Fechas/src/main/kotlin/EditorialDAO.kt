interface  EditorialDAO {
   fun todosLasEditoriales(): List<Editorial>
   fun insertarEditorial(c:Editorial):Int
}