<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@include file="Header.jsp"%>
    
    <link rel="stylesheet" href="../resources/css/jquery-ui.css">
    
    <script type="text/javascript" src="../resources/js/appointment.js"></script>
    <!-- <script src="../resources/js/jquery-1.10.2.js"></script>
    <script src="../resources/js/jquery-ui.js"></script> -->
	
	<style type="text/css">
		body
		{
			margin-top: 40px;
			text-align: center;
			font-size: 14px;
			font-family: "Lucida Grande",Helvetica,Arial,Verdana,sans-serif;
		    color: black;
		}
		#calendar
		{
			width: 900px;
			margin: 0 auto;
		}
	</style>
<body>
    <div>
        <!--FullCalendar container div-->
        <br />
	    <div id="calendar" class="fc fc-ltr"></div>
    </div>
    
  <div id="dialog-form" title="Create New Appointment">
  <p class="validateTips">All form fields are required.</p>

  <form>
    <fieldset>
      <label for="name">Name</label>
      <input type="text" name="name" id="name" value="Jane Smith" class="text ui-widget-content ui-corner-all">
      <label for="email">Email</label>
      <input type="text" name="email" id="email" value="jane@smith.com" class="text ui-widget-content ui-corner-all">
      <label for="password">Password</label>
      <input type="password" name="password" id="password" value="xxxxxxx" class="text ui-widget-content ui-corner-all">

      <!-- Allow form submission with keyboard without duplicating the dialog button -->
      <input type="submit" tabindex="-1" style="position:absolute; top:-1000px">
    </fieldset>
  </form>
</div>
</body>
<%@include file="Footer.jsp"%>
</html>