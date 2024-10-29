@Pagination

Feature:S Class Page navigation Validation 

Background: 
			Given Admin launch the browser
   		When Admin gives the correct LMS portal URL
			Then Admin should land on dashboard page
			And Admin clicks on Class link page for navigation
		
@NextPage
Scenario: Verify Next page link(>)
	When Admin clicks Next page link on the class table for pagination
	Then Admin should see the next page record on the table has next active link enabled
	
	@LastPage
	Scenario: Verify Last page link(>>)		
	When Admin clicks Last page link for pagination
	Then Admin should see the last page record on the table with Next page link are disabled

@FistPage
	Scenario: Verify First page link(<)		
	When Admin clicks First page link for pagination
	Then Admin should see the previous page record on the table having previous page link enabled

@StartPage
	Scenario: Verify Start page link(<<)	
	When Admin clicks Start page link for pagination
	Then Admin should see the very first page record on the table with Previous page link are disabled


	
	
	

