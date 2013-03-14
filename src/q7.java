import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class q7 implements Interface {
	public void execute() throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Digite a quantidade de familias a pesquisar");
		int familias = Integer.parseInt(in.readLine());
		double salario[] = new double[familias];
		int filhos[] = new int[familias];
		for (int i = 0; i < familias; i++) {
			System.out.println("Digite o salario da "+ (i+1)+ " familia");
			salario[i]= Double.parseDouble(in.readLine());
			System.out.println("Digite a Qnt de Filhos da "+ (i+1)+ " familia");
			filhos[i]=Integer.parseInt(in.readLine());
		}
		double somaSal=0;
		double maiorSal =salario[0];
		int porcSalBaixo =0;
		for (int i = 0; i < salario.length; i++) {
			somaSal = somaSal+salario[i];
			while(maiorSal<salario[i]){
				maiorSal=salario[i];
			}
			if(salario[i]<150){
				porcSalBaixo++;
			}
		}
		int qntFilhos =0;
		for (int i = 0; i < filhos.length; i++) {
			qntFilhos = qntFilhos+filhos[i];
		}
		
		System.out.println("Media De Filhos: " + qntFilhos/familias);
		System.out.println("Porcentagem Salario Abaixo De R$150 -  " + (porcSalBaixo*100)/familias + " %" );
		System.out.println("Maior Salario e: " +maiorSal);
	}
}
