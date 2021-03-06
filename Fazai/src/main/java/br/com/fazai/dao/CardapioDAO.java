package br.com.fazai.dao;

import java.util.List;

import br.com.fazai.model.Cardapio;
import br.com.fazai.model.ItemCardapio;


public interface CardapioDAO {
	
	public void salvarCardapio(Cardapio cardapio);
	public void alterarCardapio(Cardapio cardapio);
	public Cardapio consultarCardapioPorCodigo(int codigo);
	public void Excluir(int codigo);
	public List<Cardapio> todosCardapios(int codigo_estabelecimento);
	List<ItemCardapio> todosItemsPorCardapio(int codigo_cardapio);

}
