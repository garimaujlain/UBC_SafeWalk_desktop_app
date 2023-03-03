package ui;

import model.Scheduler;
import model.Volunteer;
import model.User;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;


public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Volunteer volunteer = new Volunteer();
        Scheduler scheduler = new Scheduler();
        User user = new User();
        int input;


        while (true) {
            System.out.println("Hello, Welcome to SafeWalk!");

            System.out.println("Are you:");
            System.out.println("1. A volunteer");
            System.out.println("2. A Client");
            System.out.println("3. Quit");
            input = Integer.parseInt(scanner.nextLine());

            if (input == 1) {
                goVolunteer(scanner, volunteer, scheduler, user);

            }
            if (input == 2) {
                goClient(scanner, volunteer, scheduler, user);

            }
            if (input == 3) {
                System.out.println("Leaving so soon? We will miss you. Stay safe, goodbye!");
                break;

            }
        }
    }


    @SuppressWarnings({"checkstyle:MethodLength", "checkstyle:SuppressWarnings"})
    private static void goVolunteer(Scanner scanner, Volunteer volunteer, Scheduler scheduler, User user) {

        List<Boolean> temp = new ArrayList<>();

        String input;
        while (true) {

            System.out.println("Hello, Welcome to SafeWalk! Are you a new volunteer?(y/n)");
            input = scanner.nextLine();
            if (input.equalsIgnoreCase("y")) {
                System.out.println("We are excited to have you on our team! Please fill out the following details: ");
                System.out.println("Your name:");
                input = scanner.nextLine();
                String name = input;

                System.out.println("Your age:");
                input = scanner.nextLine();
                int age = Integer.parseInt(input);

                System.out.println("Your gender: (press NA if you prefer not to say)");
                input = scanner.nextLine();
                String gender = input;

                System.out.println("Your availability:");
                System.out.println("Are you available on Monday (y/n)");
                input = scanner.nextLine();
                String mon = input;
                if (mon.equalsIgnoreCase("y")) {
                    temp.add(true);
                } else {
                    temp.add(false);
                }


                System.out.println("Are you available on Tuesday (y/n)");
                input = scanner.nextLine();
                String tue = input;
                if (tue.equalsIgnoreCase("y")) {
                    temp.add(true);
                } else {
                    temp.add(false);
                }


                System.out.println("Are you available on Wednesday (y/n)");
                input = scanner.nextLine();
                String wed = input;
                if (wed.equalsIgnoreCase("y")) {
                    temp.add(true);
                } else {
                    temp.add(false);
                }


                System.out.println("Are you available on Thurday (y/n)");
                input = scanner.nextLine();
                String thu = input;
                if (thu.equalsIgnoreCase("y")) {
                    temp.add(true);
                } else {
                    temp.add(false);
                }


                System.out.println("Are you available on Fridat (y/n)");
                input = scanner.nextLine();
                String fri = input;
                if (fri.equalsIgnoreCase("y")) {
                    temp.add(true);
                } else {
                    temp.add(false);
                }


                System.out.println("Are you available on Saturday (y/n)");
                input = scanner.nextLine();
                String sat = input;
                if (sat.equalsIgnoreCase("y")) {
                    temp.add(true);
                } else {
                    temp.add(false);
                }


                System.out.println("Are you available on Sunday (y/n)");
                input = scanner.nextLine();
                String sun = input;
                if (sun.equalsIgnoreCase("y")) {
                    temp.add(true);
                } else {
                    temp.add(false);
                }
                System.out.println("Congratulation! you have been added to our system"
                        + ". We are happy to have you on our team. Stay safe!");

                Volunteer x = new Volunteer(name, age, gender, temp);
                scheduler.addVolunteer(x);

                goBackMainMenu(scanner, volunteer, scheduler, user);

            } else {

                goCurrentVolunteer(scanner, volunteer, scheduler, user);
            }
        }

    }



    private static void goCurrentVolunteer(Scanner scanner, Volunteer volunteer, Scheduler scheduler, User user) {


        int input;


        while (true) {
            System.out.println("Hello, welcome back to SafeWalk!");
            System.out.println("What can we do for you today:");
            System.out.println("1. Got free time? Add availability in one click!");
            System.out.println("2. Something came up? Delete availability in one click!");
            System.out.println("3. Made an error in personal information? Edit in one click!");
            System.out.println("4. Wrong Selection? quit here.");
            input = Integer.parseInt(scanner.nextLine());

            if (input == 1) {
                addSlot(scanner, scheduler, user);

            }
            if (input == 2) {
                deleteSlot(scanner, scheduler, user);

            }
            if (input == 3) {
                editInfo(scanner, volunteer, scheduler, user);

            }

            if (input == 4) {
                System.out.println("Leaving so soon? We will miss you. Stay safe, goodbye!");
                goBackMainMenu(scanner, volunteer, scheduler, user);

            }

        }
    }


    private static void editInfo(Scanner scanner, Volunteer volunteer, Scheduler scheduler, User user) {
        int input;
        while (true) {
            System.out.println("Made an error in Personal information? edit now");
            System.out.println("What do you want to edit?");
            System.out.println("1. Name");
            System.out.println("2. Age");
            System.out.println("3. Gender");
            System.out.println("4. Wrong Selection? quit here.");
            input = Integer.parseInt(scanner.nextLine());
            if (input == 1) {
                editName(scanner, scheduler, user);

            }
            if (input == 2) {
                editAge(scanner, scheduler, user);

            }
            if (input == 3) {
                editGender(scanner, volunteer, scheduler, user);

            }
            if (input == 4) {
                System.out.println("Leaving so soon? We will miss you. Stay safe, goodbye!");
                goBackMainMenu(scanner, volunteer, scheduler, user);

            }
        }
    }

    private static void editGender(Scanner scanner, Volunteer volunteer, Scheduler scheduler, User user) {
        String input;

        while (true) {
            System.out.println("Enetered the wrong gender? not to worry, change it one click!");
            System.out.println("Please enter your name:");
            input = scanner.nextLine();

            String name = input;

            volunteer = Scheduler.findVolunteer(name);
            System.out.println("Please mention the corrected gender");
            input = scanner.nextLine();

            String temp = input;

            Volunteer.newGender(volunteer, temp);

            System.out.println("Gender editted successfully");
            goBackMainMenu(scanner, volunteer, scheduler, user);

        }

    }

    private static void editAge(Scanner scanner, Scheduler scheduler, User user) {

        String input;


        while (true) {
            System.out.println("Enetered the wrong age? not to worry, change it one click!");
            System.out.println("Please enter your name:");
            input = scanner.nextLine();

            String name = input;

            Volunteer volunteer = Scheduler.findVolunteer(name);
            System.out.println("Please mention the corrected age");
            input = scanner.nextLine();

            Integer temp = Integer.valueOf(input);

            Volunteer.newAge(volunteer, temp);

            System.out.println("Age editted successfully");
            goBackMainMenu(scanner, volunteer, scheduler, user);

        }
    }

    public static void editName(Scanner scanner, Scheduler scheduler, User user) {
        String input;

        while (true) {
            System.out.println("Enetered the wrong name? not to worry, change it one click!");
            System.out.println("Please enter your old name:");
            input = scanner.nextLine();

            String name = input;

            Volunteer volunteer = Scheduler.findVolunteer(name);
            System.out.println("Please mention the corrected name");
            input = scanner.nextLine();

            String temp = input;

            Volunteer.newName(volunteer, temp);

            System.out.println("Name editted successfully");
            goBackMainMenu(scanner, volunteer, scheduler, user);

        }

    }

    public static void deleteSlot(Scanner scanner, Scheduler scheduler, User user) {
        String input;
        while (true) {
            System.out.println("Something came up? delete your availability in one click!");
            System.out.println("Please enter your name:");
            input = scanner.nextLine();

            String name = input;

            Volunteer volunteer = Scheduler.findVolunteer(name);
            System.out.println("Please add the day of week you are not available:");
            input = scanner.nextLine();

            String day = input;

            volunteer.deleteDay(volunteer, day);


            System.out.println("Shift deleted successfully");
            goBackMainMenu(scanner, volunteer, scheduler, user);

        }
    }

    public static void addSlot(Scanner scanner, Scheduler scheduler, User user) {
        String input;
        while (true) {
            System.out.println("We are happy you want to add more shifts! you can do so in one click!");
            System.out.println("Please enter  name:");
            input = scanner.nextLine();

            String name = input;

            Volunteer volunteer = Scheduler.findVolunteer(name);


            System.out.println("Please add the day of week you are available:");
            input = scanner.nextLine();

            String day = input;

            assert volunteer != null;
            volunteer.addDay(volunteer, day);


            System.out.println("Shift added successfully");
            goBackMainMenu(scanner, volunteer, scheduler, user);

        }
    }


    public static void goClient(Scanner scanner, Volunteer volunteer, Scheduler scheduler, User user) {

        int input;

        while (true) {
            System.out.println("Something came up? don't worry, delete your shift in one click. ");

            System.out.println("1. Get a volunteer to walk you home safely");
            System.out.println("2. Quit");
            input = Integer.parseInt(scanner.nextLine());

            if (input == 1) {
                pickVolunteer(scanner, volunteer, scheduler, user);

            }
            if (input == 2) {
                System.out.println("Leaving so soon? We will miss you. Stay safe, goodbye!");
                goBackMainMenu(scanner, volunteer, scheduler, user);

            }
        }
    }

    public static void pickVolunteer(Scanner scanner, Volunteer volunteer, Scheduler scheduler, User user) {
        String input;
        while (true) {
            System.out.println("Your name:");
            input = scanner.nextLine();
            String name = input;

            System.out.println("Your age:");
            input = scanner.nextLine();
            Integer age = Integer.valueOf(input);

            System.out.println("Your gender:");
            input = scanner.nextLine();
            String gender = input;

            System.out.println("Type the day you need a Volunteer:");
            input = scanner.nextLine();
            String day = input;

            List<String> temp = Scheduler.onDuty(day);
            System.out.println(temp);

            System.out.println("Choose your Volunteer:");
            input = scanner.nextLine();
            String volun = input;

            // User.updateUser(name, age, gender, volun);
            System.out.println("You have successfully been assigned to" + volun);
            goBackMainMenu(scanner, volunteer, scheduler, user);


        }
    }

    private static void goBackMainMenu(Scanner scanner, Volunteer volunteer, Scheduler scheduler, User user) {

        int input;

        while (true) {
            System.out.println("Hello, Welcome to SafeWalk!");

            System.out.println("Are you:");
            System.out.println("1. A volunteer");
            System.out.println("2. A Client");
            System.out.println("3. Quit");
            input = Integer.parseInt(scanner.nextLine());

            if (input == 1) {
                goVolunteer(scanner, volunteer, scheduler, user);

            }
            if (input == 2) {
                goClient(scanner, volunteer, scheduler, user);

            }
            if (input == 3) {
                System.out.println("Leaving so soon? We will miss you. Stay safe, goodbye!");

            }

        }
    }

}








