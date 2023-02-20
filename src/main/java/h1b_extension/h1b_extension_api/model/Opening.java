package h1b_extension.h1b_extension_api.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "openings")
public class Opening {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="all_openings", columnDefinition = "bigint", nullable=false)
    private int all;

    @Column(name="sponsor_openings", columnDefinition = "bigint", nullable=false)
    private int sponsored;

    public Opening(){}
    public Opening(int id, int all, int sponsored){}
}
