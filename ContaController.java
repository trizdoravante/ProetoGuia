package conta.controller;
import java.util.ArrayList;
import conta.model.Conta;
import conta.repository.ContaRepository;
public class ContaController implements ContaRepository{
	private ArrayList<Conta> listaContas = new ArrayList<Conta>();
	int numero = 0;

	@Override
	public void procurarPorNumero(int numero) {
		var conta = buscarNaCollection (numero);
		if (conta!=null) {
			conta.visualizar();
		}else {
			System.out.println("A conta número "+numero+"não foi encontrada!");
		}
		
	}

	@Override
	public void listarTodas() {
		for (var conta : listaContas) {
			conta.visualizar();
		}
		
	}

	@Override
	public void cadastrar(Conta conta) {
		listaContas.add(conta);
		System.out.println("\nA conta número: "+conta.getConta()+" foi criada com sucesso!");
		
	}

	@Override
	public void atualizar(Conta conta) {
		var buscaConta = buscarNaCollection(conta.getConta());
		if(buscaConta!=null) {
			listaContas.set(listaContas.indexOf(buscaConta), conta);
			System.out.println("A conta número "+conta.getConta()+" foi atualizada com sucesso!");
					}else {
						System.out.println("A conta número "+conta.getConta()+" não foi encontrada!");
					}
		
	}

	@Override
	public void deletar(int numero) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sacar(int numero, float valor) {
		var conta = buscarNaCollection(numero);
		if(conta!=null) {
			if(conta.sacar(valor)==true) {
				System.out.println("\nO saque na conta número "+numero+" foi efetuado com sucesso!");
			}
		}else {
			System.out.println("\nA conta número "+numero+" não foi encontrada!");
		}
		
	}

	@Override
	public void depositar(int numero, float valor) {
		var conta = buscarNaCollection(numero);
		if(conta!=null) {
			conta.depositar(valor);
			System.out.println("\nO depósito na conta: "+numero+" foi efetuado com sucesso");
						
		}else {
			System.out.println("\nA conta número: "+numero+" não foi encontrada ou a Conta destino não é uma Conta Corrente!");
			
		}
		
	}

	@Override
	public void transferir(int numeroOrigem, int numeroDestino, float valor) {
		var contaOrigem = buscarNaCollection(numeroOrigem);
		var contaDestino = buscarNaCollection(numeroDestino);
		if(contaOrigem!=null && contaDestino!=null){
			if(contaOrigem.sacar(valor)==true) {
				contaDestino.depositar(valor);
				System.out.println("\nA transferência foi efetuada com sucesso!");
			}
						
		}else 
			System.out.println("\n A conta de origem e/ou destino não foram encontradas!");
		
	}



public int gerarNumero() {
	return ++ numero;
	
}
public Conta buscarNaCollection(int numero) {
	for (var conta: listaContas) {
		if(conta.getConta()==numero) {
			return conta;
		}
	}
	return null;
	
}

public int retornaTipoint(int numero) {
	for(var conta : listaContas ) {
		if(conta.getConta()==numero) {
			return conta.getTipo();
			
		}
	}
	return 0;
}
public void deleta (int numero) {
	var conta = buscarNaCollection(numero);
	if(listaContas.remove(conta)==true) {
		System.out.println("A conta número "+numero+" foi deletada com sucesso");
		
		
	}else {
		System.out.println("A conta número "+numero+"não foi encontrada!");
	}
}

}


