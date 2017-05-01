/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java8;

/**
 *
 * @author ahmed
 */
public class employee {
    
    private int number;
    private String username;
    private String password;
public static void print(String number){

    System.out.println("This is Number : "+number);
}
    public employee(int number, String username, String password) {
        this.number = number;
        this.username = username;
        this.password = password;
    }

    public employee() {
    }

    
    
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    
}
