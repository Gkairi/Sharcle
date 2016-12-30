package com.ca.innovate.controller.model;

import com.oracle.webservices.internal.api.databinding.Databinding;

import java.io.Serializable;

/**
 * Created by talma07 on 12/28/2016.
 */
public class UserDetails {

    private Integer id;
    private String displayName;
    private String email;
    private String commercialUser;

    public String getDisplayName() {
        return displayName;
    }
    public String getEmail() {
        return email;
    }
    public String getCommercialUser() {
        return commercialUser;
    }
    public Integer getId() {
        return id;
    }

    public UserDetails(Builder builder ) {
        this.displayName = builder.displayName;
        this.email=builder.email;
        this.commercialUser=builder.commercialUser;
        this.id = builder.email.hashCode();
    }

    public static UserDetails dummy() {
        UserDetails.Builder userBuilder = new UserDetails.Builder();
        userBuilder.commercialUser("false");
        userBuilder.email("email@test.com");
        userBuilder.displayName("test");
        return userBuilder.build();
    }



    public  static class  Builder {

        private Integer id;
        private String displayName;
        private String email;
        private String commercialUser;

        public Integer getId() {
            return id;
        }

        public void id(Integer id) {
            this.id = id;
        }

        public UserDetails build() {
            return new UserDetails(this);
        }


        public Builder displayName(String displayName) {
            this.displayName = displayName;
            return this;

        }


        public Builder email(String email) {
            this.email = email;
            return this;
        }


        public Builder commercialUser(String commercialUser) {
            this.commercialUser = commercialUser;
            return this;
        }
    }
}
