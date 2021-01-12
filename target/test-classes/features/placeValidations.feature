Feature: Validating Place API's
@AddPlace @Regression
Scenario Outline: Verify if place is being successfully added using AddPlaceAPI

Given Add place payload with "<name>","<address>","<language>"
When user calls "AddPlaceAPI" with "Post" http request
Then the API call got success with Status Code 200
And "status" in response body is "OK"
And "scope" in response body is "APP"
And Verify that place_id created using "GetPlaceAPI" maps to "<name>"

Examples:
|name                   |address             |language |
|AAhouse                |40 flutons Street   |English  |
#|BAhouse                |80 flutons Street   |Hindi    |

@DeletePlace  @Regression
Scenario: Verify that delete place functionality is working

Given Delete place payload 
When user calls "DeletePlaceAPI" with "Post" http request
Then the API call got success with Status Code 200
And "status" in response body is "OK"


