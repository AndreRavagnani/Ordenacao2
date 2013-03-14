import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class q5 implements Interface {
	public void execute() throws NumberFormatException, IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Digite a velocidade permitida");
		double velocidadePermitida = Double.parseDouble(in.readLine());
		System.out.println("Digite a velocidade ultrapassada");
		double velocidadeMaxima = Double.parseDouble(in.readLine());
		
		double velocidadeExcedente = (velocidadeMaxima - velocidadePermitida);
		
		if(velocidadeExcedente<0 ){
			System.out.println("Voce Nao Pagara multa");
		}
		else if(velocidadeExcedente <=10){
			System.out.println("Voce Pagara R$50 em multa");
		}
		
		else if(velocidadeExcedente >= 11 && velocidadeExcedente <= 30){
			System.out.println("Voce Pagara R$100 em multa");
		}
		else {
			System.out.println("Voce Pagara R$200 em multa");
		}
	}
}
