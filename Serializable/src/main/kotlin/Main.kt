import java.io.*

fun main(args: Array<String>) {
    var a1 = Agenda("Ana", "Martínez", "Fernández");
    var a2 = Agenda("Ernesto", "García", "Pérez");
    var os:ObjectOutputStream?=null
    try{
        var fs = FileOutputStream("Serializable\\agenda.ser");//Creamos el archivo
        os = ObjectOutputStream(fs);//Esta clase tiene el método writeObject() que necesitamos
        os.writeObject(a1);//El método writeObject() serializa el objeto y lo escribe en el archivo
        os.writeObject(a2);
    }catch(e: FileNotFoundException){
        e.printStackTrace();
    }catch(e: IOException){
        e.printStackTrace();
    } finally {
        os?.close();//Hay que cerrar siempre el archivo
    }
    try{
        var fis = FileInputStream("Serializable\\agenda.ser");
        var ois = ObjectInputStream(fis);

        var a1 = ois.readObject();//El método readObject() recupera el objeto
        var a2 = ois.readObject();
        ois.close();
    }catch(e: FileNotFoundException){
        e.printStackTrace();
    }catch(e: IOException){
        e.printStackTrace();
    }catch(e:ClassNotFoundException){
        e.printStackTrace();
    }
    System.out.println(a1);
    System.out.println(a2);
}

