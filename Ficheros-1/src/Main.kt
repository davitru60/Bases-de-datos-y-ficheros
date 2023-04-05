import java.io.File
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import java.nio.file.StandardCopyOption


fun main(args: Array<String>) {
    //creación de un fichero
    //tenemos que tener en cuenta que tengamos permisos en el sistema operativo para escribir
    val ruta = Paths.get("newfile.txt")
    // La siguiente instrucción seguramente producira un error de permisos de escritura
    // val ruta = Paths.get("c:/newfile.txt")
    Files.createFile(ruta)

    //metodos de Path
    var path = Paths.get("newfile.txt");
    //Devuelve la ruta completa del fichero
    println( path.toString())
    //Devuelve el nombre del fichero
    println( path.getFileName())

    //comprobar que existe un fichero
    val sFichero = "newfile.txt";

    var f = File(sFichero);
    if (f.exists()){
        System.out.println("El fichero existe");
    } else {
        System.out.println("El fichero no existe");
    }

    //borrar un fichero
   // var target = Paths.get("newfile.txt")
   // Files.delete(target) //Si el fichero no existe se produce una excepción
   // Files.deleteIfExists(target) //Si el fichero no existe no pasa nada

    //copiar y mover
    var source: Path = Paths.get("newfile.txt")
    var target= Paths.get("./Ejemplo/targetFile.txt")

    // Copiar archivo
    Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING)

    // Mover archivo
    Files.move(source, target, StandardCopyOption.REPLACE_EXISTING)

    /*
    La clase Path es una clase que representa una ruta en el sistema de archivos.
    Proporciona métodos para manipular y examinar la ruta,
    y es utilizado por las clases que operan en el sistema de archivos,
    como Files. En resumen, Path representa una ruta de archivo.

     Paths es una clase de utilidad que proporciona métodos para crear instancias de la clase Path.
     Se utiliza para obtener una instancia de Path para una ruta específica en el sistema de archivos
     y proporciona formas convenientes de crear rutas relativas o absolutas.
     En resumen, Paths es una clase de utilidad para crear instancias de Path.
     */
}