/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package usoGeral;

import java.util.LinkedList;
import model.UsuarioEstacionamento;

/**
 *
 * @author Guilherme
 */
public final class Constantes {
    public static String usuarioAtivo;
    public static final int totalVagas = 9;
    public static final int totalVagasDeficientes = 2;
    public static int numeroVagasOcupadasDeficientes;
    public static int numeroVagasOcupadas;
    public static int idUsuario;
    public static UsuarioEstacionamento usuario;
    public static final String codigoAdm = "121314";
    public static final String senhaAdm = "321";
    public static boolean adminAtivo;
    public static boolean usuarioDeficiente;
    public static final LinkedList<UsuarioEstacionamento> filaEstacionamento = new LinkedList<>();
    
    public static String formatarCodigoVaga(int tamanho, String valor){
        // Formatar o código da vaga => ex: 0102
        return valor.substring(valor.length() - tamanho, valor.length());
    }
}
