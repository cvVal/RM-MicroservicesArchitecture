package com.web.services.microservices.currencyexchangeservice.repository;

import com.web.services.microservices.currencyexchangeservice.model.ExchangeValue;
import org.springframework.data.repository.CrudRepository;

public interface ExchangeRepository extends CrudRepository<ExchangeValue, Long> {

    ExchangeValue findByFromAndTo(String from, String to);
}