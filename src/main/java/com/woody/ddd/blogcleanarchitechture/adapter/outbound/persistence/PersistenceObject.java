package com.woody.ddd.blogcleanarchitechture.adapter.outbound.persistence;

public interface PersistenceObject<T> {
    T toDomainModel();
}
