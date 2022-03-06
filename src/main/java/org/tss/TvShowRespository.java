package org.tss;

import javax.enterprise.context.ApplicationScoped;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class TvShowRespository implements PanacheRepository<TvShow> {
    public TvShow findByTitle(String title) {
        return find("title", title).firstResult();
    }
}
