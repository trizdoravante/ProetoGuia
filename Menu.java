package conta;

import java.io.IOException;
import java.util.Scanner;

import conta.controller.ContaController;
import conta.model.Conta;
import conta.model.ContaCorrente;
import conta.model.ContaPoupanca;
import conta.util.cores;

public class Menu {

	public static void main(String[] args) {
		ContaController contas = new ContaController();
		int Opcao, numero, agencia, tipo, aniversario, numeroDestino;
		String titular;
		float saldo, limite, valor;
		System.out.println("\nCriar Contas: ");
		ContaCorrente cc1 = new ContaCorrente(contas.gerarNumero(), 123, 1, "João da Silva",1000f, 100.0f);
		contas.cadastrar(cc1);
		ContaCorrente cc2 = new ContaCorrente(contas.gerarNumero(), 124, 1, "Maria da Silva",2000f, 100.0f);
		contas.cadastrar(cc2);
		ContaPoupanca cp1 = new ContaPoupanca(contas.gerarNumero(), 125, 2, "Mariana dos Santos", 4000f, 12);
		contas.cadastrar(cp1);
		ContaPoupanca cp2 = new ContaPoupanca(contas.gerarNumero(), 125, 2, "Juliana Ramos", 8000f, 15);
		contas.cadastrar(cp2);
		contas.listarTodas();
		
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
			 System.out.println("                3 - Buscar conta por Numero        ");
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
				 System.out.println("Digite o número da agência: ");
				 agencia = leia.nextInt();
				 System.out.println("Digite o nome do titular: ");
				 leia.skip("\\R?");
				 titular = leia.nextLine();
				 do {
					 System.out.println("Digite o tipo de conta: (1 - CC ou 2 - CP)");
					 tipo = leia.nextInt();					 
				 }while (tipo <=1 && tipo>=2);
				 System.out.println("Digite o valor correspondente ao saldo da conta (R$): ");
				 saldo = leia.nextFloat();
				 switch(tipo) {
				 case 1 :{
					 System.out.println("Digite o limite de crédito (R$): ");
					 limite = leia.nextFloat();
					 contas.cadastrar(new ContaCorrente( contas.gerarNumero(), agencia, tipo, titular, saldo, limite));
				 }
				 case 2 :{
					 System.out.println("Digite o dia do aniversário da conta: ");
					 aniversario = leia.nextInt();
					 contas.cadastrar(new ContaPoupanca( contas.gerarNumero(), agencia, tipo, titular, saldo, aniversario));
					 
				 }
					 
				 }
			    			    	 
				 keyPress();
				 break;
			 case 2:
				 System.out.println(cores.TEXT_WHITE_BOLD+"Listar todas as Contas\n\n");
				 contas.listarTodas();
				 keyPress();
				 break;
			 case 3:
				 System.out.println(cores.TEXT_WHITE_BOLD+"Consultar dados da Conta - por número\n\n");
				 System.out.println("Digite o número da conta: ");
				 numero = leia.nextInt();
				 contas.procurarPorNumero(numero);
		
				 keyPress();
				 break;
			 case 4:
				 System.out.println(cores.TEXT_WHITE_BOLD+"Atualizar Dados da Conta\n\n");
                 System.out.println("Digite o número da conta: ");
                 numero = leia.nextInt();
                 if(contas.buscarNaCollection(numero)!=null) {
                 System.out.println("Digite o número da agência: ");
                 agencia = leia.nextInt();
                 System.out.println("Digite o nome do titular: ");
                 leia.skip("\\R?");
                 titular = leia.nextLine();
                 
                 System.out.println("Digite o saldo da conta (R$): ");
                 saldo = leia.nextFloat();
                 
                 tipo = contas.retornaTipoint(numero);
                 switch(tipo) {
				 case 1 :{
					 System.out.println("Digite o limite de crédito (R$): ");
					 limite = leia.nextFloat();
					 contas.cadastrar(new ContaCorrente( contas.gerarNumero(), agencia, tipo, titular, saldo, limite));
				 }
				 case 2 :{
					 System.out.println("Digite o dia do aniversário da conta: ");
					 aniversario = leia.nextInt();
					 contas.cadastrar(new ContaPoupanca( contas.gerarNumero(), agencia, tipo, titular, saldo, aniversario));
					 
				 }
				 default :{
					 System.out.println("Tipo de conta inválido!");
				 }
                 }
                 
                 }else {
                	 System.out.println("A conta não foi encontrada!");
                 }
				 keyPress();
				 break;
			 case 5:
				 System.out.println(cores.TEXT_WHITE_BOLD+"Apagar Conta\n\n");
				 System.out.println("Digite o número da conta: ");
				 numero = leia.nextInt();
				 contas.deleta(numero);
				 keyPress();
				 break;
			 case 6:
				 System.out.println(cores.TEXT_WHITE_BOLD+"Saque\n\n");
				System.out.println("Digite o número da conta: ");
				numero = leia.nextInt();
				do {
					System.out.println("Digite o valor do saque (R$): ");
					valor = leia.nextFloat();
				}while (valor<=0);
				contas.sacar(numero, valor);
				 keyPress();
				 break;
			 case 7:
				 System.out.println(cores.TEXT_WHITE_BOLD+"Depósito\n\n");
				 System.out.println("Digite o número da conta: ");
					numero = leia.nextInt();
					do {
						System.out.println("\nDigite o valor do Depósito (R$): ");
						valor = leia.nextFloat();
					} while (valor<=0);
					contas.depositar(numero, valor);
				 keyPress();
				 break;
			 case 8:
				 System.out.println(cores.TEXT_WHITE_BOLD+"Tranferência entre Contas\n\n");
				System.out.println("\nDigite o número da conta origem: ");
				numero = leia.nextInt();
				System.out.println("Digite o número da conta destino: ");
				numeroDestino = leia.nextInt();
				do {
					System.out.println("\nDigite o valor da transferência (R$): ");
					valor = leia.nextFloat();
				}while(valor<=0);
				contas.transferir(numero, numeroDestino, valor);
				 keyPress();
				 break;
				 default:
					 System.out.println(cores.TEXT_RED_BOLD+"\nOpção inválida!\n"+cores.TEXT_RESET);
					 keyPress();
					 break;
			 }
			 

	}

}
	public static void keyPress() {
		try {
			System.out.println(cores.TEXT_RESET+"\n\nPressione a tecla 'Enter' caso deseje continuar...");
			System.in.read();
		} catch(IOException e) {
			System.out.println("Você pressionou uma tecla diferente de entender!!!");
			
		}
	}

}
