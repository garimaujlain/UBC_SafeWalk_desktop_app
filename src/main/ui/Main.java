package ui;

import model.Scheduler;
import model.Volunteer;
import model.User;
import org.json.JSONException;
import persistence.SchedulerJsonReader;
import persistence.SchedulerJsonWriter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;


public class Main {


    @SuppressWarnings({"checkstyle:MethodLength", "checkstyle:SuppressWarnings"})
    public static void main(String[] args) throws
            JSONException, IOException {
        Scanner scanner = new Scanner(System.in);
        Volunteer volunteer = new Volunteer();
        Scheduler scheduler = new Scheduler();
        User user = new User();
        int input;


        while (true) {

            //prints main menu with options to choose from
            System.out.println("Hello, Welcome to SafeWalk!");


            System.out.println("1. Are you a volunteer");
            System.out.println("2. Are you: a Client");
            System.out.println("3. Load app");
            System.out.println("4. Save app");
            System.out.println("5. Quit");

            input = Integer.parseInt(scanner.nextLine());

            if (input == 1) {

                //goes to volunteer side of the application if input is 1
                goVolunteer(scanner, volunteer, scheduler, user);

            }
            if (input == 2) {

                //goes to user/client side of the application if input is 1
                goClient(scanner, volunteer, scheduler, user);

            }
            if (input == 3) {

                //quits application
                loadApp(scheduler);

            }
            if (input == 4) {

                //quits application
                saveApp(scheduler);

            }
            if (input == 5) {

                //quits application
                System.out.println("Leaving so soon? We will miss you. Stay safe, goodbye!");
                break;

            }
        }
    }

    private static void saveApp(Scheduler scheduler) throws JSONException, IOException {
        try {
            SchedulerJsonWriter.write(scheduler, "./data/temp.json");
            System.out.println("Session saved!");
            System.exit(0);
        } catch (IOException e) {
            System.out.println("Error saving session");
            System.exit(0);
        }
    }

    // MODIFIES: this
    // EFFECTS: loads cookbook from file
    private static void loadApp(Scheduler scheduler) throws JSONException {
        try {
            scheduler = SchedulerJsonReader.read("./data/temp.json");
            System.out.println("Session loaded");
            System.exit(0);
        } catch (IOException e) {
            System.out.println("Error loading cookbook session");
            System.exit(0);
        }
    }


    @SuppressWarnings({"checkstyle:MethodLength", "checkstyle:SuppressWarnings"})
    private static void goVolunteer(Scanner scanner, Volunteer volunteer, Scheduler scheduler, User user)
            throws JSONException, IOException {

        List<Boolean> temp = new ArrayList<>();

        String input;
        while (true) {

            // within volunteer side of the application, choose from new volunteer or exisiting volunteer
            System.out.println("Hello, Welcome to SafeWalk! Are you a new volunteer?(y/n)");
            input = scanner.nextLine();


            if (input.equalsIgnoreCase("y")) {
                //if input is y, new volunteer is asked to input all their details
                //user case 1: apply to be a volunteer

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


                System.out.println("Are you available on Thursday (y/n)");
                input = scanner.nextLine();
                String thu = input;
                if (thu.equalsIgnoreCase("y")) {
                    temp.add(true);
                } else {
                    temp.add(false);
                }


                System.out.println("Are you available on Friday (y/n)");
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

                //based on inputted data, new volunteer is created
                Volunteer x = new Volunteer(name, age, gender, temp);

                //the new volunteer is added to Volunteers (listOf volunteer)
                scheduler.addVolunteer(x);

                //after the new volunteer is added, goes back to main menu
                goBackMainMenu(scanner, volunteer, scheduler, user);

            } else {

                //if input is "n", looks at options as an exisitng volunteer
                goCurrentVolunteer(scanner, volunteer, scheduler, user);
            }
        }

    }


    private static void goCurrentVolunteer(Scanner scanner, Volunteer volunteer, Scheduler scheduler, User user)
            throws JSONException, IOException {


        int input;


        while (true) {
            System.out.println("Hello, welcome back to SafeWalk!");
            System.out.println("What can we do for you today:");
            System.out.println("1. Got free time? Add availability in one click!");
            System.out.println("2. Something came up? Delete availability in one click!");
            System.out.println("3. Made an error in personal information? Edit in one click!");
            System.out.println("4. Wrong Selection? quit here.");
            input = Integer.parseInt(scanner.nextLine());

            //if option is 1, goes to addSlot, which allows exisitng volunteer to add a shift
            if (input == 1) {
                //user case4: add availability as an exisitng volunteer
                addSlot(scanner, scheduler, user);

            }

            //if option is 2, goes to deleteslot, which allows exisitng volunteer to delete a shift
            if (input == 2) {
                //user case3: delete availability as an exisitng volunteer
                deleteSlot(scanner, scheduler, user);

            }

            //if option is 3, goes to editInfo, which allows exisitng volunteer to edit their information
            if (input == 3) {
                //user case2: edit personal information as an exisitng volunteer
                editInfo(scanner, volunteer, scheduler, user);

            }

            //quits application
            if (input == 4) {
                System.out.println("Leaving so soon? We will miss you. Stay safe, goodbye!");
                break;


            }

        }
    }


