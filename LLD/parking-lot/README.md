### Design a parking lot using object-oriented principles

## Assumptions:
# - The parking lot can hold motorcycles, cars and vans
# - The parking lot has motorcycle spots, compact spots and large spots
# - A motorcycle can park in any spot
# - A car can park in a single compact spot, or a large spot
# - A van can park, but it will take up 3 compact spots or a large spot.  For
#   the purposes of this exercise, don't worry about if the compact spots are
#   next to each other
# - These are just a few assumptions. Feel free to ask your interviewer about
#   more assumptions as needed

# Here are a few methods that you should be able to run:
# - The ability to park a vehicle in the parking lot, and remove it later
# - Tell us how many spots are remaining
# - Tell us how many total spots are in the parking lot
# - Tell us when the parking lot is full
# - Tell us when the parking lot is empty
# - Tell us when certain spots are full e.g. when all motorcycle spots are taken
# - Tell us how many spots vans are taking up


## Clarifying questions from my side : 

1. We have divided Vehicles into 3 categories for our simplicity
2. If there is already a Motorcycle or a car in a spot and if we can fit one or more cars / motorcycle should we do it ?
3. Ticketing booth which will ask car to park at a spot and ask the vehicle owner to pay
   1. Clarifying questions : Do we ask the owner to pay up front or do we ask them to pay at the exit
   2. If at exit then a single ticket booth will have to handle both the scenarios - Parking as well as removing 
      1. We'll try to make this loosely coupled as in future if there comes automated exit so the system based on ticket timestamp will charge the user
   3. Are there any premium spots of parking which design should take care of ?
4. Is the parking lot a multi store parking lot ? We'll be having multiple floors 
5. At entry do we assign parking spot to the user ? or are there manual person who will do this job ?
6. Are there multiple parking entries and exits ?
   1. If yes do we always make users park somewhere near the parking tool (or entry ?). If no parking spot is available near entry then do we route him to other parking entry ?

-- is there anything specific which you want me to focus on ? 
-- What are the expectation from this code pair? Do we come up with best algo for finding the parking spot to maximize revenue ? 
-- Or we want to design extensible and scalable parking lot with good OO practices ?


-------

#### Start thinking + coding

* What are the major entities of this systems : 

1. Admin - Which will create a parking lot - So consider we are parking lot software provider and we give this to a company having admin which will enter details about parking lot and other things it has 
2. Vehicle is one entity - who is going to pay for the parking ticket
3. Parking booth - which will act as parking entry and exit
4. Parking 
   1. Parking floor 
   2. Parking division
   3. Parking spot
   4. Parking booth -- multiple booths - Ticket system

High level objects :

1. Ticket 
2. Payment 


Write test for the apis which are given : 
   