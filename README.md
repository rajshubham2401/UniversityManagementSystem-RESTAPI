# UniversityManagementSystem-RESTAPI
PROJECT MANUAL
==============

Project Name : University Management REST API

How To Use:
 
1. Import the UniversityManagementSystem-RESTAPI.zip into Eclipse From General>Projects From Folder Or Archive(Select Archive)
2. There Is File Called university_management.sql, Execute The Given Sql Queries In This File In  Your Mysql  WorkSpace.
3. Run this project on Tomcat-Server10.0.
4. Visit http://localhost:8080/universitymanagement/ To See The Running Project
5. Use API Client Tool(Like Postman)

You Can Perform The Tasks Listed Below Using This Api

1.Insert Department data with the subject details which they are teaching.

 
	method type: POST
	url:- http://localhost:8080/universitymanagement/webapi/departments/addDepartment
	method name:- addDepartment(DepartmentEntity departmentEntity);
	input:- 

	{
        "dept_id": "DP101",
       	"dept_name": "CSE",
        "subjects":[
            {
                "subject_id":"SUB101",
                "subject_name":"STLD"
            },
            {
                "subject_id":"SUB102",
                "subject_name":"CORE JAVA"
            },
            {
                "subject_id":"SUB103",
                "subject_name":"SYSTEM PROGRAMMING"
            },
            {
                "subject_id":"SUB104",
                "subject_name":"INFORMATION TECHNOLOGY"
            }
        ]
	}
	response:"Department Data Added Successfully"

2.Insert Student data with the subject details.


	method type: POST
	url:- http://localhost:8080/universitymanagement/webapi/students/addStudent
	method name:- addStudent( StudentEntity studentEntity);
	input:- 
	{
    	"student_name": "Shubham Raj",
    	"student_reg_no": "1701289389",
    	"student_age": 21,
    	"student_gender": "Male",
   	 "dept_id": "DP104",
    	"marks":
	[
        	{
            		"subject_id":"SUB101",
            		"mark":80
        	},
        	{
         	 	"subject_id":"SUB104",
        	 	"mark":60
        	},
        	{
            		"subject_id":"SUB105",
            		"mark":85
        	},
        	{
            		"subject_id":"SUB108",
            		"mark":90
        	}
   	]
	}
	response:"Department Data Added Successfull"

3.1.Get the Student info. (All)


	method type: GET
	url:- http://localhost:8080/universitymanagement/webapi/students/
	method name:- getStudents();
	input:- NA
	response:
	[
    	{
        	"dept_id": "DP101",
        	"student_age": 21,
        	"student_gender": "Male",
        	"student_name": "Shivam Sri",
        	"student_reg_no": "1701289101",
        	"subjects_id": "SUB101,SUB102,SUB103,SUB104"
    	},
    	{
        	"dept_id": "DP104",
        	"student_age": 21,
        	"student_gender": "Male",
        	"student_name": "Piyush Kumar",
        	"student_reg_no": "1701289371",
        	"subjects_id": "SUB101,SUB104,SUB105,SUB108"
    	},
    	{
        	"dept_id": "DP101",
        	"student_age": 21,
        	"student_gender": "Male",
        	"student_name": "Shubham Raj",
        	"student_reg_no": "1701289389",
        	"subjects_id": "SUB101,SUB102,SUB103,SUB104"
    	},
	]

3.2.Get the Student info. (Dept Wise)


	method type: GET
	url:- http://localhost:8080/universitymanagement/webapi/students/DP101
	method name:- getStudentWithDeptId(@PathParam("dept_id") String dept_id);
	input:- NA
	response:
	[
    	{
        	"dept_id": "DP101",
        	"student_age": 21,
        	"student_gender": "Male",
        	"student_name": "Shivam Sri",
        	"student_reg_no": "1701289101",
        	"subjects_id": "SUB101,SUB102,SUB103,SUB104"
    	},
    	{
        	"dept_id": "DP101",
        	"student_age": 21,
        	"student_gender": "Male",
        	"student_name": "Shubham Raj",
        	"student_reg_no": "1701289389",
        	"subjects_id": "SUB101,SUB102,SUB103,SUB104"
    	},
	]

4.Update the marks student is secured under each subject


	method type: PUT
	url:- http://localhost:8080/universitymanagement/webapi/marks/updateMarks
	method name:- updateMarks( MarksEntity marksEntity);
	input:- 
	{  
    		"student_reg_no": "1701289101",
    		"subject_id": "SUB101",
    		"mark": 80
	}
	response: "Student Marks Updated Succesfully"

5.Get top 3 students based on the total mark

	method type: GET
	url:- http://localhost:8080/universitymanagement/webapi/result/topThree
	method name:- getTopThree();
	input:- NA
	response:
	[
    		{
        	"averageMark": "85.0000",
        	"marks": 
		[
            		{
            		"mark": 120,
             		"student_reg_no": "1701289389",
                	"subject_id": "SUB101"
            		},
            		{
                	"mark": 80,
                	"student_reg_no": "1701289389",
                	"subject_id": "SUB102"
            		},
            		{
                	"mark": 40,
                	"student_reg_no": "1701289389",
                	"subject_id": "SUB103"
            		},
            		{
                	"mark": 100,
                	"student_reg_no": "1701289389",
                	"subject_id": "SUB104"
            		}
        	],
        	"student_name": "Shubham Raj",
        	"student_reg_no": "1701289389",
        	"totalMark": "340"
    		},
    		{
        	"averageMark": "80.0000",
        	"marks": 
		[
            		{
                	"mark": 80,
                	"student_reg_no": "1701289101",
                	"subject_id": "SUB101"
           	 },
            	{
                	"mark": 80,
                	"student_reg_no": "1701289101",
                	"subject_id": "SUB102"
            	},
            	{
                	"mark": 80,
                	"student_reg_no": "1701289101",
                	"subject_id": "SUB103"
            	},
            	{
                	"mark": 80,
                	"student_reg_no": "1701289101",
                	"subject_id": "SUB104"
            	}
        	],
        	"student_name": "Shivam Sri",
        	"student_reg_no": "1701289101",
        	"totalMark": "320"
    		},
    		{
        	"averageMark": "78.7500",
        	"marks": 
		[
            	{
                	"mark": 80,
                	"student_reg_no": "1701289390",
                	"subject_id": "SUB101"
            	},
            	{
                	"mark": 60,
                	"student_reg_no": "1701289390",
                	"subject_id": "SUB104"
            	},
            	{
                	"mark": 85,
                	"student_reg_no": "1701289390",
                	"subject_id": "SUB105"
            	},
            	{
                	"mark": 90,
                	"student_reg_no": "1701289390",
                	"subject_id": "SUB108"
            	}
        	],
        	"student_name": "Raj Raj",
        	"student_reg_no": "1701289390",
        	"totalMark": "315"
    		}
	]

6.Get Top 3 student based on the highest mark secured in each subject.

	method type: GET
	url:- http://localhost:8080/universitymanagement/webapi/result/topThree/SUB101
	method name:- getTopThreeBySubject(@PathParam("subject_id") String subject_id);
	input:- NA
	response:
	[
    	{
        	"mark": 100,
        	"student_reg_no": "1701289389",
        	"subject_id": "SUB101"
    	},
    	{
        	"mark": 80,
        	"student_reg_no": "1701289390",
        	"subject_id": "SUB101"
    	},
    	{
        	"mark": 80,
        	"student_reg_no": "1701289665",
        	"subject_id": "SUB101"
    	}
	]

7. Get the department details of which all the student has secured more than 30 marks.









