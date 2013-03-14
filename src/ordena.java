import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;


public class ordena {

	public static void main(String args[]) throws IOException{
		
		int n = 20;
		int tipo = 1;
		int v[] = new int[n];
		
		String modo =null;
		if(tipo==1){
			modo = " Ordenado Aleatóriamente";
		}
		if(tipo==2){
			modo = "Em Ordem Decrescente";
		}
		if(tipo==3){
			modo = "Em Ordem Crescente";
		}
		
		
		File arquivo = new File("Saida.txt");
		PrintWriter escrita = new PrintWriter( arquivo );
		if(arquivo.exists()){
			arquivo.delete();
			arquivo.createNewFile();
		}
		geraLista (v,tipo);
		int copia[] = v.clone();
		if(n<=100){
			escrita.println("Inserçao: " + n + " Elementos" + modo);
			imprimeLista(copia);
			escrita.print("Antes : [");
			for(int i=0;i<copia.length;i++){
				escrita.print(copia[i]+" ");		
				}
				escrita.println("]");
		long tempo = System.nanoTime();
		insercao(copia);
		System.out.println("Insercao: " + (System.nanoTime() - tempo)/1000000.0 +" ms");
		imprimeLista(copia);
		System.out.println("");
		escrita.println("");
		escrita.print("Depois : [");
		for(int i=0;i<copia.length;i++){
			escrita.print(copia[i]+" ");		
			}
			escrita.println("]");
		
		}
		
		if(n>100 && n<50000){
			imprimeLista(copia);
			long tempo = System.nanoTime();
			insercao(copia);
			System.out.println("Insercao: " + (System.nanoTime() - tempo)/1000000.0 +" ms");
			imprimeLista(copia);
		}
		
		copia=v.clone();
		imprimeLista(copia);
		long tempo = System.nanoTime();
		mergeSort(copia,0,n-1);
		System.out.println("MergeSort: " + (System.nanoTime() - tempo)/1000000.0 +" ms");
		imprimeLista(copia);
		System.out.println("");
		copia=v.clone();
		System.out.println("");
		imprimeLista(copia);
		 tempo = System.nanoTime();
		SelectionSort(copia);
		System.out.println("Selecao: " + (System.nanoTime() - tempo)/1000000.0 +" ms");
		imprimeLista(copia);
		
		System.out.println("");
		copia=v.clone();
		System.out.print("Lista Original: ");imprimeLista(copia);
		 tempo = System.nanoTime();
		ShellSort(copia);
		System.out.println("ShellSort: " + (System.nanoTime() - tempo)/1000000.0 +" ms");
		imprimeLista(copia);
		
		System.out.println("");
		copia=v.clone();
		System.out.print("Lista Original: ");imprimeLista(copia);
		 tempo = System.nanoTime();
		QuickSort(copia,0,copia.length-1);
		System.out.println("QuickSort: " + (System.nanoTime() - tempo)/1000000.0 +" ms");
		imprimeLista(copia);
		
		System.out.println("");
		copia=v.clone();
		System.out.print("Lista Original: ");imprimeLista(copia);
		 tempo = System.nanoTime();
		QuickSort(copia,0,copia.length-1);
		System.out.println("QuickSortProbabilistic: " + (System.nanoTime() - tempo)/1000000.0 +" ms");
		imprimeLista(copia);
		

		System.out.println("");
		copia=v.clone();
		System.out.print("Lista Original: ");imprimeLista(copia);
		 tempo = System.nanoTime();
		CocktailSort(copia);
		System.out.println("CocktailSort: " + (System.nanoTime() - tempo)/1000000.0 +" ms");
		imprimeLista(copia);
		escrita.close();
		
		
		
		}
	
		static void geraLista(int l[], int tipo){
			
			switch(tipo) {
			case 1:
				
				Random r = new Random();
				for(int i=0;i<l.length;i++){
				l[i]=Math.abs(r.nextInt()%(10*l.length));
				
				}
		      
			break;
			
			case 2:

				int j = 0;
				for (int i = l.length  ; i > 0; i--) {
					l[j]=i;
					j++;
				}
			break;
			
			case 3:

				for (int i = 0; i < l.length; i++) {
					l[i]=i;
					
				}
			break;
			}
			
			
		}

		static void imprimeLista(int l[]){
			for(int i=0;i<l.length;i++){
			System.out.print(l[i]+" ");		
			}
			System.out.println("");
		}
		
		static void insercao(int l[]){

			for(int i=1; i<l.length;i++){
			int pivo = l[i];
			int j = i-1;
				while(j>=0 && l[j] > pivo){
				l[j+1] = l[j]; 
				j--;
				}
				l[j+1]=pivo;
			}
		}

