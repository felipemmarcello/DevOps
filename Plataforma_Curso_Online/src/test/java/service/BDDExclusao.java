package service;

import static org.junit.Assert.assertEquals;

import java.util.Iterator;

import org.junit.*;
import org.junit.Before;
import org.junit.Test;


import dominio.Plataforma;
import dominio.Trilha;
import junit.framework.Assert;
import dominio.Aluno;
import dominio.Curso;

public class BDDExclusao {

    private Plataforma plataforma;
    private Aluno aluno1, aluno2, aluno3, aluno4, aluno5;
    private Curso curso1, curso2, curso3;
    private Trilha trilha1, trilha2;
    private double i = 0.0;

    @Before
    public void setUp() {
        plataforma = new Plataforma("Minha Plataforma de Educação");
        trilha1 = new Trilha("Desenvolvimento de Software", "Trilha de desenvolvimento de software");
        trilha2 = new Trilha("Inteligência Artificial", "Trilha de IA");
        curso1 = new Curso("Java Programming", "Curso de programação Java", "Java");
		curso2 = new Curso("Web Development", "Curso de desenvolvimento web", "Web");
		curso3 = new Curso("Machine Learning", "Curso de aprendizado de máquina", "ML");
		
		aluno1 = new Aluno("João","123.456.789-00", "Masculino");
		aluno2 = new Aluno("Maria","133.456.789-00", "Feminino");
		aluno3 = new Aluno("Pedro", "124.456.789-00", "Masculino");
		aluno4 = new Aluno("Ana", "125.456.789-00", "Feminino");
		aluno5 = new Aluno("Luiz", "126.456.789-00", "Masculino");
		
    }

    @Test
    public void testExcluirTrilhaExistente() {
    	//ARANGE
    	curso1.adicionaAlunoLista(aluno1);
		curso1.adicionaAlunoLista(aluno2);
		curso2.adicionaAlunoLista(aluno3);
		curso2.adicionaAlunoLista(aluno4);
		curso3.adicionaAlunoLista(aluno5);
		trilha1.adicionaCursoLista(curso1);
		trilha1.adicionaCursoLista(curso2);
		trilha2.adicionaCursoLista(curso3);		
		plataforma.adicionarTrilhaLista(trilha1);
		plataforma.adicionarTrilhaLista(trilha2);
		
        //ACTION
        plataforma.excluirTrilhaPorNome("Desenvolvimento de Software");
        
        Iterator<Trilha> iterator = plataforma.getListaTrilha().iterator();
        while (iterator.hasNext()) {
            Trilha trilha = iterator.next();
            if (trilha.getNome().equals("Desenvolvimento de Software")) {
            	i++;            	
            }}
        
        //ASSERT
        assertEquals(i, 0.0, 0.0001);
        
    }

    
}