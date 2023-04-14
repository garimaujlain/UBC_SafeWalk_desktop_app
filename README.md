# My Personal Project

## UBC SafeWalk

This application is for UBC SafeWalk. The service is available seven days a week, from 8 pm to 2 am, during the academic year, and is an important resource for anyone who feels unsafe walking alone on campus after dark. It is available to all members of the UBC community. 
One can either choose to be a volunteer and accompany individuals on foot to on-campus locations such as residences, libraries, classrooms, and parking lots late at night; or they can be users who avail this service and choose a volunteer in cases where they feel unsafe and 
require assistance.

## Who will use it?

The service is an important resource for anyone who feels unsafe walking alone on campus after dark, and is available to all members of the UBC community.
It is also for those who want to volunteer and help make the UBC campus safer,
## Inspiration behind this project

As a UBC student in first year with friends that live in various different residences, I have noticed that a lot of the students choose to walk to various locations on campus past midnight despite the safety risk. This application aims to counter this and helps create a 
safer and more comfortable environment for UBC students. 

## User stories

- As a user, I want to be able to apply to be a volunteer for UBC SafeWalk and add my availability throughout the week based on my preferences.
- As a user, If I am an existing Volunteer, I want to be able to edit my personal information such as my Name, Age, and Gender.
- As a user, If I am an existing Volunteer, I want to be able to edit my availability and delete shifts in case something unexpected comes up.
- As a user, If I am an existing Volunteer, I want to be able to edit my availability and add shifts in case I find extra free time during the week.
- As a user, If I am a client, I want to be able to request company from a volunteer who is available on my required day so that I can get home safely and feel more secure. 
- As a user, If I am a volunteer, I want to be able to pick-up where I left off, and save my availability, and personal information, rather than filling out the form every time. 
- As a user, I want to be able to load my application.

# Instructions for Grader

- You can generate the first required action by adding a new volunteer to list of volunteers, or by adding new availability to a current volunteer's schedule.
- You can generate the second required action by deleting a current volunteer's availability from their schedule if they are busy on a particular day.
- You can locate my visual component by running the application, and at the very start you can see the image. 
- You can save the state of my application by clicking on save in the GUI. 
- You can reload the state of my application by clicking on load in the GUI. 

#Phase 4: Task 2
![](/home/gollum/IdeaProjects/project_z5q4k/phase4 task 2.png)

#Phase 4: Task 3

-The class for my console based UI, Main, has far too many lines of code that could have been broken down into smaller classes. To that end, in order to decrease coupling, my strategy is to split the console-based UI into several classes. This would limit each class to accessing only relevant information, resulting in a more modular and manageable design. By implementing this approach, I can ensure that the UI components are loosely linked, and changes made to one component will not impact the rest.

-In my entire project, I didn't make any interface/abstract classes. By adding these I could improve the design and maintainability of my project. A refactoring I would implement is to have both Volunteer and Client(class User here) extend an abstract class called User, since they have similar functionality.

-Another refactoring I would implement is breaking my GUI into smaller classes. At the moment it is split between two classes, but the majority of its functionality is in one class, namely mainframe, making it less manageable and efficient.

![](/home/gollum/IdeaProjects/project_z5q4k/UML_design_diagram.png)