import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class q4 implements Interface {
	public void execute() throws NumberFormatException, IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Digite o seu codigo");
		double codigo = Double.parseDouble(in.readLine());
		System.out.println("Digite o seu Ano de Nascimento");
		int anoNasc = Integer.parseInt(in.readLine());
		System.out.println("Digite o seu Ano de Entreda Na Empresa");
		int anoEmpresa = Integer.parseInt(in.readLine());
		
		int idade = (2013-anoNasc);
		int tempoServ = (2013-anoEmpresa);
		
		System.out.println("Sua Idade é : " + idade);

		System.out.println("Seu Tempo de Servico é : " + tempoServ);
		if(idade>=65){
			System.out.println("REQUERER APOSENTADORIA");
		}
		else if(tempoServ>=30){
			System.out.println("REQUERER APOSENTADORIA");
		}
		else if(idade<60 && tempoServ >25){
			System.out.println("REQUERER APOSENTADORIA");
		}
		else {
			System.out.println("NAO REQUERER APOSENTADORIA");
		}
	}
}
