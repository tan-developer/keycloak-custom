package com.blog.authentication;

import org.keycloak.Config;
import org.keycloak.authentication.Authenticator;
import org.keycloak.authentication.AuthenticatorFactory;
import org.keycloak.models.AuthenticationExecutionModel.Requirement;
import org.keycloak.models.KeycloakSession;
import org.keycloak.models.KeycloakSessionFactory;
import org.keycloak.provider.ProviderConfigProperty;

import java.util.List;

public class CustomAuthenticatorFactory implements AuthenticatorFactory {

    public static final String PROVIDER_ID = "custom-authenticator";

    @Override
    public Authenticator create(KeycloakSession session) {
        return new CustomAuthenticator();
    }

    @Override
    public void init(Config.Scope config) {
        // Initialization logic
    }

    @Override
    public void postInit(KeycloakSessionFactory factory) {
        // Post-initialization logic
    }

    @Override
    public void close() {
        // Cleanup resources
    }

    @Override
    public String getId() {
        return PROVIDER_ID;
    }

    @Override
    public String getDisplayType() {
        return "Custom Authenticator";
    }

    @Override
    public String getReferenceCategory() {
        return "";
    }

    @Override
    public String getHelpText() {
        return "Custom authenticator with additional parameters.";
    }

    @Override
    public List<ProviderConfigProperty> getConfigProperties() {
        return List.of();
    }

    @Override
    public boolean isConfigurable() {
        return false;
    }

    @Override
    public Requirement[] getRequirementChoices() {
        return new Requirement[]{Requirement.REQUIRED, Requirement.ALTERNATIVE, Requirement.DISABLED};
    }

    @Override
    public boolean isUserSetupAllowed() {
        return false;
    }
}
