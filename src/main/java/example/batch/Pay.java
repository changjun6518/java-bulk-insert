package example.batch;

import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
public class Pay {
    @Id
    @GeneratedValue(
            strategy = GenerationType.TABLE
            , generator = "GENERATOR_NAME")
    @TableGenerator(
            name = "GENERATOR_NAME",
            table = "sequence_table",
            pkColumnName = "sequence_name",
            valueColumnName = "next_val",
            allocationSize = 1000
    )
    private Long id;



    private Integer count;

    public Pay(Integer count) {
        this.count = count;
    }

    public Pay(Long id, Integer count) {
        this.id = id;
        this.count = count;
    }
}
