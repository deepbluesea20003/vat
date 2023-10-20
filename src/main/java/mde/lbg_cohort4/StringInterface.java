package mde.lbg_cohort4;

import java.util.Scanner;

class StringInterface implements CommonInterface{

    @Override
    public void getUserInput() {
        System.out.print(this.message);
        Scanner sc = new Scanner(System.in);
        input = sc.next();
    }

}
