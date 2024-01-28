<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ page import="domain.VerietyDeal"%>

<!DOCTYPE html>
<html>
<meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
<title>Виды клиентов </title>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Verieties</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="css/bootstrap.min.css">
<!-- jQuery -->
<script defer src="js/jquery.js"></script>
<!-- Bootstrap JS + Popper JS -->
<script defer src="js/bootstrap.min.js"></script>
</head>
<body>
<div class="container-fluid">
<jsp:include page="/views/header.jsp" />
<div class="container-fluid">
<div class="row justify-content-start ">
<div class="col-6 border bg-light px-4">
<h3>Список видов</h3>
<table class="table">
<thead>
<th scope="col">Код</th>
<th scope="col">Вид</th>
</thead>
<tbody>
<c:forEach var="veriety" items="${verieties}">
<tr>
<td>${veriety.getId()}</td>
<td>${veriety.getNameveriety()}</td>
</tr>
</c:forEach>
</tbody>
</table>
</div>
<div class="col-6 border px-4">
<form method="POST" action="">
<h3>Редактировать вид</h3>
<br> <br>
<div class="mb-3 row">
<label for="idveriety" class="col-sm-3 col-form-label">
Код вида</label>
<div class="col-sm-6">
<input type="text" class="form-control" readonly
value="${verietyEdit.getId()}" />
</div>
</div>
<div class="mb-3 row">
<br> <label for="inputVeriety"
class="col-sm-3 col-form-label">Вид</label>
<div class="col-sm-6">
<input type="text" name="inputVeriety" class="form-control"
value="${verietyEdit.getNameveriety()}" id="dealVeriety" />
</div>
</div>
<p>
<br> <br> <br>
<button type="submit"
class="btn btn-primary">Редактировать</button>
<a href='<c:url value="/veriety" />' veriety="button"
class="btn btn-secondary">Отменить</a>
<br>
</p>
</form>
</div>
</div>
</div>
<jsp:include page="/views/footer.jsp" />
</div>
</body>
</html>