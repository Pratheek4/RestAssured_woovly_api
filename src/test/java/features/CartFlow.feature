Feature: Validate Cart flow Api's

@NeedAuth
Scenario Outline: Verify Product added Sucessfully to the cart

Given User add <product_id> to cart with its <qty> and <varient_id>
When user calls "AddToCart" with "post" http request
Then AddToCart api call got success with status code <statusCode>
And "errMsg" in response body is <errMsg>
And "errMsg" in response body is <errMsg>


Examples:
|product_id   |qty|varient_id    |errMsg 				             |statusCode|
|6685493854387|1  |39785814950067|Product added Sucessfully          |200       |
|6685493854387|6  |39785814950067|Can't add more items	             |400       |
|668549385438 |2  |39785814950067|Produt does not exists/Out of Stock|404       |


@NeedAuth
Scenario Outline: Verify Product details fetched Sucessfully

Given Send request body for <coupon_title> ,<coupon_id> ,<is_coins_apply> and <payment_mode>
When user calls "FecthCartDetails" with "post" http request
Then Api call got success with status code 200
And "product_list.product_id" in response body is <data>


Examples:
|coupon_title|coupon_id|is_coins_apply|payment_mode|data           |
|null        |null     |null          |null        |[6685493854387]|



