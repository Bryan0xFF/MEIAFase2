/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.io.*;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Bryan Mejía
 */
public class SecIndizado {
    
    Secuencial secuencial;
    
    /**
     * Crea los archivos default del secuencial indexado deseado
     * @param nombreMaster
     * @return
     * @throws IOException 
     */
    public boolean CrearIndexado(String nombreMaster,
            String nombreUsuarioMaster)throws IOException{
        
        CrearIndice(nombreMaster, nombreUsuarioMaster);
        CrearDescIndice(nombreMaster);
        CrearDescMasterIndizado(nombreMaster, nombreUsuarioMaster);
        CrearMasterIndizado(nombreMaster);
        return false;
    }
    
    public SecIndizado(String nombreMaster, String nombreUsuarioMaster){
        
        try{
            
            CrearIndexado(nombreMaster, nombreUsuarioMaster);
            
        }catch (Exception e){
            
            e.printStackTrace();
        }
        
    }
    
    
    
    public boolean CrearIndice(String nombreMaster, String UsuarioAdmin)throws IOException{
        File file = new File("C:\\MEIA\\indice_" + nombreMaster +".txt");
        boolean flag = file.createNewFile();
           
        return flag;
        
        //TODO: crear datos basicos que van dentro del archivo
        //ALT+6 abrir action item
    }
    
    public boolean CrearDescIndice(String nombreMaster) throws IOException{
        
        File file = new File("C:\\MEIA\\desc_Indice_" + nombreMaster +".txt");
        boolean flag = file.createNewFile();
        FileWriter fw = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(fw);
        
        bw.write("Num_reg: " + "0");
        bw.write("\r\n");
        bw.write("Reg_inicio: " + "0");
        bw.write("\r\n");
        bw.write("reg_activos: "+"0");
        bw.write("\r\n");
        bw.write("Reg_inact: " + "0");
        
        bw.flush();
        bw.close();
        return flag;
    }
    
    public boolean CrearDescMasterIndizado(String nombreMaster, String nombreAdminMaster) throws IOException{
        
        File file = new File("C:\\MEIA\\desc_" + nombreMaster +".txt");
        boolean flag = file.createNewFile();
        FileWriter fw = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(fw);
        
        bw.append("Usuario_Creacion: " + nombreAdminMaster);
        bw.append("\r\n");
        
        Date date = Calendar.getInstance().getTime();
        
        DateFormat formatter = new SimpleDateFormat("EEEE, dd MMMM yyyy, hh:mm:ss.SSS a");
        String today = formatter.format(date);
        
        bw.append("Fecha_Creacion: " + today);
        bw.append("\r\n");
        bw.append("Num_Reg: " + "0");
        bw.append("\r\n");
        bw.append("Reg_Activos: " + "0");
        bw.append("\r\n");
        bw.append("Reg_Inactivos: " + "0");
        
        bw.flush();
        bw.close();
        
        return true;
    }
    
    public boolean CrearMasterIndizado(String nombreMaster)throws IOException{
        
        File file = new File("C:\\MEIA\\" + nombreMaster + ".txt");
        boolean flag = file.createNewFile();
        return true;
    }
    
    public static boolean EscribirIndizado(String nombreMaster, String nombreLista,
            String usuario, String usuarioAsociado) throws IOException{
        //TODO: Escribir al archivo modificando apuntadores, registros y desc. de ser necesario
        
        //se abre un buffer hacia el master
        File file = new File("C:\\MEIA\\" + nombreMaster + ".txt");
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        
        //lee y cierra las instancias de master
        List<String> datos = br.lines().collect(Collectors.toList());
        br.close();
        
        //setea el numero de reg, posicion, y los nombres; no setea el siguiente
        String defaultData = Lista_Usuario.setData(datos.size(), nombreLista, usuario, usuarioAsociado);
        
        
        return true;
    }
    
    private static List<String> datosOrdenados(String datoInsertar, List<String> datos,String nombreMaster) throws IOException{
        
        //se abre un buffer hacia el desc_indice para saber donde comenzar a leer
        String pathIndice = "C:\\MEIA\\desc_indice_" + nombreMaster + ".txt";
        FileReader fr = new FileReader(pathIndice);
        BufferedReader br = new BufferedReader(fr);
        
        List<String> datosDescIndice = br.lines().collect(Collectors.toList());
        String[] RegInicio = datosDescIndice.get(1).trim().split(":");
        br.close();
        
        //no se ha ingresado ningun dato a la tabla
        if (RegInicio[1].equals("0")) {
            //escribir como viene
            File file = new File("C:\\MEIA\\indice_" + nombreMaster + ".txt");
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(datoInsertar);
            bw.close();
            
            //se abre buffer para modificar desc_indice
            file = new File(pathIndice);
            fw = new FileWriter(file);
            bw = new BufferedWriter(fw);
            String[] numeroDescIndice = new String[datosDescIndice.size() -1];
            
            //setea los datos de desc_indice
            for (int i = 0; i < datosDescIndice.size(); i++) {
                String num = datosDescIndice.get(i).trim().split(":")[1];
                numeroDescIndice[i] = num;
            }
            
            numeroDescIndice[0] = "1";
            numeroDescIndice[1] = "1";
            numeroDescIndice[2] = "1";
            numeroDescIndice[3] = "0";
            
            bw.write("Num_reg: " + "1");
            bw.write("\r\n");
            bw.write("Reg_inicio: " + "1");
            bw.write("\r\n");
            bw.write("reg_activos: "+"1");
            bw.write("\r\n");
            bw.write("Reg_inact: " + "0");
            
            bw.flush();
            bw.close();
            
            
        }else{
            //ya se ha ingresado datos
            
            
        }
        
        
        return null;
    }
    
