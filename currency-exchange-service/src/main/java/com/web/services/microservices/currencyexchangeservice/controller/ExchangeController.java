package com.web.services.microservices.currencyexchangeservice.controller;

import com.web.services.microservices.currencyexchangeservice.model.ExchangeValue;
import com.web.services.microservices.currencyexchangeservice.repository.ExchangeRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RequiredArgsConstructor
@RestController
public class ExchangeController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private final Environment environment;

    private final ExchangeRepository repository;

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public ExchangeValue retrieveExchangeValue(
            @PathVariable String from,
            @PathVariable String to) {

        ExchangeValue exchangeValue = repository.findByFromAndTo(from, to);

        exchangeValue.setPort(Integer.parseInt(Objects.requireNonNull(environment.getProperty("local.server.port"))));

        // example for Spring cloud sleuth
        logger.info("{}", exchangeValue);

        return exchangeValue;
    }
}