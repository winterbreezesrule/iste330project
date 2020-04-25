# Intro

This is a (hopefully brief) guide on the basics of our project.

First things first, the work was divided between the three of us. Hansel worked on the user authentication methods. Aaron worked on the CRUD. Jay worked on implementing the get/set paper/user methods, as well as managing the project and making sure everything was kept up to speed. They also worked on the bulk of this ReadMe file. All three of them worked on debugging.

We made one modification to the CSM database--we changed the possible length of a User's password from varChar(45) to varChar(60).

## Basics

The first major feature of this project is the process by which a user "logs in." The first time they use this application, even if they are a returning user, they will have to reset their password. This is because the new encryption system that has been applied to this database has not been applied to every user--and therefore, they must reset their passwords in order to keep that information truly secure.. The code to do this is as follows:

Users newUser = new User();
newUser.resetPassword("test@email.com");

In order to emulate the process of getting emails without spamming random people in this list, we made use of the external application Papercut. Therefore, Papercut must be run in the background while using this application. In the future, if this application is installed on a server that runs a SMTP server, Papercut will not be needed. However, since none of the developers had a SMTP server running on their machines, we used this to streamline the process.

After retrieving the newly generated password from the email, a user resets their password. (However, if they do not do this within five minutes, they will need to repeat the above steps in order to reset their password again, as the reset password is only valid for that long.) The code to do this is as follows:

Users newUser = new User();
newUser.login("test@email.com", "randomly generated password "emailed" to you");
newUser.setPass("testpass");

At this point, the user will be able to use the various features implemented within the code. The password will be valid for the next six months. The code to log-in at this point is as follows:

Users newUser = new User();
String tokenString = newUser.login("test@email.com", "testpass");

The String that is returned when a user logs in is a token containing relevant info, and it's what is used to determine if a user has the rights to do various things.

If a user fails to log in properly, they will be notified. A user can fail to log-in if their information does not exist in the table, or if they need to reset their password.

## Features

What a user can do is determined first and foremost by their admin status. An admin is able to make any change to the database they please. Non-admins, then, are only allowed to make changes to papers they have worked on, or their own user information. The checks in place for this come from the token itself, which is passed into each potential method called on an object that could modify the database. 

A decoded token includes a user's ID, their first and last name, the email, their admin status, and the expiration date of their password's validity. The most important parts of the token for modifying parts of the database are the user's ID and their admin status. 

For all of the CRUD methods for all DataObjects aside from Users and Papers, a user cannot do anything if they are not an admin. Within these two objects, a user only has the rights to create, read, and write to objects--deletion is reserved strictly for admins.

Within Users and Papers, there are five specialized methods that return data beyond what's retrieved using a simple CRUD call. The five methods, and what a general user/admin can do, are listed below:

* Papers.getPaper(int paperId, String token) -- gets information on a specified paper. An admin can retrieve information on any paper. General users can only see information on papers they have participated in.
* Papers.setPaper(int paperId, String title, String _paperAbstract, int submissionType, String filename, int[] subjectIds, int[] coauthorIds, String token) -- either creates a new paper, if paperId is 0, or updates a paper. An admin can create or modify any paper. A general user can only create a paper they have participated in, or edit a paper they have participated in.
* Users.getPapers(int userId, String token) -- retrieves a list of all of the papers a user has written. An admin can retrieve the list of any user. A general user can only retrieve the list of papers they have worked on.
* Users.getUser() -- gets information on the instantiated user. This item does not have a check to see if a user is an admin, because one cannot access this information without having it all set beforehand. A blank user returns blank info.
* Users.setUser(String lastName, String firstName, String email, int affiliation, String token) -- either creates a new user, if userId is 0, or updates a user's information. An admin can update any user's information, but a user can only update their own information. There is no check for user creation, as a user cannot exist within the database if they haven't been created yet!

Throughout our classes, we make use of a custom exception in order for error logging and checking, called DLException. 