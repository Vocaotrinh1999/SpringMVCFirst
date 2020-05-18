<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>RESTful Web Service</title>
</head>
<body>
<h3>Demo Spring MVC RESTful Web Service</h3>
<input type="button" id="display2" value="Display List"> <br>
Result : <div id="result4"></div>
<br><br>
Result : <div id="result5"></div>
</body>

<style>
table, th, td {
  border: 1px solid black;
  border-collapse: collapse;
}
th, td {
  padding: 10px;
}
th {
  text-align: left;
}
</style>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	$('#display2').click(function() {
		$.ajax({
			type : 'GET',
			url : 'persons',
			headers : {
				Accept : "application/json; charset=utf-8",
				"Content-Type" : "application/json; charset=utf-8"
			},
			success : function(result) {
				console.log(result);
				var s ='<table style="width:100%">';
					s+='<tr><th>Id</th>'
					s+='<th>Name</th><th>Address</th><th>Age</th><th>Email</th><th>Phone Number</th><th>Action</th>'
					s+='</tr>';
				//var person = JSON.parse(result);
				for (var i = 0; i < result.length; i++) {
					s+= '<tr><td>'+ result[i].id+'</td>';
					s+= '<td>'+ result[i].name+'</td>'
					s+= '<td>'+result[i].address+'</td>';
					s+= '<td> '+result[i].age+'</td>';
					s+= '<td>'+result[i].email+'</td>';
					s+= '<td>'+result[i].phoneNumber+'</td>';
					var ac ='persons/'+ result[i].id;
					s+='<td><form action="'+ac+'", method="GET">'
					s+='<input type="Submit" value="EDIT" id="edit">'
					s+='</form></td>'
					s+='</tr>'
				}
				s+='</table>';
				console.log(s);
				$('#result4').html(s);
			}
		});
	});
	
	$('#edit').click(function() {
		$.ajax({
			type : 'GET',
			url : 'persons/',
			headers : {
				Accept : "application/json; charset=utf-8",
				"Content-Type" : "application/json; charset=utf-8"
			},
			success : function(result) {
				console.log(result);
				var s ='<table style="width:100%">';
					s+='<tr><th>Id</th>'
					s+='<th>Name</th><th>Address</th><th>Age</th><th>Email</th><th>Phone Number</th><th>Action</th>'
					s+='</tr>';
				//var person = JSON.parse(result);
					s+= '<tr><td>'+ result.id+'</td>';
					s+= '<td>'+ result.name+'</td>'
					s+= '<td>'+result.address+'</td>';
					s+= '<td> '+result.age+'</td>';
					s+= '<td>'+result.email+'</td>';
					s+= '<td>'+result.phoneNumber+'</td>';
					var ac ='persons/'+ result.id;
					s+='<td><form action="'+ac+'", method="GET">'
					s+='<input type="Submit" value="EDIT" id="edit">'
					s+='</form></td>'
					s+='</tr>'
				s+='</table>';
				$('#result5').html(s);
			}
		});
	});
});
</script>
</html>