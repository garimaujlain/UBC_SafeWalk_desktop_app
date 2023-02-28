package ui;

import model.Scheduler;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Scheduler;
import model.Volunteer;
import model.User;




public class printMenuConsoleUi {

    private final Scanner scanner = new Scanner(System.in);
    private Scheduler scheduler;
    private Volunteer volunteer;

    public printMenuConsoleUi(Scheduler scheduler, Volunteer volunteer) {
        this.scheduler = scheduler;
        this.volunteer = volunteer;
    }

    public printMenuConsoleUi() {

    }


    private void start() {
        System.out.println("Hello, Welcome to SafeWalk!");
        boolean exit = false;
        while (!exit) {
            System.out.println("Are you:");
            System.out.println("1. A volunteer");
            System.out.println("2. A Client");
            System.out.println("3. Quit");
            int choice = getIntInput();
            switch (choice) {
                case 1:
                    goVolunteer();
                    break;
                case 2:
                    goClient();
                    break;
                case 3:
                    System.out.println("Leaving so soon? We will miss you. Stay safe, goodbye!");
                    break;
                default:
                    System.out.println("Oops! you seem to have made an invalid choice, try again!");
                    break;
            }
        }
    }

    private void goVolunteer() {

        List<Boolean> temp = new ArrayList<>();

        System.out.println("Hello, Welcome to SafeWalk! Are you a new volunteer?(y/n)");
        String input = getStringInput();
        if (input.equalsIgnoreCase("y")) {
            System.out.println("We are excited to have you on our team! Please fill out the following details: ");
            System.out.println("Your name:");
            String name = getStringInput();
            System.out.println("Your age:");
            Integer age = getIntInput();
            System.out.println("Your gender: (press NA if you prefer not to say)");
            String gender = getStringInput();
            System.out.println("Your availability:");
            System.out.println("Are you available on Monday (y/n)");
            String mon = getStringInput();
            if (mon.equalsIgnoreCase("y")) {
                temp.add(true);
            } else {
                temp.add(false);
            }
            System.out.println("Are you available on Tuesday (y/n)");
            String tue = getStringInput();
            if (tue.equalsIgnoreCase("y")) {
                temp.add(true);
            } else {
                temp.add(false);
            }
            System.out.println("Are you available on Wednesday (y/n)");
            String wed = getStringInput();
            if (wed.equalsIgnoreCase("y")) {
                temp.add(true);
            } else {
                temp.add(false);
            }
            System.out.println("Are you available on Thursday (y/n)");
            String thur = getStringInput();
            if (thur.equalsIgnoreCase("y")) {
                temp.add(true);
            } else {
                temp.add(false);
            }
            System.out.println("Are you available on Friday (y/n)");
            String fri = getStringInput();
            if (fri.equalsIgnoreCase("y")) {
                temp.add(true);
            } else {
                temp.add(false);
            }
            System.out.println("Are you available on Saturday (y/n)");
            String sat = getStringInput();
            if (sat.equalsIgnoreCase("y")) {
                temp.add(true);
            } else {
                temp.add(false);
            }
            System.out.println("Are you available on Sunday (y/n)");
            String sun = getStringInput();
            if (sun.equalsIgnoreCase("y")) {
                temp.add(true);
            } else {
                temp.add(false);
            }
            Volunteer temp2 = new Volunteer(name, age, gender, temp);
            scheduler.addVolunteer(temp2);

            System.out.println("Congratulation! you have been added to our system. We are happy to have you on our team. Stay safe!");
        } else {
            goCurrentVolunteer();
        }
    }

    private void goCurrentVolunteer() {



        while (true) {
            System.out.println("Hello, welcome back to SafeWalk!");
            System.out.println("What can we do for you today:");
            System.out.println("1. Got free time? Add availability in one click!");
            System.out.println("2. Something came up? Delete availability in one click!");
            System.out.println("3. Made an error in personal information? Edit in one click!");
            System.out.println("4. Wrong Selection? quit here.");
            int choice = getIntInput();
            switch (choice) {
                case 1:
                    addSlot();
                    break;
                case 2:
                    deleteSlot();
                    break;
                case 3:
                    editInfo();
                    break;
                case 4:
                    System.out.println("Leaving so soon? We will miss you. Stay safe, goodbye!");
                    break;
                default:
                    System.out.println("Oops! you seem to have made an invalid choice, try again!");
                    break;
            }
        }
    }

