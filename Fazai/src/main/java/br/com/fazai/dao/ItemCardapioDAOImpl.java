package br.com.fazai.dao;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.fazai.model.ItemCardapio;

@Repository
public class ItemCardapioDAOImpl extends UtilJpaSpring implements ItemCardapioDAO {

    @Override
    public void salvarItemCardapio(ItemCardapio itemcardapio) {
	getManager().persist(itemcardapio);

    }

    @Override
    public void alterarItemCardapio(ItemCardapio itemcardapio) {
	getManager().merge(itemcardapio);
    }

    @Override
    public ItemCardapio consultarItemCardapioPorCodigo(int codigo) {
	return getManager().find(ItemCardapio.class, codigo);
    }

    @Override
    public void Excluir(int codigo) {

	ItemCardapio itemcardapio = this.consultarItemCardapioPorCodigo(codigo);

	getManager().remove(itemcardapio);

    }

    @Override
    public List<ItemCardapio> todosItems() {
	return getManager().createQuery("SELECT c FROM ItemCardapio c ORDER BY c.nome ", ItemCardapio.class)
		.getResultList();
    }

    @Override
    public List<ItemCardapio> todosItemsporCardapio(int codigo_cardapio) {
	Query query = getManager().createQuery(
		"SELECT c FROM ItemCardapio c WHERE cardapio.id_cardapio = :codigo_cardapio");
	query.setParameter("codigo_cardapio", codigo_cardapio);
	List<ItemCardapio> todosItensCardapio = query.getResultList();

	return todosItensCardapio;

    }
    

}
