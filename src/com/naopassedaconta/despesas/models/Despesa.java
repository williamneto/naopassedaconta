package com.naopassedaconta.despesas.models;

import java.util.List;

import com.naopassedaconta.despesas.dao.DespesaDAO;

public class Despesa{
	public String id;
	public String descricao;
	public String valor;
	
	
	public void save() {
		DespesaDAO.getInstance().insert(this);
	}
	
	public static List<Despesa> getDespesas(){
		return DespesaDAO.getInstance().getDespesas();
	}
}
