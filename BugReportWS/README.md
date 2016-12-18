# BUG storing DB table as service
This is a simple webservice to store a bug in a database. It is just a webservice exposore of a table. 

# Plan
Experiment with multiple instance, scalability, (horizontal+ vertical) under a load balancer with elastic behavior. 
 This is very small unit (only a table) , so we can use Raspberry PI host for this. 
 These are initial plan which eventually make a QA management infrastructure. 


# Property adding Guideline 
if you do not use Spring Boot Parent POM, you need to include this in your build 
<resources>
    <resource>
        <directory>src/main/resources</directory>
        <filtering>true</filtering>
    </resource>
</resources>