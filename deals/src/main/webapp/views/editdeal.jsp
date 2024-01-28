<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ page import="domain.VerietyDeal"%>
<%@ page import="domain.Deal"%>
<!DOCTYPE html>
<html>
<meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
<title>Редактирование данных</title>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Deals</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="css/bootstrap.min.css">
<!-- jQuery -->
<script defer src="js/jquery.min.js"></script>
<!-- Bootstrap JS + Popper JS -->
<script defer src="js/bootstrap.min.js"></script>
</head>
<body>
<body>
<div class="container-fluid">
<jsp:include page="/views/header.jsp" />
<div class="container-fluid">
<div class="row justify-content-start ">
<div class="col-8 border bg-light px-4">
<h3>Список сделок</h3>
<table class="table">
<thead>
 <th scope="col">Код</th>
 <th scope="col">Тикер</th>
 <th scope="col">Тип</th>
 <th scope="col">Вид</th>
 <th scope="col">Валюта</th>
</thead>
<tbody>
<c:forEach var="deal" items="${deals}">
<tr>
 <td>${deal.getId()}</td>
 <td>${deal.getTicker()}</td>
 <td>${deal.getType()}</td>
 <td>${deal.getVeriety()}</td>
 <td>${deal.getCurrency()}</td>
</tr>
</c:forEach>
</tbody>
</table>
</div>
<div class="col-4 border px-4">
<form method="POST" action="">
<h3>Редактирование данных</h3>
<br>
<div class="mb-3 row">
<label for="iddeal" class="col-sm-3 col-form-label">
Код сделки</label>
<div class="col-sm-7">
<input type="text" class="form-control" readonly
id="iddeal" value="${dealEdit.getId()}" />
</div>
</div>
<div class="mb-3 row">
<label for="ticker" class="col-sm-3 col-form-label">
Тикер</label>
<div class="col-sm-7">
<input type="text" class="form-control" id="staticticker"
name="ticker" value="${dealEdit.getTicker()}"/>
</div>
</div>
<div class="mb-3 row">
<label for="ordertype" class="col-sm-3 col-form-label">
Тип</label>
<div class="col-sm-7">
<input type="text" class="form-control" id="staticordertype"
name="ordertype" value="${dealEdit.getType()}"/>
</div>
</div>
<div class="mb-3 row">
<label for="dealname" class="col-sm-3 col-form-label">
Вид</label>
<div class="col-sm-7">
<select name="veriety" class="form-control">
<option>Выберите вид</option>
<c:forEach var="veriety" items="${verieties}">
<option value="${veriety}">
<c:out value="${veriety.getNameveriety()}"></c:out>
</option>
</c:forEach>
</select>
</div>
</div>

<div class="mb-3 row">
<label for="currency" class="col-sm-3 col-form-label">Валюта
</label>
<div class="col-sm-7">
<input type="text" class="form-control" id="staticcurrency"
name="currency" value="${dealEdit.getCurrency()}"/>
</div>
</div>
<p>
<br>
<button type="submit" class="btn btnprimary">Редактировать</button>
<a href='<c:url value="deal" />' role="button"
class="btn btn-secondary">Отменить</a>
</p>
</form>
</div>
</div>
</div>
<jsp:include page="/views/footer.jsp" />
</div>
</body>
</html>