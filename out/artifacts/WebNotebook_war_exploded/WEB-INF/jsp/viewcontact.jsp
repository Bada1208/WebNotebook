    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

	<h1>Contacts List</h1>
	<table border="2" width="70%" cellpadding="2">
	<tr><th>Id</th><th>Surname</th><th>Name</th><th>Phone Number</th><th>Age</th><th>Edit</th><th>Delete</th></tr>
    <c:forEach var="contact" items="${list}">
    <tr>
    <td>${contact.id}</td>
    <td>${contact.surname}</td>
    <td>${contact.name}</td>
    <td>${contact.phoneNumber}</td>
    <td>${contact.age}</td>
    <td><a href="editcontact/${contact.id}">Edit</a></td>
    <td><a href="deletecontact/${contact.id}">Delete</a></td>
    </tr>
    </c:forEach>
    </table>
    <br/>
    <a href="contactform">Add New Contact</a>