campusnet-api
=============

CampusNet API for java applications

##  CampusNet System

The idea in CampusNet is to generate a personal homepage for each user in the university based on the his/her role at the university (e.g. student, teacher, TAP, guest), and his/hers mappings and affiliations.
 
Through a simple interface the user can interact with literally all the university’s systems e.g. all kinds of registers, course catalogue, administration systems (scores, enrollments etc.), and so CampusNet integrates administration, groupware, e-learning and self-services.

CampusNet also has a public RESTful API which is documented [here](https://www.campusnet.dtu.dk/data/Documentation/CampusNet%20public%20API.pdf).

This information is taken from [Arcanic website](http://www.arcanic.dk/a-app/CampusNet_University_System/CampusNet_System.html).

## API Capabilities
CampusNet API has several functionalities around extracting course data, group data and overall user data. We will explain each functionality in its own section. During the development of this project, we aimed to have clear, concise, consistent, easy-to-read and easy-to-understand code, since it will be the backbone of many possible further applications that can be developed on top of it.

### How to login

```java
User CN = Api.login(cn_username, cn_password); // Right now, you can use API only for DTU access.
```

### How to access course/group info

- For accessing course/group messages:

```java
List<Message> messages = CN.getElementByName("02157 Functional programming")
			   			   .getMessageAccessor()
			   			   .getNewestMessages();
```

- For accessing course/group calendar:

```java
List<Appointment> appointments = CN.getElementByName("02157 Functional programming")
				  		   .getCalendarAccessor()
				  		   .getAppointments(startDate, endDate)
```

- For accessing course/group files:

```java
Folder rootFolder = CN.getElementByName("02157 Functional programming")
				  		   .getFileAccessor()
				  		   .getRootFolder();
```

- For downloading/uploading files to a specific folder:

```java
// to download a file 
rootFolder.getSubFolderByName("A subfolder name") // you can navigate between folders.
	  .getFileByName("A file name") // you can access a File in that Folder.
	  .getFileVersion(1) // you can access A FileVersion of that File.
	  .getBytes(); // you can download that version as byte array. 

// to upload a file
rootFolder.upload("file name", fileContent); // fileContent should be byte array. 

```
