import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

/**
 * Algoritmo para ordenação de vetores
 * 
 * 
 * @author's André Ravagnani, Thiago César e João Paulo
 * 
 */

public class ordena {
	static int compMerge = 0;
	static int trocaMerge = 0;
	static int compQuick = 0;
	static int trocaQuick = 0;
	static int compQuickProb = 0;
	static int trocaQuickProb = 0;

	public static void main(String args[]) throws IOException {

		int n = Integer.parseInt(args[0]);
		int tipo = Integer.parseInt(args[1]);

		int v[] = new int[n];

		File arquivo = new File("Saida.txt");
		PrintWriter escrita = new PrintWriter(arquivo);
		if (arquivo.exists()) {
			arquivo.delete();
			arquivo.createNewFile();
		}

		String modo = null;
		if (tipo == 1) {
			modo = " Ordenado Aleatóriamente";
		}
		if (tipo == 2) {
			modo = " Em Ordem Decrescente";
		}
		if (tipo == 3) {
			modo = " Em Ordem Crescente";
		}

		geraLista(v, tipo);
		int copia[] = v.clone();

		System.out.println("Inserçao: (" + n + " Elementos" + modo + " )");
		long tempo = System.nanoTime();
		if (n <= 100) {
			escrita.println("Inserção: ");
			escrita.print("Antes: ");
			for (int i = 0; i < copia.length; i++) {
				escrita.print(copia[i] + " ");
			}
			escrita.println("");
			tempo = System.nanoTime();
			insercao(copia);
			System.out.println("Tempo: " + (System.nanoTime() - tempo)
					/ 1000000.0 + " ms");
			escrita.print("Depois: ");

			for (int i = 0; i < copia.length; i++) {
				escrita.print(copia[i] + " ");
			}
			escrita.println("");
			escrita.println("");
			System.out.println(" ");
		} else if (n < 50000) {

			insercao(copia);
			System.out.println("Tempo: " + (System.nanoTime() - tempo)
					/ 1000000.0 + " ms");
			System.out.println(" ");
		}
		copia = v.clone();
		System.out.println("MergeSort: (" + n + " Elementos" + modo + " )");
		if (n <= 100) {
			escrita.println("MergeSort: ");
			escrita.print("Antes: ");
			for (int i = 0; i < copia.length; i++) {
				escrita.print(copia[i] + " ");
			}
			escrita.println("");
			tempo = System.nanoTime();
			mergeSort(copia, 0, n - 1);
			System.out.print("Comparacoes: " + compMerge + " Trocas: "
					+ trocaMerge);
			System.out.println(" Tempo: " + (System.nanoTime() - tempo)
					/ 1000000.0 + " ms");
			escrita.print("Depois: ");

			for (int i = 0; i < copia.length; i++) {
				escrita.print(copia[i] + " ");
			}
			escrita.println("");
			escrita.println("");
			System.out.println(" ");
		} else {
			tempo = System.nanoTime();
			mergeSort(copia, 0, n - 1);
			System.out.print("Comparacoes: " + compMerge + " Trocas: "
					+ trocaMerge);
			System.out.println("Tempo: " + (System.nanoTime() - tempo)
					/ 1000000.0 + " ms");
		}
		System.out.println("");
		copia = v.clone();
		System.out.println("Selecao: (" + n + " Elementos" + modo + " )");
		if (n <= 100) {
			escrita.println("Selecao: ");
			escrita.print("Antes: ");
			for (int i = 0; i < copia.length; i++) {
				escrita.print(copia[i] + " ");
			}
			escrita.println("");
			tempo = System.nanoTime();
			SelectionSort(copia);
			System.out.println("Tempo: " + (System.nanoTime() - tempo)
					/ 1000000.0 + " ms");
			escrita.print("Depois: ");

			for (int i = 0; i < copia.length; i++) {
				escrita.print(copia[i] + " ");
			}
			escrita.println("");
		} else if (n < 50000) {
			tempo = System.nanoTime();
			SelectionSort(copia);
			System.out.println("Tempo: " + (System.nanoTime() - tempo)
					/ 1000000.0 + " ms");
		}

		System.out.println("");
		copia = v.clone();
		System.out.println("ShellSort: (" + n + " Elementos" + modo + " )");
		if (n <= 100) {
			escrita.println("");
			escrita.println("ShellSort: ");
			escrita.print("Antes: ");
			for (int i = 0; i < copia.length; i++) {
				escrita.print(copia[i] + " ");
			}
			escrita.println("");
			tempo = System.nanoTime();
			ShellSort(copia);
			System.out.println(" Tempo: " + (System.nanoTime() - tempo)
					/ 1000000.0 + " ms");
			escrita.print("Depois: ");

			for (int i = 0; i < copia.length; i++) {
				escrita.print(copia[i] + " ");
			}
			escrita.println("");
		} else {
			tempo = System.nanoTime();
			ShellSort(copia);
			System.out.println(" Tempo: " + (System.nanoTime() - tempo)
					/ 1000000.0 + " ms");
		}
		System.out.println("");
		copia = v.clone();
		System.out.println("QuickSort: (" + n + " Elementos" + modo + " )");
		if (n <= 100) {
			escrita.println("");
			escrita.println("QuickSort: ");
			escrita.print("Antes: ");
			for (int i = 0; i < copia.length; i++) {
				escrita.print(copia[i] + " ");
			}
			escrita.println("");
			tempo = System.nanoTime();
			QuickSort(copia, 0, copia.length - 1);
			System.out.print("Comparacoes: " + compQuick + " Trocas: "
					+ trocaQuick);
			System.out.println(" Tempo: " + (System.nanoTime() - tempo)
					/ 1000000.0 + " ms");
			escrita.print("Depois: ");

			for (int i = 0; i < copia.length; i++) {
				escrita.print(copia[i] + " ");
			}
			escrita.println("");
		} else {
			tempo = System.nanoTime();
			QuickSort(copia, 0, copia.length - 1);
			System.out.print("Comparacoes: " + compQuick + " Trocas: "
					+ trocaQuick);
			System.out.println(" Tempo: " + (System.nanoTime() - tempo)
					/ 1000000.0 + " ms");
		}

		System.out.println("");
		copia = v.clone();
		System.out.println("QuickSortProbabilistic: (" + n + " Elementos"
				+ modo + " )");
		if (n <= 100) {
			escrita.println("");
			escrita.println("QuickSortProbabilistic: ");
			escrita.print("Antes: ");
			for (int i = 0; i < copia.length; i++) {
				escrita.print(copia[i] + " ");
			}
			escrita.println("");
			tempo = System.nanoTime();
			QuickSortProbabilistic(copia, 0, copia.length - 1);
			System.out.print("Comparacoes: " + compQuickProb + " Trocas: "
					+ trocaQuickProb);
			System.out.println(" Tempo: " + (System.nanoTime() - tempo)
					/ 1000000.0 + " ms");
			escrita.print("Depois: ");

			for (int i = 0; i < copia.length; i++) {
				escrita.print(copia[i] + " ");
			}
			escrita.println("");
		} else {
			tempo = System.nanoTime();
			QuickSortProbabilistic(copia, 0, copia.length - 1);
			System.out.print("Comparacoes: " + compQuickProb + " Trocas: "
					+ trocaQuickProb);
			System.out.println(" Tempo: " + (System.nanoTime() - tempo)
					/ 1000000.0 + " ms");
		}
		System.out.println("");
		copia = v.clone();
		System.out.println("CocktailSort: (" + n + " Elementos" + modo + " )");
		if (n <= 100) {
			escrita.println("");
			escrita.println("CocktailSort: ");
			escrita.print("Antes: ");
			for (int i = 0; i < copia.length; i++) {
				escrita.print(copia[i] + " ");
			}
			escrita.println("");
			tempo = System.nanoTime();
			CocktailSort(copia);
			System.out.println(" Tempo: " + (System.nanoTime() - tempo)
					/ 1000000.0 + " ms");
			escrita.print("Depois: ");

			for (int i = 0; i < copia.length; i++) {
				escrita.print(copia[i] + " ");
			}
			escrita.println("");
		} else {
			tempo = System.nanoTime();
			CocktailSort(copia);
			System.out.println(" Tempo: " + (System.nanoTime() - tempo)
					/ 1000000.0 + " ms");
		}
		escrita.close();
	}

