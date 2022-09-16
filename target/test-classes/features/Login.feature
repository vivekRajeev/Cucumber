Feature: application login

Scenario: login with admin role
Given admin is on fixedops landing page
When admin login in to application with admin username and admin password
Then home page is prepopulated
And all the graphs are displayed


Scenario: login with user role
Given admin is on fixedops landing page
When user login in to application with username "forduser@fixedopspc.com" and password "fixedopsv1@123"
Then home page is prepopulated
And all the graphs are displayed



Scenario: login with client role
Given admin is on fixedops landing page
When user login in to application with username "fordclient@fixedopspc.com" and password "fixedopsv1@123"
Then home page is prepopulated
And all the graphs are displayed