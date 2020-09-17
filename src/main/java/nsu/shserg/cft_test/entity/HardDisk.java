package nsu.shserg.cft_test.entity;

import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
public class HardDisk extends AbstractProduct {
    private Integer space;
}