	static void geraLista(int l[], int tipo) {

		switch (tipo) {
		case 1:

			Random r = new Random();
			for (int i = 0; i < l.length; i++) {
				l[i] = Math.abs(r.nextInt() % (10 * l.length));

			}

			break;

		case 2:

			int j = 0;
			for (int i = l.length; i > 0; i--) {
				l[j] = i;
				j++;
			}
			break;

		case 3:

			for (int i = 0; i < l.length; i++) {
				l[i] = i;

			}
			break;
		}

	}

	static void imprimeLista(int l[]) throws IOException {

		for (int i = 0; i < l.length; i++) {
			System.out.print(l[i] + " ");
		}
		System.out.println("");
	}

	static void insercao(int l[]) {
		int comp = 0, troca = 0;
		for (int i = 1; i < l.length; i++) {
			int pivo = l[i];
			int j = i - 1;

			while (j >= 0 && l[j] > pivo) {
				l[j + 1] = l[j];
				comp++;
				troca++;
				j--;
			}
			l[j + 1] = pivo;
			comp++;

		}
		System.out.print("Comparacoes: " + comp);
		System.out.print(" Trocas: " + troca + " ");
	}

	static void mergeSort(int[] vetor, int inicio, int fim) {

		if (inicio < fim) {
			int meio = (int) Math.floor((inicio + fim) / 2);
			if (inicio < meio)
				mergeSort(vetor, inicio, meio);
			if (meio + 1 < fim)
				mergeSort(vetor, meio + 1, fim);

			merge(vetor, inicio, meio, fim);
		}

	}

