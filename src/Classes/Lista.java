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
    
    public Lista(String nombre_lista, Usuario usuario, String descripcion){
        
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
      
      
      Escribir(this);
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
    
    private void Escribir(Lista escribir){
        //busca si existe un usuario con este nombre
        try{
            
        Usuario temp = new Usuario();
        temp.fromFixedSizeString(
                Secuencial.Buscar(escribir.usuario, "lista"));
        
        
        if (!escribir.usuario.equals(temp.getUsuario())) {
            //el usuario no existe
            Secuencial.Escribir(status, "lista", this.usuario);
            
        }else{
            
            //el usuario existe y sobreescribe
            int usuarios = Integer.parseInt(this.numero_usuarios);
            usuarios = usuarios + 1;
            this.numero_usuarios = Integer.toString(usuarios);
            Secuencial.Sobreescribir(setFixedSize(),"lista", this.usuario,
                    getSize());
            
        }
        
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
    
}
