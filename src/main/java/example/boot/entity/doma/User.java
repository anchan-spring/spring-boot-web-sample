package example.boot.entity.doma;

import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "user")
@Getter
@Setter
public class User {

  @Id
  private String userId;

  private String firstName;

  private String lastName;

}
