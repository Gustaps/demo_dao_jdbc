package model.dao;

import db.DB;
import model.dao.impl.SellerDaoJDBC;

// esta classe tera operacoes estaticas para instanciar os DAOs
// a classe vai expor um metodo que retorna o tipo da interface, mas internamente vai instanciar uma implementacao
// macete para nao expor a implementação. Deixar apenas a interface.

public class DaoFactory {
	public static SellerDao createSellerDao() {
		return new SellerDaoJDBC(DB.getCconnection());
	}

}
