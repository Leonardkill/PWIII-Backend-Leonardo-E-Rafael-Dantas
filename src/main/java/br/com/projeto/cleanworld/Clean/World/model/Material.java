package br.com.projeto.cleanworld.Clean.World.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Table(name=("Material"))
@Entity
@Setter
@Getter

public class Material {
	
	
	@Column(name="idMaterial")
	@GeneratedValue
	@Id
	private Integer idMaterial;
	
	@Column(name="idTipoMaterial")
	private Integer tipoMaterial;
	
	@Column(name="dsMaterial")
	private String dsMaterial;
	
	@Column(name="Pontuacao")
	private Float pontuacao;

}
