import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class q10 implements Interface {

	@Override
	public void execute() throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		double notas[] = new double[3];
		System.out.println("Digite o primeira nota");
		notas[0] = Double.parseDouble(in.readLine());
		System.out.println("Digite o segunda nota");
		notas[1] = Double.parseDouble(in.readLine());
		System.out.println("Digite o terceira nota");
		notas[2] = Double.parseDouble(in.readLine());
		double  menor =0;
		for (int i = 0; i < notas.length-1; i++) {
			if(notas[i]<=notas[i+1]){
				menor = notas[i];
			}
		}
		int j=0, k=0;
		double media = geraMedia(notas);
		
		double mediaFinal =0;
		
		if(media>=7){
			System.out.println("Aprovado Por Media");
		}
		
		
		else if(media<7){
			
			for ( int i = 0; i < notas.length; i++) {
				if(menor>notas[i]){
					 j=i;
				}
							
			}
			System.out.println("Voce tem direito a quarta prova, digita a nova nota");
			notas[j] = Double.parseDouble(in.readLine());
			 media = geraMedia(notas);
		}
		 if(media>=7){
			System.out.println("Aprovado Na Reposicao");
		}
		 for (int i = 0; i < notas.length-1; i++) {
				if(notas[i]<notas[i+1]){
					menor = notas[i];
				}
			}
		 if(media<7){
			
			
			for (int i = 0; i < notas.length; i++) {
				if(menor<=notas[i]){
					 k=i;
				}
				
			}
			System.out.println("Voce tem direito a quinta prova, digita a nova nota");
			notas[k] = Double.parseDouble(in.readLine());
			 media = geraMedia(notas);
			  mediaFinal  = notas[k]+notas[j]+media;
		}
		
		 if(media>=7 && mediaFinal >=12){
				System.out.println("Aprovado Na Final");
			}
		 else{
			System.out.println("REPROVADO");
		}
		}
	
	
	double geraMedia(double notas[]){
		double total=0;
	for (int i = 0; i < notas.length; i++) {
		 total = total+notas[i];
	}
		
		double media = (total/notas.length);
		return media;
		}
	

}
