package com.driver;

public class Email {

    private String emailId;
    private String password;

    public Email(String emailId){
        this.emailId = emailId;
        this.password = "Accio@123";
    }

    public String getEmailId() {
        return emailId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void changePassword(String oldPassword, String newPassword){
        //Change password only if the oldPassword is equal to current password and the new password meets all of the following:
        // 1. It contains at least 8 characters
        // 2. It contains at least one uppercase letter
        // 3. It contains at least one lowercase letter
        // 4. It contains at least one digit
        // 5. It contains at least one special character. Any character apart from alphabets and digits is a special character
        if(getPassword().equals(oldPassword)){
            boolean l8=false;
            boolean oneUp=false;
            boolean oneLow = false;
            boolean onedig = false;
            boolean onespec = false;
            if(newPassword.length()>=8) {
                l8 = true;

                for (int i = 0; i < newPassword.length(); i++) {
                    char ch = newPassword.charAt(i);
                    if (Character.isUpperCase(ch)) {
                        oneUp = true;
                    } else if (Character.isLowerCase(ch)) {
                        oneLow = true;
                    } else if (Character.isDigit(ch)) {
                        onedig = true;
                    } else {
                        onespec = true;
                    }
                }
                if(l8&&oneUp&&oneLow&&onedig&&onespec){
                    setPassword(newPassword);
                    System.out.println("done");
                }
            }
        }
    }
}
