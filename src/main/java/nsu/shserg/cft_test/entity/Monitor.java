package nsu.shserg.cft_test.entity;

import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
public class Monitor extends AbstractProduct {
    private Integer diagonal;
}
