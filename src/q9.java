import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class q9 implements Interface {

	@Override
	public void execute() throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Digite o primeiro numero");
		double primeiro = Double.parseDouble(in.readLine());
		System.out.println("Digite o segundo numero");
		double segundo = Double.parseDouble(in.readLine());
		int opcao;
		System.out.println("Escolha As Seguintes Opcoes");
		System.out.println("1 - Adicao");
		System.out.println("2 - Subtracao");
		System.out.println("3 - Multiplicacao");
		System.out.println("4 - Divisão");
		opcao = Integer.parseInt(in.readLine());
		
		switch(opcao){
		case 1:
			System.out.println("A soma é : " + (primeiro+segundo));
			break;
			
		case 2:
			System.out.println("A subtracao é : " + (primeiro-segundo));
			break;
			
		case 3:
			System.out.println("A Multiplicacao e : " + (primeiro*segundo));
			break;
			
		case 4:
			if (segundo == 0) {
				System.out.println("Impossivel dividir por 0");
			}
			else{
				System.out.println("A divisao é : " +(primeiro/segundo));
			}
			break;
			default:
				System.out.println("Opcao invalida");
		}
		if(primeiro==segundo){
			System.out.println("Os numeros escolhidos sao iguais");
		}
		else if(primeiro>segundo){
			System.out.println("O Maior numero é o " + primeiro);
		}
		else{
			System.out.println("O Maior numero é o :" + segundo);
		}
	}

}
