
package model.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 * @author Deyse
 */
@Entity
@Table(name="TB_USER_DETAILS") 
@NamedQueries(
        {
            @NamedQuery(
                    name = UserDetails.ALL_USER_DETAILS,
                    query = "SELECT d FROM UserDetails d"
            ),
             @NamedQuery(
                    name = UserDetails.USER_DETAILS_BY_ID,
                    query = "SELECT d FROM UserDetails d WHERE d.id = ?1"
            )
        }
)
public class UserDetails  extends Entidade implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6878819548775036147L;
    public static final String ALL_USER_DETAILS = "All_User_Deatils";
    public static final String USER_DETAILS_BY_ID= "User_Details_By_Id";
	@Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;
	
	@Column(name="photo")
	protected String photo;
	
	@NotBlank
	@Column(name="passport")
	protected String passport;
	
	@NotBlank
	@Column(name="rg")
	protected String rg;
	
	@NotBlank
	@CPF
	@Column(name="cpf")
	protected String cpf;
	
	@NotBlank
	@Column(name="permission")
	protected int permission;
	
	@JoinColumn(name = "userId", insertable = false, updatable = false)
    @OneToOne(targetEntity = UserSuper.class, fetch = FetchType.LAZY)
    @JsonIgnore
    private UserSuper user;

    @Column(name = "userId", insertable = true, updatable = true)
    private Long userId;

	public UserDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((passport == null) ? 0 : passport.hashCode());
		result = prime * result + permission;
		result = prime * result + ((photo == null) ? 0 : photo.hashCode());
		result = prime * result + ((rg == null) ? 0 : rg.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserDetails other = (UserDetails) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (passport == null) {
			if (other.passport != null)
				return false;
		} else if (!passport.equals(other.passport))
			return false;
		if (permission != other.permission)
			return false;
		if (photo == null) {
			if (other.photo != null)
				return false;
		} else if (!photo.equals(other.photo))
			return false;
		if (rg == null) {
			if (other.rg != null)
				return false;
		} else if (!rg.equals(other.rg))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UserDetails [id=" + id + ", photo=" + photo + ", passport=" + passport + ", rg=" + rg + ", cpf=" + cpf
				+ ", permission=" + permission + ", user=" + user + ", userId=" + userId + "]";
	}

  

}