package ws;

import umc.sd.dao.ContaDAO;
import umc.sd.model.ContaPresenter;

public class ServicoConta {
	
	public int abrirConta(String nome, int senha) {
		
		int resultado = 0;
		
		try {
			
			ContaDAO contaDAO = new ContaDAO();
			
			resultado = contaDAO.abrir(nome, senha);
			
		} catch (Exception e) {
			System.out.println("Erro no servico abrirConta: " + e.getMessage());
		}
		
		return resultado;
		
	}
	
	public boolean fecharConta(int id, int senha) {
		
		boolean resultado = false;
		
		try {
			
			ContaDAO contaDAO = new ContaDAO();
			
			resultado = contaDAO.fechar(id, senha);
			
		} catch (Exception e) {
			System.out.println("Erro no servico fecharConta: " + e.getMessage());
		}
		
		return resultado;
	}
	
	public String[] consultarDadosConta(int id, int senha) {
		
		String[] dadosConta = null;
		
		try {
			
			ContaDAO contaDAO = new ContaDAO();
			
			ContaPresenter conta = contaDAO.recuperarPorId(id, senha);
			
			if (conta != null) {
				dadosConta = new String[2];
				dadosConta[0] = conta.getNome();
				dadosConta[1] = Double.toString(conta.getSaldo());
			}
			
		} catch (Exception e) {
			System.out.println("Erro no servico consultarDadosConta: " + e.getMessage()); 
		}
		
		return dadosConta;
	}
	
	public boolean deposito(int id, int senha, double valor) {
		
		boolean resultado = false;
		
		try {
			
			ContaDAO contaDAO = new ContaDAO();
			
			resultado = contaDAO.depositar(id, senha, valor);
			
		} catch (Exception e) {
			System.out.println("Erro no servico deposito: " + e.getMessage());
		}
		
		return resultado;
	}
	
	public boolean saque(int id, int senha, double valor) {
		
		boolean resultado = false;
		
		try {
			
			ContaDAO contaDAO = new ContaDAO();
			
			resultado = contaDAO.sacar(id, senha, valor);
			
		} catch (Exception e) {
			System.out.println("Erro no servico saque: " + e.getMessage());
		}
		
		return resultado;
	}
}
