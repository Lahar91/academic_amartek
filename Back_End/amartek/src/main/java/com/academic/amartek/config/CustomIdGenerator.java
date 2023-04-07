package com.academic.amartek.config;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class CustomIdGenerator implements IdentifierGenerator {
    private static final String PREFIX = "USR";
    private static final AtomicInteger counter = new AtomicInteger(0);

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
        Integer id = counter.incrementAndGet();
        return PREFIX + String.format("%06d", id);
    }
}