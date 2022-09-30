package io.quantics.multitenant.tenantdetails;

import java.util.Optional;

/**
 * Core interface which loads tenant-specific data.
 *
 * <p>
 *     This service is used in multi-tenant applications for loading a tenant by a given issuer.
 * </p>
 *
 * @see TenantDetails
 */
public interface TenantDetailsService {

    Iterable<? extends TenantDetails> getAll();

    Optional<? extends TenantDetails> getById(String id);

    Optional<? extends TenantDetails> getByIssuer(String issuer);

}
