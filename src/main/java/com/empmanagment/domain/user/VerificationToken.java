package com.empmanagment.domain.user;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;
@Entity
@Table(name = "VerificationToken")
public class VerificationToken {
    @Transient
    private static final int EXPIRY_DATE = 60*24;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long verificationTokenId;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;
    @Column
    private String token;
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    public VerificationToken(){
        this.date = calculateExpiryDate(EXPIRY_DATE);
    }
    public VerificationToken(User user,String token){
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

    public Long getVerificationTokenId() {
        return verificationTokenId;
    }

    public void setVerificationTokenId(Long verificationTokenId) {
        this.verificationTokenId = verificationTokenId;
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
        VerificationToken that = (VerificationToken) o;
        return verificationTokenId.equals(that.verificationTokenId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(verificationTokenId);
    }
}
