import java.io.*;
import java.util.ArrayList;

public class pruebaArchivos {

    private ArrayList<String> contenidoArchivo = new ArrayList<>();
    private ArrayList<ReciboLuz> listaEntrada = new ArrayList<>();
    private final String rutaWindows = "C:\\Users\\Leonel\\Escritorio\\Cosasdelaescuela\\POO\\practica6\\datos\\datos.txt";
    private final String rutaLinux = "/Users/l3onet/IdeaProjects/HolaMundo/src/Archivos/datos.txt";

    public ArrayList<String> getContenidoArchivo() {
        return contenidoArchivo;
    }

    public ArrayList<ReciboLuz> getListaEntrada() {
        return listaEntrada;
    }

    public void leerArchivo(){
        LeerArchivo leer = new LeerArchivo();
        this.contenidoArchivo =
                leer.leerArchivo(this.rutaLinux);
        for (int i=0; i < this.contenidoArchivo.size();i++){
            String linea = this.contenidoArchivo.get(i);
            String elementosLinea[] = linea.split("#");
            try {
                double costoKw = Double.parseDouble(elementosLinea[2]);
                int lecturaActual = Integer.parseInt(elementosLinea[0]);
                int lecturaAnterior = Integer.parseInt(elementosLinea[1]);
                listaEntrada.add(new ReciboLuz(costoKw, lecturaAnterior, lecturaActual));
            } catch (NumberFormatException ex){
                ex.printStackTrace();
                listaEntrada.add(new ReciboLuz(0.0, 0, 0));
            }
        }
    }

    public void escribirArchivo(ArrayList<ReciboLuz> lista){
        String archivo = "resultados.csv";
        File f = new File(archivo);
        //Escritura
        try{
            FileWriter w = new FileWriter(f);
            BufferedWriter bw = new BufferedWriter(w);
            PrintWriter wr = new PrintWriter(bw);
            wr.write("");
            wr.append("Lectura actual,Lectura anterior,Costo KW, Total a pagar\n");
            for (int i=0; i < lista.size(); i++){
                wr.append(lista.get(i).getLecturaActual() +
                        "," + lista.get(i).getLecturaAnterior() +
                        "," + lista.get(i).getCostoKw() + "," +
                        lista.get(i).getTotalAPagar() + "\n");
            }
            wr.close();
            bw.close();
        }catch(IOException e){

        }
    }

    public static void main (String args[]){
        pruebaArchivos prueba = new pruebaArchivos();
        prueba.leerArchivo();
        for (int i=0; i < prueba.getListaEntrada().size(); i++){
            System.out.println(prueba.getListaEntrada().get(i).getLecturaActual() +
                    "\t" + prueba.getListaEntrada().get(i).getLecturaAnterior() +
            "\t" + prueba.getListaEntrada().get(i).getCostoKw() + "\t" +
                    prueba.getListaEntrada().get(i).getTotalAPagar());
        }
        prueba.escribirArchivo(prueba.getListaEntrada());

    }
}
