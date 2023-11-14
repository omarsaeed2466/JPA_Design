package com.example.JPA_Design.Entity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Arrays;

@Entity
@Table
@Getter
@Setter
@JsonDeserialize(using = StringtoByteArray.class)
public class Files {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @JsonDeserialize(using = StringtoByteArray.class)
    @Column(name = "binary")
    @Lob
    private byte[] binary;

    @OneToOne(optional = false)

    private Item item;

    @Override
    public String toString() {
        return "Files{" +
                "id=" + id +
                ", binary=" + Arrays.toString(binary) +
                '}';
    }
}