    private List<String> SortToIndex(List<String> datos, String datoInsertar, String nombreMaster) throws IOException, Exception{
        
        //TODO: insertar en la ultima o en la primera posicion
        int count = 0;
        String pathDescIndice = "C:\\MEIA\\desc_indice_" + nombreMaster + ".txt";
        String pathDesc = "C:\\MEIA\\indice_" + nombreMaster + ".txt";
        FileReader fr = new FileReader(pathDescIndice);
        BufferedReader br = new BufferedReader(fr);
        
        List<String> datosIndice = br.lines().collect(Collectors.toList());
        String reg_init = datosIndice.get(1).trim().split(":")[1];
        
        //asigna su respectiva posicion e inserta al final de la lista
        //5 es sig
        //2 es el nombre_lista
        //3 es Usuario
        //4 es usuario_as
        //datoLista equivale a datoSiguiente en logica de insercion
        String[] datoAInsertar = datoInsertar.split("\\|");
        //obtiene el dato inicial
        String[] datoLista = datos.get((Integer.parseInt(reg_init) - 1)).split("\\|");
        String[] datoAnterior = null;
        
        boolean flag = false;
        
        //cambiar condicion del while
        while(flag == false){
            
            //si nom_lista del dato a insertar es igual al dato comparado
            if (datoAInsertar[2].compareTo(datoLista[2]) == 0) {
                
                if (datoAInsertar[3].compareTo(datoLista[3]) == 0) {
                    
                    if (datoAInsertar[4].compareTo(datoLista[4]) == 0) {
                    
                        throw new Exception("datos iguales");
                        
                    //si usuario_as es mayor a dato de la lista    
                    }if(datoAInsertar[4].compareTo(datoLista[4]) == 1){
                        
                        int sig = Integer.parseInt(datoLista[5]);
                        
                        if (sig == -1) {
                        //insertar de ultimo
                        }else{
                            //se toma el dato
                            datoAnterior = datoLista;
                            datoLista = datos.get((sig - 1)).split("\\|");
                            flag = false;
                        }
                        
                     //el dato a insertar el menor   
                    }else{
                        
                        //actualiza apuntadores
                        datoAInsertar[5] = datoLista[0];
                        datoAnterior[5] = datoAInsertar[0];
                        datos = SobreescribirALista(datos,datoAInsertar,datoLista,datoAnterior,Integer.parseInt(reg_init));
                        flag = true;
                        
                    }
                //si usuario es mayor al dato de la lista    
                }if (datoAInsertar[3].compareTo(datoLista[3]) == 1){
                    
                    int sig = Integer.parseInt(datoLista[5]);
                        
                        if (sig == -1) {
                        //insertar de ultimo
                        }else{
                            //se toma el dato
                            datoAnterior = datoLista;
                            datoLista = datos.get((sig - 1)).split("\\|");
                            flag = false;
                        }
                 
                //el dato a insertar es menor    
                }else{
                    
                    //actualiza apuntadores
                    datoAInsertar[5] = datoLista[0];
                    datoAnterior[5] = datoAInsertar[0];
                    //setear el dato a string
                    datos = SobreescribirALista(datos,datoAInsertar,datoLista,datoAnterior,Integer.parseInt(reg_init));
                    flag = true;
                }
                
             //si nom_lista del dato a insertar es mayor al dato comparado   
            }if(datoAInsertar[2].compareTo(datoLista[2]) == 1){
            
                int sig = Integer.parseInt(datoLista[5]);
                        
                        if (sig == -1) {
                        //insertar de ultimo
                        }else{
                            //se toma el dato
                            datoAnterior = datoLista;
                            datoLista = datos.get((sig - 1)).split("\\|");
                            flag = false;
                        }
                
            //el dato es menor. insertar    
            }else{
                //actualiza apuntadores
                datoAInsertar[5] = datoLista[0];
                datoAnterior[5] = datoAInsertar[0];
                datos = SobreescribirALista(datos,datoAInsertar,datoLista,datoAnterior,Integer.parseInt(reg_init));
                flag = true;
            }
            
        }
        
        return datos;
    }
    
    private List<String> SobreescribirALista(List<String> datos,String[]datoInsertar, String[] datoSiguiente, String[] datoAnterior, int reg_inicio){
        
        
        String[] datoActual = datos.get((reg_inicio - 1)).split("\\|");
    
        boolean flag = false;
        
        while(flag == false){
            //primero verificamos el dato anterior
            
            if (datoActual[2].compareTo(datoAnterior[2]) == 0) {
                
                if (datoActual[3].compareTo(datoAnterior[3]) == 0) {
                    
                    if (datoActual[4].compareTo(datoAnterior[4]) == 0) {
                        
                        //es el dato buscado
                        int insertar = Integer.parseInt(datoActual[5]);
                        String dato = Lista_Usuario.toFixedSizeString(datoAnterior);
                        datos.set((insertar - 1), dato);
                        
                        //setea el siguiente
                        int siguiente = Integer.parseInt(datoInsertar[5]);
                        dato = Lista_Usuario.toFixedSizeString(datoSiguiente);
                        datos.set((siguiente - 1), dato);
                        
                        flag = true;
                    }
                    
                }
                
            }
            
        }
        
        return datos;
    }
    
    
}
