/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.io.IOException;
import java.util.Date;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Bryan Mejía
 */
public class Lista {
    
    String nombre_lista;
    String usuario;
    String descripcion;
    String numero_usuarios;
    String fecha_creacion;
    String status;
    
    //llave primaria compuesta por Nombre_lista y usuario
    
    
    
    public Lista(String nombre_lista, Usuario usuario, String descripcion) throws Exception{
        
        this.nombre_lista = nombre_lista;
        this.usuario = usuario.getUsuario();
        this.descripcion = descripcion;
        //campos default
        this.numero_usuarios = "0";
        this.status = "1";
        
       //formateamos la fecha:
      Date date = Calendar.getInstance().getTime();
        
      DateFormat formatter = new SimpleDateFormat("EEEE, dd MMMM yyyy, hh:mm:ss.SSS a");
      String today = formatter.format(date);
      
      this.fecha_creacion = today;
      
      
      Escribir("lista", setFixedSize(),usuario.getUsuario());
    }
    
    private String ToFixedSizeString(String word, int count) {
    String result = ""; 	
    int complement = count - word.length();
      for(int i = 0; i < complement; i++) {
	result += "&";
      }
        return result+word;        
    }
    
    public String setFixedSize(){
        
        StringBuilder sb = new StringBuilder();
        
        sb.append(ToFixedSizeString(this.nombre_lista, 30));
        sb.append("|");
        sb.append(ToFixedSizeString(this.usuario, 20));
        sb.append("|");
        sb.append(ToFixedSizeString(this.descripcion, 40));
        sb.append("|");
        sb.append(ToFixedSizeString(this.numero_usuarios,4));
        sb.append("|");
        sb.append(ToFixedSizeString(this.fecha_creacion,38));
        sb.append("|");
        sb.append(ToFixedSizeString(this.status,1));
        
        return sb.toString();
    }
    
    public int getSize(){
        
        return 138;
    }
    /**
     * dato normalizado
     * @param nombreMaster 
     */
    public void Escribir(String nombreMaster, String datoIngresar, String nombreAdmin) throws IOException, Exception{
        //busca si existe un usuario con este nombre
        try{
            boolean flag = true;
            String path = "C:\\MEIA\\bitacora_" + nombreMaster + ".txt"; 
            FileReader fr = new FileReader(path);
            BufferedReader br = new BufferedReader(fr);
            
            List<String> datos = br.lines().collect(Collectors.toList());
            String[] ingreso = datoIngresar.trim().split("\\|");
            
            for (int i = 0; i < datos.size(); i++) {
                
                String[] datosSplit = datos.get(i).trim().split("\\|");
                if (datosSplit[0].equals(ingreso[0]) && datosSplit[1].equals(ingreso[1])) {
                    throw new Exception("ya existe la lista");
                }
            }
            
            Secuencial.Escribir(datoIngresar,"lista",nombreAdmin);
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
    
}
