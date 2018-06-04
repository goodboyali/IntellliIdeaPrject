package Ali.Study.Entities.PakEntity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity(name="Users")
public class Users {

    public Users() {
    }

    @Id //主键
    private String USR_ID;

    @Column(insertable = true,length = 20,nullable = true,name = "USR_NAME",unique = false,updatable = true)
    private String USR_NAME;

    @Column(insertable = true,nullable = true,name = "SYS_DATE",unique = false,updatable = true)
    private Date SYS_DATE;

    public String getUSR_ID() {
        return USR_ID;
    }

    public void setUSR_ID(String USR_ID) {
        this.USR_ID = USR_ID;
    }

    public String getUSR_NAME() {
        return USR_NAME;
    }

    public void setUSR_NAME(String USR_NAME) {
        this.USR_NAME = USR_NAME;
    }

    public Date getSYS_DATE() {
        return SYS_DATE;
    }

    public void setSYS_DATE(Date SYS_DATE) {
        this.SYS_DATE = SYS_DATE;
    }
}
