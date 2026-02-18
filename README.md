# Validator
I am trying to make a general validator for all the DTOs

# End Goal
My end goal here is to create a class which can provide validation for any 
type of DTO class and on any Path Param or Query Param and as soon as we pass a
wrong value, that annotation must catch that and should raise an appropriate 
issue with an appropriate message.

Suppose I added an `@ValidPhoneNumber` annotation on a field then to implement it I
must be able to pass the correct predicate logic and errorMessage to hanlde that 
error.
