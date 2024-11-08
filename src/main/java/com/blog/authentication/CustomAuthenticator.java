package com.blog.authentication;

import org.keycloak.authentication.AuthenticationFlowContext;
import org.keycloak.authentication.AuthenticationFlowError;
import org.keycloak.authentication.Authenticator;
import org.keycloak.authentication.authenticators.browser.UsernamePasswordFormFactory;
import org.keycloak.models.KeycloakSession;
import org.keycloak.models.RealmModel;
import org.keycloak.models.UserModel;
import org.keycloak.services.managers.AuthenticationManager;
import org.keycloak.services.messages.Messages;

import jakarta.ws.rs.core.MultivaluedMap;
import jakarta.ws.rs.core.Response;
public class CustomAuthenticator implements Authenticator {

    @Override
    public void authenticate(AuthenticationFlowContext context) {
        // Retrieve form data
        MultivaluedMap<String, String> formData = context.getHttpRequest().getDecodedFormParameters();
        String username = formData.getFirst(AuthenticationManager.FORM_USERNAME);
        String password = formData.getFirst("password");
        String branchCode = formData.getFirst("branchCode");

        // Implement custom authentication logic
        if (isValidUser(username, password, branchCode)) {
            UserModel user = context.getSession().users().getUserByUsername(context.getRealm(), username);
            context.setUser(user);
            context.success();
        } else {
            Response challenge = context.form()
                .setError(Messages.INVALID_USER)
                        .createLoginPassword();
            context.failureChallenge(AuthenticationFlowError.INVALID_USER, challenge);
        }
    }

    private boolean isValidUser(String username, String password, String branchCode) {
        // Implement validation logic, e.g., database lookup
        return true; // Placeholder
    }

    @Override
    public void action(AuthenticationFlowContext context) {
    }

    @Override
    public boolean requiresUser() {
        return false;
    }

    @Override
    public boolean configuredFor(KeycloakSession keycloakSession, RealmModel realmModel, UserModel userModel) {
        return false;
    }


    @Override
    public void setRequiredActions(KeycloakSession session, RealmModel realm, UserModel user) {
    }

    @Override
    public void close() {
    }
}
