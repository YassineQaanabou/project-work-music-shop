package com.projectwork.shopstrumentimusicali.shop.repository;

import com.projectwork.shopstrumentimusicali.shop.model.Tipologia;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class TipologiaRepositorySessionBean implements TipologiaRepository {
private EntityManager entityManager;
@Override
    public Tipologia findBySlug(String slug){
        Tipologia tipologia = new Tipologia();
        TypedQuery<Tipologia> query = entityManager.createQuery("SELECT e FROM Tipologia e WHERE e.slug= :attrValue", Tipologia.class);
        query.setParameter("attrValue", slug);
        return query.getSingleResult();
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Tipologia> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Tipologia> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<Tipologia> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Integer> integers) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Tipologia getOne(Integer integer) {
        return null;
    }

    @Override
    public Tipologia getById(Integer integer) {
        return null;
    }

    @Override
    public Tipologia getReferenceById(Integer integer) {
        return null;
    }

    @Override
    public <S extends Tipologia> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Tipologia> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Tipologia> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Tipologia> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Tipologia> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Tipologia> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Tipologia, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends Tipologia> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Tipologia> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Tipologia> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public List<Tipologia> findAll() {
        return null;
    }

    @Override
    public List<Tipologia> findAllById(Iterable<Integer> integers) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Integer integer) {

    }

    @Override
    public void delete(Tipologia entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {

    }

    @Override
    public void deleteAll(Iterable<? extends Tipologia> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<Tipologia> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Tipologia> findAll(Pageable pageable) {
        return null;
    }
}
