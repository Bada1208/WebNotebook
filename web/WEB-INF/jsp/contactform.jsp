<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

		<h1>Add New Employee</h1>
       <form:form method="post" action="save">  
      	<table >
            <tr>
                <td>Surname :</td>
                <td><form:input path="surname"/></td>
            </tr>
            <tr>
                <td>Name :</td>
                <td><form:input path="name"/></td>
            </tr>
            <tr>
                <td>Phone Number :</td>
                <td><form:input path="phone_number"/></td>
            </tr>
            <tr>
                <td>Age:</td>
                <td><form:input path="age"/></td>
            </tr>
         <tr>  
          <td> </td>  
          <td><input type="submit" value="Save" /></td>  
         </tr>  
        </table>  
       </form:form>  