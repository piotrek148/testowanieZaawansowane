package pl.sda.bootcamp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@AllArgsConstructor
@Data
@Builder
public class Trainer {
    private Long id;
    private String firstName;
    private String lastName;
    private BigDecimal hourlyRate;
}
