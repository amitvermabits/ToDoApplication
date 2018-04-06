Pre-Requisite:
1. Install Maven
2. Install Mysql Version > 5.0

Create MySQl Database Records:
1.Create database schema 'todoapp'.
2.Create table 'todoapp'
use todoapp;

create table todo_list(id int not null auto_increment, 
name varchar(100) not null, description text,
status varchar(20),start_time datetime ,end_time datetime ,
archived int default 0,primary key(id));

3. Insert Example records:
insert into todo_list values(1,'Purchase','Purchase','PENDING',now(),now() ,0);

insert into todo_list values(2,'Tavelling','Tavelling','PENDING',now(),now(),0);

insert into todo_list values(3,'Reading','Reading','PENDING',now(),now(),0);

insert into todo_list values(4,'Home Work','HOmeWork','PENDING',now(),now(),0);

3. Go to project root  using cmd and run 'mvn clean install' command

4.Step 3 will create a jar file named 'todoapp-0.0.1-SNAPSHOT.jar' in PROJECT_ROOT/target folder,got to 'PROJECT_ROOT/target' folder using cmd.

5. Run project using 'java -jar todoapp-0.0.1-SNAPSHOT.jar ' command from 'PROJECT_ROOT/target' folder.

6. Access application using 'http://localhost:8080/todo'