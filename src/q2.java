import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class q2 implements Interface {
	public void execute() throws NumberFormatException, IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Digite o Numero De Horas");
		int horas = Integer.parseInt(in.readLine());
		System.out.println("Digite o Valor Salario Por Hora");
		double salHr = Double.parseDouble(in.readLine());
		System.out.println("Digite o Valor Salario ");
		double sal = Double.parseDouble(in.readLine());
		
		if(horas>40){
			double excedente = (horas - 40);
			double valorAjuste = salHr+(salHr/2);
			double novoValor = excedente *valorAjuste;
			System.out.println("Voce Receberá "+ (sal+novoValor));
			
		}
		else{
			System.out.println("Voce Receberá "+ sal);
		}
	}
}
