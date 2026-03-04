package practice.practice5;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name ="books")

@AllArgsConstructor
@NoArgsConstructor
@Data

public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bno;


    @Column(name="bid", length = 255, nullable = false)
    private String bid;

    @Column(name="bname", length = 255, nullable = false)
    private String bname;

    @Column(name="bwriter", length = 255, nullable = false)
    private String bwriter;

    @Column(name="bpublisher", length = 255, nullable = false)
    private String bpublisher;


}
