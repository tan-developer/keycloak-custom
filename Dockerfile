FROM quay.io/keycloak/keycloak:26.0.5

WORKDIR /opt/keycloak

ENV KEYCLOAK_ADMIN=admin
ENV KEYCLOAK_ADMIN_PASSWORD=admin

COPY /keycloak-theme.jar /opt/keycloak/providers/

ENTRYPOINT ["/opt/keycloak/bin/kc.sh", "start", "--http-enabled=true"]
