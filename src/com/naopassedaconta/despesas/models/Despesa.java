package com.naopassedaconta.despesas.models;

import java.io.Serializable;

import com.naopassedaconta.despesas.dao.DespesaDAO;

public class Despesa implements Serializable {
	public String id;
	public String descricao;
	public String valor;
	
	public static Despesa getById(String id){
		return DespesaDAO.getInstance().findById(id);
	}

}
