package pe.edu.upc.documentationmanagement.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {

    private Long Id;
    private String Name;
    private String Namehospital;
    private String Namearea;
    private String Namerol;
    private String Typedoc;
    private String Numdoc;
    private String Phone;
    private String Email;
    private String password;
}
