package com.gchengc.ff.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.IdentifiableType;
import javax.persistence.metamodel.Metamodel;
import javax.persistence.metamodel.SingularAttribute;


public abstract class AbstractFacade<T> {

    private Class<T> entityClass;

    @PersistenceUnit(unitName = "MySql_FF")
    private EntityManagerFactory emf;

    private static EntityManager em;


    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public AbstractFacade(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    public Object create(T entity) throws Exception {
        try {
            if (entity != null) {
                em = getEntityManager();

                if (em.isOpen())
                    em.persist(entity);

            }
            em.flush();
            return em.contains(entity);
        } catch (Exception e) {
            throw new Exception(e);
        } finally {
            em.clear();
            if (em != null && em.isOpen()) em.close();
        }
    }

    public Object findAll() throws Exception {
        try {
            em = getEntityManager();
            if (em.isOpen()) {
                CriteriaQuery<T> cq = em.getCriteriaBuilder().createQuery(entityClass);
                //https://stackoverflow.com/questions/16909236/retrieve-primary-key-column-definition-of-a-generic-entity-in-jpa
                //Encontre esta solucion aqui a la problematica de buscar por Primary Key indistintamente del Entity trabajdo

                Root<T> root = cq.from(entityClass);
                System.out.println("Root: " + root.toString());
                //System.out.println("prueba: " + em.getEntityManagerFactory().getPersistenceUnitUtil().getIdentifier(entityClass));
                cq.select(root);
  /*          System.out.println("CQ.select ");
            SingularAttribute idAttibute = getIdAttribute(em, entityClass);
            System.out.println("Atributo: " + idAttibute);
            Path<?> pathToId = root.get(idAttibute);
            System.out.println("Path: " + pathToId);
            cq.orderBy(em.getCriteriaBuilder().desc(pathToId));*/
                //-------------------------------------------------------------------------------------------------------------
                return em.createQuery(cq).getResultList();
            } else
                return null;
        } catch (Exception e) {
            throw new Exception(e);
        } finally {
            em.clear();
            if (em != null && em.isOpen()) em.close();
        }
    }

    public T find(Object id) throws Exception {
        try {
            em = getEntityManager();
            if (em.isOpen())
                return em.find(entityClass, id);
            else
                return null;
        } catch (Exception e) {
            throw new Exception(e);
        } finally {
            em.clear();
            if (em != null && em.isOpen()) em.close();
        }
    }

    public Object edit(T entity) throws Exception {
        try {
            em = getEntityManager();

            if (em.isOpen())
                em.merge(entity);

            em.flush();

            return em.contains(entity);
        } catch (Exception e) {
            throw new Exception(e);
        } finally {
            em.clear();
            if (em != null && em.isOpen()) em.close();
        }
    }

    public Object remove(T entity) throws Exception {
        try {
            em = getEntityManager();
            if (em.isOpen())
                em.remove(em.merge(entity));
            em.flush();
            return em.contains(entity);
        } catch (Exception e) {
            throw new Exception(e);
        } finally {
            em.clear();
            if (em != null && em.isOpen()) em.close();
        }
    }

    //***********************************************************************************************
    private <T> SingularAttribute<? super T, ?> getIdAttribute(EntityManager em,
                                                               Class<T> clazz) {
        try {
            System.out.println("Metamodel: ");
            Metamodel m = em.getMetamodel();
            IdentifiableType<T> of = (IdentifiableType<T>) m.managedType(clazz);
            System.out.println("of: " + of.getIdType().getJavaType());
            System.out.println("of: " + of.getId(of.getIdType().getJavaType()));
            return of.getId(of.getIdType().getJavaType());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            System.out.println("Error2: " + e);

            return null;
        }
    }
}
