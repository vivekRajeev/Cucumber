Feature: Validate KPIreport page

Background:
Given I landed on fixedOps login page

@kpi  
Scenario Outline: Validate KPIreport login
Given Login to application with username <username> and password <password>
When Select any duration from the dropdown <duration>
Then verify that selected duration is present
Examples: 
   |username  							|password  			|duration													  |								
   |netspective.support 		|fixedopsv1@123	|Yesterday Sep 15 ' 22						  |
   |netspective.support 		|fixedopsv1@123	|Day Before Yest. Sep 14 ' 22 		  |
	 |netspective.support 		|fixedopsv1@123	|Last Week Sep 04 to Sep 10 ' 22	  |
   |netspective.support 		|fixedopsv1@123	|MTD Sep 01 to Sep 16 ' 22				  |
   |netspective.support 		|fixedopsv1@123	|Last Mth Aug											  |
   |netspective.support 		|fixedopsv1@123	|Last 3 Mths Jun to Aug						  |
   |netspective.support 		|fixedopsv1@123	|Last Qtr Apr to Jun							  |
   |netspective.support 		|fixedopsv1@123	|YTD Jan 01 to Sep 16 ' 22				  |
   |netspective.support 		|fixedopsv1@123	|Last 12 Mths Sep ' 21 to Aug ' 22	|
   |netspective.support 		|fixedopsv1@123	|Last Year Jan to Dec ' 21					|