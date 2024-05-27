package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entities.enums.LevelTrabalhador;

public class Trabalhador {

	private String nome;
	private LevelTrabalhador level;
	private Double salarioBase;
	
	private Departamento departamento;
	private List<ContratoHoras> contratos = new ArrayList<>();
	
	public Trabalhador() {
	}

	public Trabalhador(String nome, LevelTrabalhador level, Double salarioBase, Departamento departamento) {
		this.nome = nome;
		this.level = level;
		this.salarioBase = salarioBase;
		this.departamento = departamento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LevelTrabalhador getLevel() {
		return level;
	}

	public void setLevel(LevelTrabalhador level) {
		this.level = level;
	}

	public Double getSalarioBase() {
		return salarioBase;
	}

	public void setSalarioBase(Double salarioBase) {
		this.salarioBase = salarioBase;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public List<ContratoHoras> getContratos() {
		return contratos;
	}

	public void addContrado(ContratoHoras contrato) {
		contratos.add(contrato);
	}
	
	public void removeContrato(ContratoHoras contrato) {
		contratos.remove(contrato);
	}
	
	public double renda(int year, int month) {
		double soma = salarioBase;
		Calendar cal = Calendar.getInstance();
		for (ContratoHoras c : contratos) {
			cal.setTime(c.getDate());
			int c_year = cal.get(Calendar.YEAR);
			int c_month = cal.get(Calendar.MONTH);
			if (year == c_year && month == c_month) {
				soma += c.valorTotal();
			}
		}
		return soma;
	}
}
