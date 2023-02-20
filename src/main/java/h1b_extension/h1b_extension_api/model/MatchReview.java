package h1b_extension.h1b_extension_api.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
@Table(name = "match_review")
public class MatchReview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String uscis;

    @Column(name="job_board")
    private int jobboard;

    @Column(name="alternate_name")
    private String alternatename;

    @ManyToOne
    @JoinColumn(name="uscis_id", nullable=false)
    private H1BRecord uscisid;

    @Column
    private int country;

    @Column(columnDefinition = "TINYINT", length=1)
    private boolean confirmation;

    @Column(columnDefinition = "TINYINT", length=1)
    private boolean reviewed;

    public MatchReview(){}
    public MatchReview(String uscis, Integer job_board, String alternate_name, H1BRecord uscis_id, Boolean confirmation, Boolean reviewed){

    }
    
}
