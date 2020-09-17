package nsu.shserg.cft_test.entity;

import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
public class DesktopComputer extends AbstractProduct{
    private String formFactor;
}
