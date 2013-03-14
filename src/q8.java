import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class q8 implements Interface {

	@Override
	public void execute() throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Digite a Quantidade De Dias");
		int dias = Integer.parseInt(in.readLine());
		int vetor[] = new int[dias];
		int maior=0, media=0, total=0;
		
		for (int i = 0; i < vetor.length; i++) {
			System.out.println("Digite a Temperatura do Dia" +(i+1));
			vetor[i]= Integer.parseInt(in.readLine());
		}
		int menor = vetor[0];
		for (int i = 0; i < vetor.length; i++) {
			if(vetor[i]<=menor){
				menor = vetor[i];
			}
			if(vetor[i]>=maior){
				maior = vetor[i];
			}
		}
		
		for (int i = 0; i < vetor.length; i++) {
				total = total+ vetor[i];
			}
		media = total/dias;
		int abaixo =0;
		for (int i = 0; i < vetor.length; i++) {
			if(media<vetor[i]){
				abaixo++;
			}
		}
		System.out.println("A Menor Temperatura e: " + menor);
		System.out.println("A Maior Temperatura e : " + maior);
		System.out.println("A Temperatura Media e : " + media);
		System.out.println("Dias Abaixo da Media e :" + abaixo);
		}
	
	

}
