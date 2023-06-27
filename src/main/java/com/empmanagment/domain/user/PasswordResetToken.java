package com.empmanagment.domain.user;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;
@Entity
public class PasswordResetToken {
    @Transient
    private static final int EXPIRY_DATE = 60*24;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "password_reset_token_id")
    private Long passwordResetTokenId;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;
    @Column
    private String token;
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    public PasswordResetToken(){
        this.date = calculateExpiryDate(EXPIRY_DATE);
    }
    public PasswordResetToken(User user,String token){
        this.user = user;
        this.token = token;
        this.date = calculateExpiryDate(EXPIRY_DATE);
    }

    private Date calculateExpiryDate(int EXPIRY_DATE) {
        Calendar calendar = Calendar.getInstance(); // cari zaman mueyyen olunur
        calendar.setTimeInMillis(new Date().getTime());
        calendar.add(Calendar.MINUTE,EXPIRY_DATE);
        return new Date(calendar.getTime().getTime());
    }

    public Long getPasswordResetTokenId() {
        return passwordResetTokenId;
    }

    public void setPasswordResetTokenId(Long passwordResetTokenId) {
        this.passwordResetTokenId = passwordResetTokenId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PasswordResetToken that = (PasswordResetToken) o;
        return passwordResetTokenId.equals(that.passwordResetTokenId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(passwordResetTokenId);
    }
}
