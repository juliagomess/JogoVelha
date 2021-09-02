import java.util.Scanner;

public class JogoDaVelha {
	
	public static void imprime_tabuleiro(int tabuleiro[][], int flag) {
		System.out.print("\n");
		for(int i=0; i<3; i++)
		{
			if(i>0)
				System.out.println("\n\t---|---|---");
			System.out.print("\t");
			for(int j=0; j<3; j++)
			{
				if(flag==1)
					System.out.printf(" %d ",3*i+j);
				else
					if(tabuleiro[i][j]==0)
						System.out.printf("   ");
					else
						if(tabuleiro[i][j]==1)
							System.out.printf(" X ");
						else
							if(tabuleiro[i][j]==2)
								System.out.printf(" O ");
						
				if(j<2)
					System.out.print("|");
			}
		}
		System.out.print("\n\n");
	}
	
	public static void introducao(int tabuleiro[][]) {
		System.out.println("Bem vindo ao jogo da velha!");
		System.out.println("===============================");
		System.out.println("\nEsse é o tabuleiro e suas posições:");
		imprime_tabuleiro(tabuleiro,1);
		System.out.println("Você poderá sempre rever as posições do tabuleiro digitando 9");
		System.out.println("\nO jogador 1 será X");
		System.out.println("O jogador 2 será O");
		System.out.println("\nVamos começar!");
		System.out.println("=================================");
	}
	
	public static void jogada(int tabuleiro[][], int rodada) {
		Scanner input = new Scanner(System.in);
		int posicao=0,flag=0;
		
		if((rodada%2)==0)
		{
			System.out.println("\nVEZ DO JOGADOR 1");
			imprime_tabuleiro(tabuleiro,0);
			
			while(flag==0)
			{
				do {
					System.out.print("Escolha sua posição (para relembrar as posições digite 9): ");
					posicao = input.nextInt();
				}while(posicao>9);
				
				if(posicao==9)
				{
					System.out.print("\nPOSICÕES ");
					imprime_tabuleiro(tabuleiro,1);
					System.out.print("\nEscolha sua posição: ");
					posicao = input.nextInt();
				}
				
				int i=posicao/3;
				int j=posicao%3;
				
				if(tabuleiro[i][j]==0)
				{
					flag=1;
					tabuleiro[i][j]=1;
				}
				else
					System.out.println("Essa posição já esta ocupada!!");
				
				imprime_tabuleiro(tabuleiro,0);
			}
		}
		else
		{
			System.out.println("\nVEZ DO JOGADOR 2");
			imprime_tabuleiro(tabuleiro,0);
			while(flag==0)
			{
				do {
					System.out.print("Escolha sua posição (para relembrar as posições digite 9): ");
					posicao = input.nextInt();
				}while(posicao>9);
				
				if(posicao==9)
				{
					System.out.print("\nPOSICÕES ");
					imprime_tabuleiro(tabuleiro,1);
					System.out.print("\nEscolha sua posição: ");
					posicao = input.nextInt();
				}
				
				int i=posicao/3;
				int j=posicao%3;
				
				if(tabuleiro[i][j]==0)
				{
					flag=1;
					tabuleiro[i][j]=2;
				}
				else
					System.out.println("Essa posição já esta ocupada!!");
				
				imprime_tabuleiro(tabuleiro,0);
			}
		}
	}
	
	public static int verifica_jogo(int tabuleiro[][]) {
		int flag=0;
		
		for(int i=0;i<3;i++) /// Verifica linhas
			if(tabuleiro[i][0]==tabuleiro[i][1] && tabuleiro[i][1]==tabuleiro[i][2])
				return tabuleiro[i][0];
		
		for(int j=0;j<3;j++) /// Vetifica colunas
			if(tabuleiro[0][j]==tabuleiro[1][j] && tabuleiro[1][j]==tabuleiro[2][j])
				return tabuleiro[0][j];
					
		if(tabuleiro[0][0]==tabuleiro[1][1] && tabuleiro[1][1]==tabuleiro[2][2]) ///Verifica diagonal
			return tabuleiro[0][0];
		
		if(tabuleiro[0][2]==tabuleiro[1][1] && tabuleiro[1][1]==tabuleiro[2][0]) ///Verifica diagonal
			return tabuleiro[0][2];
		
		for(int i=0;i<3;i++) ///Verifica empate
			for(int j=0;j<3;j++)
				if(tabuleiro[i][j]==0)
					flag=1;
		
		if(flag==0)
			return 3;
		
		return 0;
	}

	public static void main(String[] args) {
		int tabuleiro[][] = new int[3][3];
		int vencedor=0;
		
		introducao(tabuleiro);
		
		for(int rodada=0;vencedor==0;rodada++)
		{
			jogada(tabuleiro,rodada);
			vencedor=verifica_jogo(tabuleiro);
		}
		
		if(vencedor==1)
			System.out.println("JOGADOR 1 É O VENCEDOR!! PARABÉNS!!");
		else
			if(vencedor==2)
				System.out.println("JOGADOR 2 É O VENCEDOR!! PARABÉNS!!");
			else
				if(vencedor==3)
					System.out.println("EMPATE!!");
		
		System.out.print("Obrigada por jogar!");

	}

}
