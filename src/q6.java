import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class q6 implements Interface {
	public void execute() throws NumberFormatException, IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int vetor[]= new int[4];
		for (int i = 1; i <= 4; i++) {
			System.out.println("Digite O " + i + " numero");
			vetor[i-1] = Integer.parseInt(in.readLine());
		}
		int intervalo1 =0, intervalo2 = 0, intervalo3 = 0, intervalo4 =0;
		for (int i = 0; i < vetor.length; i++) {
			if(vetor[i]>=1 && vetor[i]<=25){
				intervalo1++;
			}
			else if(vetor[i]>=26 && vetor[i]<=50){
				intervalo2++;
			
		}
			else if(vetor[i]>=51 && vetor[i]<=75){
				intervalo3++;
			
		}
		
			else if(vetor[i]>=76 && vetor[i]<=100){
				intervalo4++;
			
			}
		}
		System.out.println("Entre os numeros recebidos existem " );
		System.out.println(intervalo1 +" No primeiro Intervalo");
		System.out.println(intervalo2 +" No segundo Intervalo");
		System.out.println(intervalo3 +" No terceiro Intervalo");
		System.out.println(intervalo4 +" No quarto Intervalo");
	}
}
