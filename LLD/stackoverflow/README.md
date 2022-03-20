# Design Stackoverflow LLD

### Reqements :

1. Members of stackoverflow are going to post questions
2. Members of stackoverflow are allowed to answer questions
3. Non members of stackoverflow are allowed to view questions and answer
4. Users are allowed to search for a question based on tags, keywords, of text similarity
5. Members will have reputation based on how they interact with the system
6. About certain reputation couple of features get unlocked like upvote - downvote etc 
7. Members get badges once they cross certain reputation
8. System should have ability to block users / restrict user activity based on certain conditions 
9. Questions can have bounty 
10. Members can pay for bounty for their question
11. Members can get bounty
12. Notification system for users who have posted their question

### Entities of the system

1. User
2. Member
3. Question
   1. Answer
   2. Comments
4. Search 



### Improvements : 

1. Have builder pattern for creating question
2. Comment and answer can be implemented from common interface just differentiated by ENUM Type
3. Number of times the question was viewed is important and needs to be captured in Questions class
4. Question state can be a ENUM - OPEN, CLOSED, ON_HOLD, DELETED
5. In members don't maintain List of questions, comment and answer