    private static void editInfo(Scanner scanner, Volunteer volunteer, Scheduler scheduler, User user)
            throws JSONException, IOException {

        //MODIFIES: parameter of given volunteer
        //EFFECTS: allows volunteer to edit their personal information.
        //REQUIRES: none

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

    private static void editGender(Scanner scanner, Volunteer volunteer, Scheduler scheduler, User user)
            throws JSONException, IOException {
        //MODIFIES: gender of given volunteer
        //EFFECTS: allows volunteer to edit their gender
        //REQUIRES: none
        String input;

        while (true) {
            System.out.println("Enetered the wrong gender? not to worry, change it one click!");
            System.out.println("Please enter yur name:");
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

    private static void editAge(Scanner scanner, Scheduler scheduler, User user) throws JSONException, IOException {

        //MODIFIES: age of given volunteer
        //EFFECTS: allows volunteer to edit their age.
        //REQUIRES: none

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

    public static void editName(Scanner scanner, Scheduler scheduler, User user) throws JSONException, IOException {

        //MODIFIES: name of volunteer
        //EFFECTS: allows volunteer to edit their name
        //REQUIRES: none
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

    public static void deleteSlot(Scanner scanner, Scheduler scheduler, User user) throws JSONException, IOException {

        //MODIFIES: the availability of given volunteer
        //EFFECTS: updates the volunteer's availability in the scheduler by deleting given day from their schedule
        //REQUIRES: none

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

            //deletes the day from volunteers schedule
            volunteer.deleteDay(volunteer, day);


            System.out.println("Shift deleted successfully");
            goBackMainMenu(scanner, volunteer, scheduler, user);

        }
    }

    public static void addSlot(Scanner scanner, Scheduler scheduler, User user) throws JSONException, IOException {

        //MODIFIES: the availability of given volunteer
        //EFFECTS: updates the volunteer's availability in the scheduler by adding given day from their schedule
        //REQUIRES: none

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


            //adds the day from volunteers schedule
            volunteer.addDay(volunteer, day);


            System.out.println("Shift added successfully");
            goBackMainMenu(scanner, volunteer, scheduler, user);

        }
    }


    public static void goClient(Scanner scanner, Volunteer volunteer, Scheduler scheduler, User user)
            throws JSONException, IOException {


        //goes to user/client section of application
        int input;

        while (true) {
            System.out.println("Something came up? don't worry, delete your shift in one click. ");

            System.out.println("1. Get a volunteer to walk you home safely");
            System.out.println("2. Quit");
            input = Integer.parseInt(scanner.nextLine());


            //allows user to pick the volunteer they want to walk them back home
            if (input == 1) {
                pickVolunteer(scanner, volunteer, scheduler, user);

            }

            //quits application
            if (input == 2) {
                System.out.println("Leaving so soon? We will miss you. Stay safe, goodbye!");
                goBackMainMenu(scanner, volunteer, scheduler, user);

            }
        }
    }

    public static void pickVolunteer(Scanner scanner, Volunteer volunteer, Scheduler scheduler, User user)
            throws JSONException, IOException {

        //MODIFIES: given user
        //EFFECTS: sets the assigned parameter of given user with their selection of volunteer


        //user case5: as a client, choose volunteer to walk me home safely on required day
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

            // returns list of volunteers that are on-duty on required day
            List<String> temp = Scheduler.onDuty(day);
            System.out.println(temp);


            //asks user to pick from list of volunteers available on the required day
            System.out.println("Choose your Volunteer:");
            input = scanner.nextLine();
            String volun = input;

            System.out.println("You have successfully been assigned to" + volun);
            goBackMainMenu(scanner, volunteer, scheduler, user);


        }
    }

    private static void goBackMainMenu(Scanner scanner, Volunteer volunteer, Scheduler scheduler, User user)
            throws JSONException, IOException {


        int input;
        System.out.println("Hello, Welcome to SafeWalk!");


        System.out.println("1. Are you a volunteer");
        System.out.println("2. Are you: a Client");
        System.out.println("3. Load app");
        System.out.println("4. Save app");
        System.out.println("5. Quit");

        input = Integer.parseInt(scanner.nextLine());

        if (input == 1) {

            //goes to volunteer side of the application if input is 1
            goVolunteer(scanner, volunteer, scheduler, user);

        }
        if (input == 2) {

            //goes to user/client side of the application if input is 1
            goClient(scanner, volunteer, scheduler, user);

        }
        if (input == 3) {

            //quits application
            loadApp(scheduler);

        }
        if (input == 4) {

            //quits application
            saveApp(scheduler);

        } else if (input == 5) {

            //quits application
            System.out.println("Leaving so soon? We will miss you. Stay safe, goodbye!");
            System.exit(0);

        }
    }

}


