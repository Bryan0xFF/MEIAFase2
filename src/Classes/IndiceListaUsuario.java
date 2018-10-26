/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author ervi
 */
public class IndiceListaUsuario {
    
     int numRegistro;
     String numBloque;
     String nombreLista;
     String usuario;
     String usuarioAsociado;
     int Siguiente;
     String status;
     
     
    public static String padLeft(String str, int length, String padChar) 
    {
        String pad = "";
        for (int i = 0; i < length; i++) 
        {
            pad += padChar;
        }
    return pad.substring(str.length()) + str;
    }
    
    public IndiceListaUsuario()
    {
        this.numRegistro =0;
        this.numBloque ="";
        this.nombreLista ="";
        this.usuario ="";
        this.usuarioAsociado = "";
        this.Siguiente = 0;
        this.status = "";
        
    }

    public IndiceListaUsuario(int registro, String bloque, String lista, String user, String userAsociate, int next, String status)
    {
        this.numRegistro =registro;
        this.numBloque =bloque;
        this.nombreLista =lista;
        this.usuario =user;
        this.usuarioAsociado = userAsociate;
        this.Siguiente = next;
        this.status = status;
    }        
        
        
        public String ConvertirATextoTamañoFijo()
        {
            StringBuilder sb = new StringBuilder();

            sb.append(numRegistro);
            sb.append("|");
            sb.append(numBloque);
            sb.append("|");
            sb.append(nombreLista);
            sb.append("|");
            sb.append(usuario);
            sb.append("|");
            sb.append(usuarioAsociado);
            sb.append("|");
            sb.append(Siguiente);
            sb.append("|");
            sb.append(status);
            return sb.toString();
        }

       

        public String ToString()
        {
            return ConvertirATextoTamañoFijo();
        }
        
    public String[] obtenerUsuarioSplit() throws IOException{
        
        String inicio = IndexSecuencial.ObtenerInicio();
        FileReader fr = new FileReader("C:\\MEIA\\indice_lista_usuario.txt");
        BufferedReader br = new BufferedReader(fr);
        
        List<String> datos = br.lines().collect(Collectors.toList());
        
        String usuario = datos.get(Integer.parseInt(inicio) - 1);
        String[] usuarioEnviar = usuario.split("\\|");
        
        return usuarioEnviar;
    }
}