    private void addSlot() {

        while (true) {
            System.out.println("Hello, we are happy you want to put in more hours!");
            System.out.println("Please enter your name:");
            String name = getStringInput();
            Volunteer volunteer = Scheduler.findVolunteer(name);
            System.out.println("Please add the day of week you are available:");
            String day = getStringInput();
            Volunteer.addDay(volunteer, day);


            System.out.println("Shift added successfully");

        }
    }


    private void deleteSlot() {

        while (true) {
            System.out.println("Something came up? delete your availability in one click!");
            System.out.println("Please enter your name:");
            String name = getStringInput();
            Volunteer volunteer = Scheduler.findVolunteer(name);
            System.out.println("Please mention the day of week you are not available:");
            String day = getStringInput();
            Volunteer.deleteDay(volunteer, day);


            System.out.println("Shift deleted successfully");

        }
    }


    private void editInfo() {

        while (true) {
            System.out.println("Made an error in Personal information? edit now");
            System.out.println("What do you want to edit?");
            System.out.println("1. Name");
            System.out.println("2. Age");
            System.out.println("3. Gender");
            System.out.println("4. Wrong Selection? quit here.");
            int choice = getIntInput();
            switch (choice) {
                case 1:
                    editName();
                    break;
                case 2:
                    editAge();
                    break;
                case 3:
                    editGender();
                    break;
                case 4:
                    System.out.println("Leaving so soon? We will miss you. Stay safe, goodbye!");
                    break;
                default:
                    System.out.println("Oops! you seem to have made an invalid choice, try again!");
                    break;
            }
        }
    }



    private void editName() {

        while (true) {
            System.out.println("Enetered the wrong name? not to worry, change it one click!");
            System.out.println("Please enter your old name:");
            String name = getStringInput();
            Volunteer volunteer = Scheduler.findVolunteer(name);
            System.out.println("Please mention the corrected name");
            String temp = getStringInput();
            Volunteer.newName(volunteer, temp);

            System.out.println("Name editted successfully");

        }
    }

    private void editAge() {

        while (true) {
            System.out.println("Enetered the wrong age? not to worry, change it one click!");
            System.out.println("Please enter your name:");
            String name = getStringInput();
            Volunteer volunteer = Scheduler.findVolunteer(name);
            System.out.println("Please mention the corrected age");
            Integer temp = getIntInput();
            Volunteer.newAge(volunteer, temp);

            System.out.println("Age editted successfully");

        }
    }

    private void editGender() {

        while (true) {
            System.out.println("Enetered the wrong gender? not to worry, change it one click!");
            System.out.println("Please enter your name:");
            String name = getStringInput();
            Volunteer volunteer = Scheduler.findVolunteer(name);
            System.out.println("Please mention the corrected gender");
            String temp = getStringInput();
            Volunteer.newGender(volunteer, temp);

            System.out.println("Age editted successfully");

        }
    }

    private void goClient() {


        while (true) {
            System.out.println("Hello, Welcome to SafeWalk! What can we do for you today?");

            System.out.println("1. Get a volunteer to walk you home safely");
            System.out.println("2. Quit");

            int num = getIntInput();

            switch (num) {
                case 1:
                    pickVolunteer();
                    break;

                case 2:
                    System.out.println("Leaving so soon? We will miss you. Stay safe, goodbye!");
                    break;
                default:
                    System.out.println("Oops! you seem to have made an invalid num, try again!");
                    break;
            }
        }
    }

    private void pickVolunteer() {

        System.out.println("Your name:");
        String name = getStringInput();
        System.out.println("Your age:");
        Integer age = getIntInput();
        System.out.println("Your gender: (press NA if you prefer not to say)");
        String gender = getStringInput();
        System.out.println("Type the day you need a Volunteer:");
        String temp = getStringInput();
        Scheduler.onDuty(temp);
        System.out.println("Choose your Volunteer:");
        String temp1 = getStringInput();

        // User.updateUser(name, age, gender, temp1);
        System.out.println("You have successfully been assigned to" + temp1);


    }


    private int getIntInput() {
        while (true) {
            try {
                String input = scanner.nextLine();
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input, please enter a number");
            }
        }
    }

    private String getStringInput() {
        return scanner.nextLine();
    }




}






