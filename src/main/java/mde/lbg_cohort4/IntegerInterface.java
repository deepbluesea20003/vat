package mde.lbg_cohort4;

import java.util.Scanner;

class IntegerInterface implements CommonInterface {

    private String message;

    @Override
    public void getUserInput() {
        Scanner sc = new Scanner(System.in);

        do {
            System.out.print(this.message);
            String rawUserInput = sc.next();
            try {
                input = Integer.parseInt(rawUserInput);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input, please try again");
            }
        } while (input == null);
    }

    @Override
    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }

}