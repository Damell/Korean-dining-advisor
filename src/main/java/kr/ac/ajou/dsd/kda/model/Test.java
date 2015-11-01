package kr.ac.ajou.dsd.kda.model;

public class Test {

	public static void main(String[] args) {

        User u1 = new User("123","123","123");
        System.out.println(u1.getSalt());
        System.out.println(u1.getPwHashed());
        System.out.println(Creatpassword.checkPassword(u1, "123"));
        

	}

}
