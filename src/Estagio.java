import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Estagio {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Digite A Questao desejada entre 1 e 10");
		int questao = Integer.parseInt(in.readLine());
		boolean controle = false;
		Interface x = null;
		do{
		switch(questao){
		case 1:
			x = new q1();
			controle = true;
			break;
		
		case 2:
			x = new q2();
			controle = true;
			break;
		
		case 3:
		    x = new q3();
		    controle = true;
		    break;
			
		case 4:
			x = new q4();
			controle = true;
			break;
			
		case 5:
			
			x = new q5();
			controle = true;
			break;
			
		case 6:
			x = new q6();
			controle = true;
			break;
			
			
		case 7:
			x = new q7();
			controle = true;
			break;
			
		case 8:
			x = new q8();
			controle = true;
			break;
			
		case 9:
			x = new q9();
			controle = true;
			break;
			
		case 10:
			x = new q10();
			controle = true;
			break;
			
		default:
			System.out.println("Questao Invalida Escolhe outra Questao ");
		
			questao = Integer.parseInt(in.readLine());
			
		}
		
		 
		}while(controle == false);
		
	
		x.execute();
		
		
		
	}
		
	
}
