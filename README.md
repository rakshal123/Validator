# Validator
I am trying to make a general validator for all the DTOs

# End Goal
My end goal here is to create a class which can provide validation for any 
type of DTO class and on any Path Param or Query Param and as soon as we pass a
wrong value, that annotation must catch that and should raise an appropriate 
issue with an appropriate message.

Suppose I added an `@ValidPhoneNumber` annotation on a field then in some 
class I should first create this annotation using a ValidationFactory and then
I should be able to pass the appropriate check and generate an apt error message
with a proper code in case the value passed is incorrect.
