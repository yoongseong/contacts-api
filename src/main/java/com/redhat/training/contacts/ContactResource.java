package com.redhat.training.contacts;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("contacts")
@ApplicationScoped
@Produces("application/json")
@Consumes("application/json")
public class ContactResource {

    @Inject
    EntityManager entityManager;

    @GET
    public List<Contact> getContacts() {
        return entityManager.createNamedQuery("Contact.findAll", Contact.class).getResultList();
    }
}