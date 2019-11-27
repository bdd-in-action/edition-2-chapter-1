package com.manning.bddinaction.stepdefinitions;

import com.manning.bddinaction.banking.AccountType;
import com.manning.bddinaction.banking.Client;
import cucumber.api.TypeRegistry;
import cucumber.api.TypeRegistryConfigurer;
import io.cucumber.cucumberexpressions.ParameterType;
import io.cucumber.cucumberexpressions.Transformer;

import java.util.Locale;

import static java.util.Locale.ENGLISH;

public class TypeRegistryConfiguration implements TypeRegistryConfigurer {

    @Override
    public Locale locale() {
        return ENGLISH;
    }

    @Override
    public void configureTypeRegistry(TypeRegistry typeRegistry) {
        typeRegistry.defineParameterType(new ParameterType<>(
            "accountType",
            "(.*)",
            AccountType.class,
            (Transformer<AccountType>) AccountType::valueOf)
        );

        typeRegistry.defineParameterType(new ParameterType<>(
                "client",
                "(.*)",
                Client.class,
                Client::new)
        );

    }
}