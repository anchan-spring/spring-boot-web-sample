package example.boot.form;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EchoForm implements Serializable {

  private static final long serialVersionUID = 1L;

  private String ftext;
}
