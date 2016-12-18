package org.automation.bug.ws.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.swing.text.StringContent;

/**
 * Created by shantonu on 12/18/16.
 */
@Entity
public class Bug {

    @Id
    @GeneratedValue
    private Long id;

    private String title;
    private String description;

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Bug() {
    }

}
