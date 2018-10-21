/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Bryan Mejía
 */
public class Lista_Usuario {
    
    String nombre_lista;
    String usuario;
    String usuario_asociado;
    String descripcion;
    String fecha_creacion;
    String status;
    
    public Lista_Usuario(String nombre, String usuario, String Usuario_asociado, String descripcion){
        nombre_lista = nombre;
        this.usuario = usuario;
        this.usuario_asociado = Usuario_asociado;
        this.descripcion = descripcion;
        
         //formateamos la fecha:
      Date date = Calendar.getInstance().getTime();
        
      DateFormat formatter = new SimpleDateFormat("EEEE, dd MMMM yyyy, hh:mm:ss.SSS a");
      String today = formatter.format(date);
      
      this.fecha_creacion = today;
      status = "1";      
    }
    
    private String ToFixedSizeString(String word, int count) {
    String result = ""; 	
    int complement = count - word.length();
      for(int i = 0; i < complement; i++) {
	result += "&";
      }
        return result+word;        
    }
    
    public String setFixedSizeString(){
        
        StringBuilder sb = new StringBuilder();
        
        sb.append(ToFixedSizeString(this.nombre_lista, 30));
        sb.append("|");
        sb.append(ToFixedSizeString(this.usuario, 20));
        sb.append("|");
        sb.append(ToFixedSizeString(this.usuario_asociado, 20));
        sb.append("|");
        sb.append(ToFixedSizeString(this.descripcion,40));
        sb.append("|");
        sb.append(ToFixedSizeString(this.fecha_creacion,38));
        sb.append("|");
        sb.append(ToFixedSizeString(this.status,1));
        
        return sb.toString();
    }
    
    public int getFixedSize(){
        return 154;
    }
    
    public static String toFixedSizeString(String[] array){
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]);
            if (i < (array.length - 1)) {
               sb.append("|");
            }

        }
        
        return sb.toString();
    }
    
    public static String setData(int listaSize, String nombre_lista, String usuario,
            String usuarioAsociado){
        
        StringBuilder sb = new StringBuilder();
        
        sb.append(Integer.toString(listaSize + 1));
        sb.append("|");
        sb.append("1.").append(Integer.toString(listaSize + 1));
        sb.append("|");
        sb.append(nombre_lista);
        sb.append("|");
        sb.append(usuario);
        sb.append("|");
        sb.append(usuarioAsociado);
        sb.append("|");
        sb.append("-1");
        sb.append("|");
        sb.append("1");
        
        
        return sb.toString();  
    }
}
