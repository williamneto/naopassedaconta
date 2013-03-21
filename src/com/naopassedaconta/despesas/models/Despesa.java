package com.naopassedaconta.despesas.models;

import com.naopassedaconta.despesas.dao.DespesaDAO;

public class Despesa{
	public String id;
	public String descricao;
	public String valor;
	
	
	public void save() {
		DespesaDAO.getInstance().insert(this);
	}
}
