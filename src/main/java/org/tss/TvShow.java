package org.tss;

import javax.persistence.Entity;
import javax.persistence.Table;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
@Table(name="tv_show")
public class TvShow extends PanacheEntity {
    public String title;
    public Boolean completed;    
}
