<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
<head>

<!-- Stylesheets -->
<link rel="stylesheet"
	href="https://cdn.datatables.net/1.10.20/css/jquery.dataTables.min.css"
	crossorigin="anonymous">
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/demo.css" rel="stylesheet">

<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
<script src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>
<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>

<title>Moreau Demo Application</title>

</head>


<body>
	<div class="navbar navbar-expand-lg navbar-dark bg-primary">
		<div class="container">
			<a class="navbar-brand">Moreau Demo</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarResponsive" aria-controls="navbarResponsive"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarResponsive">
				<ul class="navbar-nav">
					<li class="nav-item dropdown"><a class="nav-link"
						href="#" id="example1">DataTable</a></li>
					<li class="nav-item"><a class="nav-link" href="#"
						id="example2">JQuery</a></li>
				</ul>
			</div>
		</div>
	</div>

	</br>


	<div id="datatable-example" class="container">

		<h2>DataTables Country Search</h2>
		<p>This example is using JQuery DataTables.</p>

		<table id="countrytable" class="table table-striped table-bordered"
			style="width: 100%">
			<thead>
				<tr>
					<th>ID</th>
					<th>Name</th>
					<th>Capital</th>
					<th>Region</th>
					<th>Sub Region</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="country" items="${countries}">
					<tr>
						<td>${country.cioc}</td>
						<td>${country.name}</td>
						<td>${country.capital}</td>
						<td>${country.region}</td>
						<td>${country.subregion}</td>
					</tr>
				</c:forEach>
		</table>
	</div>

	<div id="jquery-example" class="container">
		<h2>JQuery Countries Search</h2>
		<p>This example is straight JQuery.</p>

		<input id="myInput" type="text" placeholder="Search.."><br/>

		<table>
			<thead>
				<tr>
					<th>ID</th>
					<th>Name</th>
					<th>Capital</th>
					<th>Region</th>
					<th>Sub Region</th>
				</tr>
			</thead>
			<tbody id="jqueryTable">
				<c:forEach var="country" items="${countries}">
					<tr>
						<td>${country.cioc}</td>
						<td>${country.name}</td>
						<td>${country.capital}</td>
						<td>${country.region}</td>
						<td>${country.subregion}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

	</div>



</body>
</html>

<script>
	$("#example1").click(function() {
		$("#datatable-example").show();
		$("#jquery-example").hide();
	});

	$("#example2").click(function() {
		$("#datatable-example").hide();
		$("#jquery-example").show();
	});

	$("#myInput").on("keyup", function() {
		var value = $(this).val().toLowerCase();
		$("#jqueryTable tr").filter(function() {
			$(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
		});
	});

	$(document).ready(function() {
		$('#countrytable').DataTable();
		$("#jquery-example").hide();
	});
	
</script>