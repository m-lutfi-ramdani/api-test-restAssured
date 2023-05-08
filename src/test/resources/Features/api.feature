@api-test-section-2
Feature: API Testing - Section 2
	
	@api-1
	Scenario: Successfully displayed single user with id
		Given Client without auth
		When Client "GET" request with path "/api/users/2"
		Then Response status should be 200
		And Client assert "data.id" should be match with 2
		
	@api-2
	Scenario: : Unsuccessful login attempt to submit without password
		Given Client without auth
		When Client "POST" request with path "/api/login" with body:
		"""
		{
   			 "email": "janet.weaver@reqres.in"
		}
		"""
		Then Response status should be 400
		And Response message should be "Missing password"
	
