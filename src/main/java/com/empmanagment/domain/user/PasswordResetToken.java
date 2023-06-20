package com.empmanagment.domain.user;

import javax.persistence.Entity;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;
@Entity
public class PasswordResetToken {
    private static final int EXPIRY_DATE = 60*24;
    private Long passwordResetTokenId;
    private User user;
    private String token;
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
