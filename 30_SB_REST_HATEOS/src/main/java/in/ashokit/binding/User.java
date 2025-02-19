package in.ashokit.binding;

import org.springframework.hateoas.RepresentationModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
//(RepresentationModel) is base class for DTOs to collect the links
public class User extends RepresentationModel<User>{

	private Integer id;
	private String name;
	private String email;
}
