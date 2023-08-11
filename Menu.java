package conta;

import java.util.Scanner;
import conta.model.Conta;
import conta.model.ContaCorrente;
import conta.model.ContaPoupanca;
import conta.util.cores;

public class Menu {

	public static void main(String[] args) {
		//Testando a classe conta//
		Conta c1 = new Conta(1, 123, 1, "Adriana", 10000.0f);
		c1.visualizar();
		c1.sacar(12000.0f);
		c1.visualizar();
		c1.depositar(5000.0f);
		c1.visualizar();
		//Teste conta corrente//
		ContaCorrente cc1 = new ContaCorrente(2,123,1,"Mariana", 500000.0f);
		cc1.visualizar();
		cc1.sacar(12000.0f);
		cc1.visualizar();
		cc1.depositar(5000.0f);
		cc1.visualizar();
		
		//Teste conta poupanca//
		ContaPoupanca cp1 = new ContaPoupanca(2, 123, 2, "Victor", 100000.0f);
		cp1.visualizar();
        cp1.sacar(1000.0f);
		cp1.visualizar();
		cp1.depositar(5000.0f);
		cp1.visualizar();
		
		
		Scanner leia = new Scanner(System.in);
		int opcao;
		 while(true) {
			System.out.println(cores.TEXT_YELLOW+cores.ANSI_BLACK_BACKGROUND);
			 System.out.println("***************************************************");
			 System.out.println("                                                   ");
			 System.out.println("**************BANCO DO BRAZIL COM Z****************");
			 System.out.println("                                                   ");
			 System.out.println("***************************************************");
			 System.out.println("                                                   ");
			 System.out.println("                1 - Criar conta                    ");
			 System.out.println("                2 - Listar todas as Contas         ");
			 System.out.println("                2 - Buscar conta por Numero        ");
			 System.out.println("                4 - Atualizar Dados da Conta       ");
			 System.out.println("                5 - Apagar Conta                   ");
			 System.out.println("                6 - Sacar                          ");
			 System.out.println("                7 - Depositar                      ");
			 System.out.println("                8 - Transferir valores entre Contas");    
			 System.out.println("                9 - Sair                           ");
			 System.out.println("                                                   ");
			 System.out.println("***************************************************");
			 System.out.println("Entre com a opção desejada:                        ");
			 System.out.println("                                                   "+cores.TEXT_RESET);
			 
			 opcao = leia.nextInt();
			 
			 if(opcao==9) {
			 System.out.println(cores.TEXT_WHITE_BOLD+"\nBanco do Brazil com Z - O seu futuro começa aqui!");
			 leia.close();
			 System.exit(0);
		 }
			 switch(opcao) {
			 case 1:
				 System.out.println(cores.TEXT_WHITE_BOLD+"Criar Conta\n\n");
				 break;
			 case 2:
				 System.out.println(cores.TEXT_WHITE_BOLD+"Listar todas as Contas\n\n");
				 break;
			 case 3:
				 System.out.println(cores.TEXT_WHITE_BOLD+"Consultar dados da Conta - por número\n\n");
				 break;
			 case 4:
				 System.out.println(cores.TEXT_WHITE_BOLD+"Atualizar Dados da Conta\n\n");
				 break;
			 case 5:
				 System.out.println(cores.TEXT_WHITE_BOLD+"Apagar Conta\n\n");
				 break;
			 case 6:
				 System.out.println(cores.TEXT_WHITE_BOLD+"Saque\n\n");
				 break;
			 case 7:
				 System.out.println(cores.TEXT_WHITE_BOLD+"Depósito\n\n");
				 break;
			 case 8:
				 System.out.println(cores.TEXT_WHITE_BOLD+"Tranferência entre Contas\n\n");
				 break;
				 default:
					 System.out.println(cores.TEXT_RED_BOLD+"\nOpção inválida!\n"+cores.TEXT_RESET);
					 break;
			 }
			 

	}

}
}
