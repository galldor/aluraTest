package aluraTest;

import java.util.Scanner;


/**
 * @author      Matheus Martins <matheus.silva.martins@gmail.com>
 * @version     1.0
 * @since       2015-11-27         
 */

public class ClassePrincipal {
	

	
	public static void main(String[] args) {
		
		int estado = 1;
		
		System.out.println(Constantes.MENSAGEM_INICIAL);
		while(estado == 1){
			System.out.println(Constantes.MENSAGEM_OPCOES);
			estado = lerOpcao();
			switch (estado){
				case 1:	
					System.out.println(Constantes.MENSAGEM_OPCAO_DIGITAR_NUMERO_TELEFONE);
					String entradaConvertida = lerEntradaERetornaTelefoneConvertido();
					if( entradaConvertida == null || entradaConvertida.equals("")){
						System.out.println(Constantes.MENSAGEM_NAO_FOI_ENCONTRADO_CARACTERE_VALIDO);
					}else{
						System.out.println("\nResultado: "+entradaConvertida+"\n");
					}
					break;
				case 2:
					System.out.println(Constantes.MENSAGEM_FINAL_PROGRAMA);
					break;
				default:
					System.out.println(Constantes.MENSAGEM_OPCAO_INVALIDA);
					estado = 1;
					break;
			}
		}
		ScannerSingleton.close();
	}	
	
	/**
	 * Metodo que dado uma String com um número de 
	 * telefone que contem também letras, devolve uma 
	 * String com o número de telefone puro, somente números, 
	 * sem letras nem hífens.
	 *
	 * @param  telefone  Telefone com letras para ser convertido
	 * @return String com o telefone convertido
	 */
	public static String limpa(String telefone){
        char caractere;
        int digito;
        telefone = telefone.trim().toUpperCase();
        String telefoneSemLetras = "";
        for(int i=0; i < telefone.length(); i++){
            digito = 0;
            caractere = telefone.charAt(i);
            if (caractere == 'A' || caractere == 'B' || caractere == 'C') {
                digito = 2;  
            }else if (caractere == 'D' || caractere == 'E' || caractere == 'F') {
                digito = 3; 
            }else if (caractere == 'G' || caractere == 'H' || caractere == 'I') {
                digito = 4; 
            }else if (caractere == 'J' || caractere == 'K' || caractere == 'L') { 
                digito = 5; 
            }else if (caractere == 'M' || caractere == 'N' || caractere == 'O') {
                digito = 6;  
            }else if (caractere == 'P' || caractere == 'Q' || caractere == 'R' || caractere == 'S') {
                digito = 7; 
            }else if (caractere == 'T' || caractere == 'U' || caractere == 'V') {
                digito = 8; 
            }else if (caractere == 'W' || caractere == 'X' || caractere == 'Y' || caractere == 'Z') {
                digito = 9; 
            }else if( caractere >= '0' && caractere <= '9' ){
                digito = 1;
            }
            
            if(digito == 1){
                telefoneSemLetras = telefoneSemLetras + caractere;
            }else if(digito != 0){
            	telefoneSemLetras = telefoneSemLetras + digito;
            }
            
        }
        return telefoneSemLetras;
    }
	
	
	/**
	 * Metodo que le a entrada do telefone e aplica a conversao.
	 *
	 * @return String com o telefone convertido
	 */
	
	private static String lerEntradaERetornaTelefoneConvertido(){
		String entradaString = null;
		Scanner keyboardInput = ScannerSingleton.getInstance();
		if (keyboardInput.hasNext()) {
			entradaString = limpa(keyboardInput.next());
	    }
		return entradaString;
	}
	
	
	/**
	 * Metodo que le a opcao escolhida no menu de opcoes;
	 *
	 * @return retorna o inteiro da posicao, se for invalido retorna -1
	 */
	private static int lerOpcao(){
		int opcao = -1;
		Scanner keyboardInput = ScannerSingleton.getInstance();
		if (keyboardInput.hasNextInt()) {
			opcao = keyboardInput.nextInt();
	    }
		return opcao;
	}

}
