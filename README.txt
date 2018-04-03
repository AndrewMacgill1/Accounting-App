Here is the process for running the account application:

1. Run the App.java main class as a java application

2. Open a browser and enter localhost:8080 into the url
	This will take you to the default page however the homepage for the application is found at localhost:8080/index.html

3. From here you can navigate to the accounts page in which a call to a h2 database that has been provisioned with a few default accounts.

4a. The button 'Add New Account' will direct you to the add accounts page.

4b/c. Whilst the table of accounts is displayed, you have the option to edit/delete an account.
	This is currently undergoing issues as there is a problem with fully displaying accounts currently in the database.
	The edit/delete commands rely on accountId's to work as intended and since the are returning as null at the minute, removing them from the database is currently unavailable.
