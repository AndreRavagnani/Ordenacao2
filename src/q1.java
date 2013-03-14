import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public  class q1 implements Interface{
	
		public void execute() throws NumberFormatException, IOException{

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Digite a Temperatura em Celsius");
		double celsius = Double.parseDouble(in.readLine());
		double Fahrenheit = ((celsius*9)+160)/5;
		System.out.println("Temperatura em Fahrenheit e " + Fahrenheit);
	
		}
	

}
