Facebook - Account Login Validation

Narrative:
As a user
I want to launch facebook url in browser
So that I can whether i can perform login task with invalid credentials

Lifecycle:
Before:
Scope: SCENARIO

Given user has launched facebook url

Scenario: Validate error message with invalid credentials in facebook login page
Meta:
@script_author Rasala Kranthi Kumar
@app facebook
@scenario verify_facebook_login_page
When user validates the page title
Then user validates the search in google