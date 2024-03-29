/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service;

import static javax.ejb.TransactionAttributeType.REQUIRED;
import static javax.ejb.TransactionAttributeType.SUPPORTS;
import static javax.ejb.TransactionAttributeType.NOT_SUPPORTED;
import static javax.ejb.TransactionManagementType.CONTAINER;
import static javax.persistence.PersistenceContextType.TRANSACTION;

import java.util.List;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionManagement;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import model.entities.Entidade;

/**
 *
 * @author marcos
 * @param <T>
 */
@TransactionManagement(CONTAINER)
@TransactionAttribute(REQUIRED)
public abstract class Servico<T extends Entidade> {

    @PersistenceContext(name = "trueTravel", type = TRANSACTION)
    protected EntityManager entityManager;
    protected Class<T> classe;

    @TransactionAttribute(NOT_SUPPORTED)
    protected void setClasse(@NotNull Class<T> classe) {
        this.classe = classe;
    }

    @TransactionAttribute(SUPPORTS)
    public abstract T criar();

    @TransactionAttribute(SUPPORTS)
    public boolean existe(@NotNull T entidade) {
        return true;
    }

    @TransactionAttribute(SUPPORTS)
    public void persistir(@Valid T entidade) {
        if (!existe(entidade)) {
            entityManager.persist(entidade);
        }
    }
    @TransactionAttribute(SUPPORTS)
    public T atualizar(@Valid T entidade) {
        if (existe(entidade)) {
            entidade = entityManager.merge(entidade);
            entityManager.flush();
        }
        
        return entidade;
    }

    public T consultarPorId(@NotNull Long id) {
        return entityManager.find(classe, id);
    }

    @TransactionAttribute(SUPPORTS)
    protected T consultarEntidade(Object[] parametros, String nomeQuery) {
        TypedQuery<T> query = entityManager.createNamedQuery(nomeQuery, classe);

        int i = 1;
        for (Object parametro : parametros) {
            query.setParameter(i++, parametro);
        }

        return query.getSingleResult();
    }

    @TransactionAttribute(SUPPORTS)
    protected List<T> consultarEntidades(Object[] parametros, String nomeQuery) {
        TypedQuery<T> query = entityManager.createNamedQuery(nomeQuery, classe);

        int i = 1;
        for (Object parametro : parametros) {
            query.setParameter(i++, parametro);
        }

        return query.getResultList();
    }
    
    @TransactionAttribute(SUPPORTS)
    protected List<T> pesquisar(String valor,String parametro, String nomeQuery) {
        TypedQuery<T> query = entityManager.createNamedQuery(nomeQuery, classe);

            query.setParameter(parametro, "%" + valor + "%");

        return query.getResultList();
    }
}
