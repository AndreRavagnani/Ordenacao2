import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class q3 implements Interface {
	public void execute() throws NumberFormatException, IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Digite a Primeira Nota");
		double n1 = Double.parseDouble(in.readLine());
		System.out.println("Digite a Segunda Nota");
		double n2 = Double.parseDouble(in.readLine());
		System.out.println("Digite a Terceira Nota");
		double n3 = Double.parseDouble(in.readLine());
		
		double media = (n1+n2+n3)/3;
		
		double mediaAproveitamento = (n1+(n2*2)+(n3*3)+media)/7;
		
		if(mediaAproveitamento < 6){
			System.out.println("Seu Conceito foi: D");
		}
		else if(mediaAproveitamento >=6 && mediaAproveitamento< 7.5){
			System.out.println("Seu Conceito foi: C");
		}
		else if(mediaAproveitamento >=7.5 && mediaAproveitamento< 9){
			System.out.println("Seu Conceito foi: B");
		}
		else{
			System.out.println("Seu Conceito foi: A");
		}
		
	}

}
