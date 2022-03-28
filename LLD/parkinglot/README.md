### Design a parking lot using object-oriented principles

Goals:

-   This is first and foremost a pairing exercise. Feel free to ask questions,
    collaborate, and look up documentation as needed.
-   A single boilerplate test is provided at the bottom (in a few different
    testing frameworks). You aren't required to write tests, but it can be
    helpful. Feel free to pick one and delete the others.
-   Boilerplate is provided. Feel free to change the code as you see fit
-   Prefer extensibility and maintainability over code performance.
-   The surface area of this problem is a bit large for the time provided, feel
    free to break up the problem as needed. Completing all of the objectives
    isn't as important as making sure the implementation that has been
    completed is well written
-   At the end of the exercise you will be provided the opportunity to
    refactor. Just because we ask if there are any refactorings you want to do
    doesn't mean that we see something that needs to be fixed.
-   Feel free to use the "Run" button to execute the code as many times as you
    like. You should provide some way of exercising your code, whether it is a
    test or just executing it inline.
    Assumptions:
-   The parking lot can hold motorcycles, cars and vans
-   The parking lot has motorcycle spots, compact spots and large spots
-   A motorcycle can park in any spot
-   A car can park in a single compact spot, or a large spot
-   A van can park, but it will take up 3 compact spots or a large spot. For
    the purposes of this exercise, don't worry about if the compact spots are
    next to each other
-   These are just a few assumptions. Feel free to ask your interviewer about
    more assumptions as needed
    Here are a few methods that you should be able to run:
-   The ability to park a vehicle in the parking lot, and remove it later
-   Tell us how many spots are remaining
-   Tell us how many total spots are in the parking lot
-   Tell us when the parking lot is full
-   Tell us when the parking lot is empty
-   Tell us when certain spots are full e.g. when all motorcycle spots are taken
-   Tell us how many spots vans are taking up

#### Requirements collection and problem statement clarification

##### Assumptions :

1. So the main objective of this code pairing is to have a API design of Parking lot system and it is fine if we not focus on the core part like the strategy of fitting most number of vehicles in most optimized fashion. Or collecting say maximum profit (if given a choice which vechile to allow etc) that right ?
2. The Goals says that we have to make code as extensible and maintainable as possible - So which basically means we have to use best OO design principles and pattern while designing the Api is that fair assumption ?

##### Requirements and assumption:

1. Parking lot can hold motorcycle / car / vans (Vehicle)
2. Parking lots have multiple Spot with Spot type as Single / Compact / Large
3. Question - So as mentioned motor cycle can fit in any spot so is it like if a motor cycle is there in large spot then we can store multiple motor cycle in same spot ? (same for car - multiple car in large spot)
4. Is it fair assumption that parking lots are huge like it can have 1000 or maybe 10000 cars ?
5. Given the parking lots are huge we'll be having multiple floors per parking lot right ?
6. Is it fair assumption that parking lot will have multiple entrances ?
7. So typically what might happen is when you enter the parking -> At entrance you'll get the ticket and also the spot where you'll have to spot and at exit you pay based on number of hours or any other strategy
8. Do you have any specific way parking spot should be assigned ? (DS / Algo preference) or strategies ? -> Take care about system extensibility
9. System should not let anyone park if the capacity is full (On all ticket counter)
10. Payment will be taken in form of cash and card (but we don't stress much about this is that fine ?)
11. Basic idea is to design system as generic, extensible and re-usable as possible such that we are Parking lot system provider and this system as it is can be used with configuration changes for managing system for multiple clients like Food court or airport or hotels etc

We'll be going with bottom up designign approach - design smallest component and then build with connection

##### Implementation details and discussion :

Enties of the system :

1. Parking Lot System
2. Entrance
3. Vehicles => Reason for having this is at any point if we need list of Vehicles which were parked then we can get it
4. Floor
5. Parking Spot
6. Payment
7. Parking ticket
