
package model.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CPF;

/**
 *
 * @author Deyse
 */
@Entity
@Table(name="user_details") 
@DiscriminatorValue(value = "ud")
@PrimaryKeyJoinColumn(name="id_user_details", referencedColumnName = "id")
@NamedQueries(
        {
            @NamedQuery(
                    name = UserDetails.ALL_USER_DETAILS,
                    query = "SELECT d FROM UserDetails d"
            ),
             @NamedQuery(
                    name = UserDetails.USER_DETAILS_BY_ID,
                    query = "SELECT d FROM UserDails d WHERE d.id = ?"
            )
        }
)
public abstract class UserDetails  extends Entidade implements Serializable {

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

    public UserDetails(Long id, String photo, String passport, String rg, String cpf, int permission) {
        this.id = id;
        this.photo = photo;
        this.passport = passport;
        this.rg = rg;
        this.cpf = cpf;
        this.permission = permission;
    }

    public UserDetails() {
    }
        
        

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getPassport() {
		return passport;
	}

	public void setPassport(String passport) {
		this.passport = passport;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public int getPermission() {
		return permission;
	}

	public void setPermission(int permission) {
		this.permission = permission;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((passport == null) ? 0 : passport.hashCode());
		result = prime * result + permission;
		result = prime * result + ((photo == null) ? 0 : photo.hashCode());
		result = prime * result + ((rg == null) ? 0 : rg.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
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
		return true;
	}

	@Override
	public String toString() {
		return "UserDetails [id=" + id + ", photo=" + photo + ", passport=" + passport + ", rg=" + rg + ", cpf=" + cpf
				+ ", permission=" + permission + "]";
	}
	
	
	
}