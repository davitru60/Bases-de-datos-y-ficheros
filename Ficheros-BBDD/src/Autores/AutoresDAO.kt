package Autores

import Autores.Autores

interface AutoresDAO {
   fun todosLosAutores(): List<Autores>
   fun insertarLista(c:ArrayList<Autores>):ArrayList<Autores>
}