	static void merge(int[] vetor, int inicio, int meio, int fim) {
		int i = inicio, j = meio + 1, k = 0;
		int vetorAux[] = new int[fim - inicio];

		while (i <= meio && j <= fim) {
			if (vetor[i] <= vetor[j]) {
				vetorAux[k] = vetor[i];
				i++;
				compMerge++;
				trocaMerge++;
			} else {
				vetorAux[k] = vetor[j];
				j++;
				trocaMerge++;

				trocaMerge++;
			}
			k++;
			trocaMerge++;
			compMerge++;

		}
		if (i <= meio) {
			for (j = meio; j >= i; j--)
				vetor[fim - meio + j] = vetor[j];
		}
		for (i = 0; i < k; i++)
			vetor[inicio + i] = vetorAux[i];
		trocaMerge++;
		compMerge++;
	}

	static void SelectionSort(int[] v) {
		int min, aux, comp = 0, troca = 0;

		for (int i = 0; i < v.length; i++) {
			min = i;
			for (int j = i + 1; j < v.length; j++) {
				if (v[j] < v[min]) {
					min = j;
				}
				comp++;
			}
			if (min != i) {
				aux = v[min];
				v[min] = v[i];
				v[i] = aux;
				troca++;
			}
		}
		System.out.print("Comparacoes: " + comp);
		System.out.print(" Trocas: " + troca + " ");
	}

	static void ShellSort(int[] vetor) {
		int i, j, h = 1, pivo, comp = 0, troca = 0;

		do {
			h = 3 * h + 1;
		} while (h < vetor.length);
		do {
			h = h / 3;
			for (i = h; i < vetor.length; i++) {
				pivo = vetor[i];
				j = i - h;
				comp++;
				while (j >= 0 && pivo < vetor[j]) {
					vetor[j + h] = vetor[j];
					j = j - h;
					comp++;
					troca++;
				}
				vetor[j + h] = pivo;
			}
			comp++;
		} while (h > 1);
		System.out.print("Comparacoes: " + comp);
		System.out.print(" Trocas: " + troca);
	}

	static void QuickSort(int[] v, int ini, int fim) {
		int meio;

		if (ini < fim) {
			meio = partition(v, ini, fim);
			compQuick++;

			if (ini < meio - 1) {
				compQuick++;

				QuickSort(v, ini, meio);
			}
			if (meio + 1 < fim) {
				compQuick++;

				QuickSort(v, meio + 1, fim);
			}
		}
	}

	public static int partition(int[] v, int ini, int fim) {
		int pivo, topo, i;
		pivo = v[ini];
		topo = ini;

		for (i = ini + 1; i <= fim; i++) {
			if (v[i] < pivo) {
				v[topo] = v[i];
				v[i] = v[topo + 1];
				topo++;

				compQuick++;

			}
		}
		v[topo] = pivo;
		trocaQuick++;
		return topo;
	}

	static void QuickSortProbabilistic(int[] v, int ini, int fim) {
		int meio;

		if (ini < fim) {
			meio = partition2(v, ini, fim);
			compQuickProb++;
			if (ini < meio - 1) {
				compQuickProb++;
				QuickSort(v, ini, meio);
			}
			if (meio + 1 < fim) {
				compQuickProb++;
				QuickSort(v, meio + 1, fim);
			}
		}
	}

	public static int partition2(int[] v, int ini, int fim) {
		int pivo = 0, topo, i, media = 0;
		for (int j = 0; j < v.length; j++) {
			media = media + v[j];
		}
		pivo = media / v.length;
		topo = ini;
		
		for (i = ini + 1; i <= fim; i++) {
			if (v[i] < pivo) {
				v[topo] = v[i];
				v[i] = v[topo + 1];
				topo++;
				compQuickProb++;
				trocaQuickProb++;
			}
		}
		v[topo] = pivo;
		compQuickProb++;
		return topo;

	}

	static void CocktailSort(int[] vetor) {
		int tamanho, inicio, fim, swap, aux, troca = 0, comp = 0;
		tamanho = vetor.length;
		inicio = 0;
		fim = tamanho - 1;
		swap = 0;
		while (swap == 0 && inicio < fim) {
			swap = 1;
			comp++;
			for (int i = inicio; i < fim; i = i + 1) {
				if (vetor[i] > vetor[i + 1]) {
					aux = vetor[i];
					vetor[i] = vetor[i + 1];
					vetor[i + 1] = aux;
					swap = 0;
					comp++;
					troca++;
				}
			}
			fim = fim - 1;
			for (int i = fim; i > inicio; i = i - 1) {
				if (vetor[i] < vetor[i - 1]) {
					aux = vetor[i];
					vetor[i] = vetor[i - 1];
					vetor[i - 1] = aux;
					swap = 0;
					comp++;
					troca++;
				}
			}
			inicio = inicio + 1;
		}
		System.out.print("Comparacoes: " + comp);
		System.out.print(" Trocas: " + troca);
	}
}