		 static void mergeSort(int[] vetor, int inicio, int fim)
	    {
	        if (inicio < fim)
	        {
	            int meio = (int)Math.floor((inicio + fim) / 2d);
	            if (inicio < meio)
	                mergeSort(vetor, inicio, meio);
	            if (meio + 1 < fim)
	                mergeSort(vetor, meio + 1, fim);

	            merge(vetor, inicio, meio, fim);
	        }
	    }
		
		 static void merge(int[] vetor, int inicio, int meio, int fim)
	    {
	        int i = inicio, j = meio + 1, k = 0;
	        int vetorAux[] = new int[fim - inicio];
	        
	        while (i <= meio && j <= fim)
	        {
	            if (vetor[i] <= vetor[j])
	            {
	                vetorAux[k] = vetor[i];
	                i++;
	            }
	            else
	            {
	                vetorAux[k] = vetor[j];
	                j++;
	            }
	            k++;
	        }
	        if (i <= meio)
	        {
	            for (j = meio; j >= i; j--)
	                vetor[fim - meio + j] = vetor[j];
	        }
	        for (i = 0; i < k; i++)
	            vetor[inicio + i] = vetorAux[i];
	    }
		
		 static void SelectionSort(int[] v) {
			   int min;
			   int aux;
			 
			   for (int i = 0; i < v.length; i++) {
			       min = i;
			       for (int j = i + 1; j < v.length; j++) {
			          if (v[j] < v[min]) {
			             min = j;
			          }
			       }
			       if (min != i) {
			         aux = v[min];
			         v[min] = v[i];
			         v[i] = aux;
			       }
			   }
			}
		  static void ShellSort ( int [ ] vetor )  
	      {    
	         int i , j , h = 1, pivo ;  
	          
	         do {  
	            h = 3 * h + 1;  
	         } while ( h < vetor.length );  
	         do {  
	            h = h / 3;  
	            for ( i = h; i < vetor.length; i++) {  
	               pivo = vetor [ i ];  
	               j = i - h;  
	               while (j >= 0 && pivo < vetor [ j ]) {  
	                  vetor [ j + h ] = vetor [ j ];  
	                  j = j - h;  
	               }  
	               vetor [ j + h ] = pivo;  
	            }  
	      } while ( h > 1 ); 
	         
	      }
		  
		   static void QuickSort(int []v,int ini, int fim) {
              int meio;

              if (ini < fim) {
                      meio = partition(v, ini, fim);
                      if(ini<meio-1){
                     QuickSort(v, ini, meio);
                      }
                      if(meio+1<fim){
                     QuickSort(v, meio + 1, fim);
                      }
              }
      }

      public static int partition(int []v, int ini, int fim) {
              int pivo, topo, i;
              pivo = v[ini];
              topo = ini;

              for (i = ini + 1; i <= fim; i++) {
                      if (v[i] < pivo) {
                              v[topo] = v[i];
                              v[i] = v[topo + 1];
                              topo++; 
                      }
              }
              v[topo] = pivo;
              return topo;
      }
      
      static void QuickSortProbabilistic(int []v,int ini, int fim) {
          int meio;

          if (ini < fim) {
                  meio = partition2(v, ini, fim);
                  if(ini<meio-1){
                 QuickSort(v, ini, meio);
                  }
                  if(meio+1<fim){
                 QuickSort(v, meio + 1, fim);
                  }
          }
  }
      public static int partition2(int []v, int ini, int fim) {
          int pivo = 0, topo, i, media = 0;
          for (int j = 0; j < v.length; j++) {
			 media = pivo +v[j];
		}
          pivo = media/v.length;
          topo = ini;

          for (i = ini + 1; i <= fim; i++) {
                  if (v[i] < pivo) {
                          v[topo] = v[i];
                          v[i] = v[topo + 1];
                          topo++; 
                  }
          }
          v[topo] = pivo;
          return topo;
  }
      
      static void CocktailSort(int[] vetor)
      {
          int tamanho, inicio, fim, swap, aux;
          tamanho = 20; // para um vetor de 20 elementos
          inicio = 0;
          fim = tamanho - 1;
          swap = 0;
          while (swap == 0 && inicio < fim)
          {
              swap = 1;
              for (int i = inicio; i < fim; i = i + 1)
              {
                  if (vetor[i] > vetor[i + 1])
                  {
                      aux = vetor[i];
                      vetor[i] = vetor[i + 1];
                      vetor[i + 1] = aux;
                      swap = 0;
                  }
              }
              fim = fim - 1;
              for (int i = fim; i > inicio; i = i - 1)
              {
                  if (vetor[i] < vetor[i - 1])
                  {
                      aux = vetor[i];
                      vetor[i] = vetor[i - 1];
                      vetor[i - 1] = aux;
                      swap = 0;
                  }
              }
              inicio = inicio + 1;
          }
      }
}
