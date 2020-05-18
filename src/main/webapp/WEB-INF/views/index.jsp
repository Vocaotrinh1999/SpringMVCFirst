<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
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
#a1{
font-size: 22px;
}
</style>
<body>
	<h2>Hello World!</h2>
	<a href="hello">Person form</a>
	<br>
	<a href="test2">Test2</a>
	<br>
	<a href="testJson">Test Json</a>
	<br>
	<a href="testListJson2">Test List Json</a>
	<br>
	<a href="testRest" id="a1">Test Rest Full Web</a><br>
	<a href="persons">/Person</a><br>
	<a href="persons/1">/Person Find</a><br>
	<a href="testVariable/204/VoCaoTrinh">Test Path Varaiable</a>
	<form action="redirect" , method="post">
		<input type="submit" value="Redirect">
	</form>

	<form action="redirectview", method="post">
		Name : <input type="text" name="name">
		Email : <input type="email" name="email">
		<input type="submit" value="Redirect">
	</form>

	<fieldset>
		<legend>Demo4</legend>
		<input type="button" id="display2" value="Display List"> <br> 
		Result : <div id="result4"></div>
	</fieldset>
</body>

<script type="text/javascript">
$(document).ready(function() {
	$('#display2').click(function() {
		$.ajax({
			type : 'GET',
			url : 'testListJson',
			headers : {
				Accept : "application/json; charset=utf-8",
				"Content-Type" : "application/json; charset=utf-8"
			},
			success : function(result) {
				console.log(result);
				var s ='<table style="width:100%">';
					s+='<tr><th>Id</th>'
					s+='<th>Name</th><th>Address</th><th>Age</th><th>Email</th><th>Phone Number</th>'
					s+='</tr>';
				//var person = JSON.parse(result);
				for (var i = 0; i < result.length; i++) {
					s+= '<tr><td>'+ result[i].id+'</td>';
					s+= '<td>'+ result[i].name+'</td>'
					s+= '<td>'+result[i].address+'</td>';
					s+= '<td> '+result[i].age+'</td>';
					s+= '<td>'+result[i].email+'</td>';
					s+= '<td>'+result[i].phoneNumber+'</td>';
					s+='</tr>'
				}
				s+='</table>';
				console.log(s);
				$('#result4').html(s);
			}
		});
	});
});
</script>

</html>
