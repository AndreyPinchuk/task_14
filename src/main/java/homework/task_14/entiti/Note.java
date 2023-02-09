package homework.task_14.entiti;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Note {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;
    @Column(name = "title")
    private String title;
    @Column(name = "content", length = 1000000)
    private String content;

}
