Feature: Login scenarios 

@test1 		
Scenario Outline: Login with valid user name and password 

    Given I enter username as "<username>" 
	And I enter password as "<password>" 
	When I login
	And Scroll the products
	When select the product
	And go to cart
	#Then I should see Products page with title "<title>" 
	
	Examples: 
		| username | password | title |
		| standard_user | secret_sauce | PRODUCT |
		
@test2     
Scenario Outline: Go to product and removes

    Given I enter username as "<username>" 
    And I enter password as "<password>" 
    When I login
    And Scroll the products
    When select the product
    And  go to cart
    Then I will remove the product


    Examples: 
        | username | password |
        | standard_user | secret_sauce |
        
@test3    
Scenario Outline: CART TRANSACTION
    Given I enter username as "<username>" 
    And I enter password as "<password>" 
    When I login
    When select the product
    And  go to cart
    When checkout the cart
    When I enter user  firstname as "<firstname>"
    When I enter user  lastname as "<lastname>"
    When I enter my zone pincode as "<pincode>"
    When I click on the continue
    When Scroll the products
    Then I click on the Finish button

    Examples: 
        | username | password | firstname | lastname | pincode |
        | standard_user | secret_sauce | Vaibhav| Phulari | '413524' |