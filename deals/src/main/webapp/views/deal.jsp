<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ page import="domain.VerietyDeal"%>
<%@ page import="domain.Deal"%>

<!DOCTYPE html>
<html>
<meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
<title>Сделки</title>
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
<script
src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
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
 <th scope="col">Редактировать</th>
 <th scope="col">Удалить</th>
 </thead>
 <tbody>
 <c:forEach var="deal" items="${deals}">
 <tr>
 <td>${deal.getId()}</td>
 <td>${deal.getTicker()}</td>
 <td>${deal.getType()}</td>
 <td>${deal.getVeriety()}</td>
 <td>${deal.getCurrency()}</td>
 <td width="20">
  <a href="<c:url value="/editdeal?id=${deal.getId()}"/>" role="button" class="btn btn-outline-primary">
    <img alt="Редактировать" src="images/icon-edit.png" style="width: 18px; height: 18px;">
  </a>
</td>
<td width="20">
  <a href="<c:url value="/deletedeal?id=${deal.getId()}" />" role="button" class="btn btn-outline-primary">
    <img alt="Удалить" src="images/icon-delete.png" style="width: 16px; height: 16px;"
    onclick="return confirm('Удалить сотрудника с кодом:
'+${deal.getId()}+'?')">
  </a>
</td>
 </tr>
 </c:forEach>
 </tbody>
 </table>
 </div>
 <div class="col-4 border px-4">
 <form method="POST" action="">
 <h3>Новая сделка</h3>
 <br>
 <div class="mb-3 row">
 <label for="ticker"
 class="col-sm-3 col-form-label">Тикер</label>
 <div class="col-sm-7">
 <input type="text" class="form-control"
 id="staticticker"name="ticker" />
 </div>
 </div>
 <div class="mb-3 row">
 <label for="ordertype"
 class="col-sm-3 col-form-label">Тип</label>
 <div class="col-sm-7">
 <input type="text"
 class="form-control" id="staticordertype"
 name="ordertype" />
 </div>
 </div>
 
 <div class="mb-3 row">
 <label for="verietyname" class="col-sm-3 col-form-label">Вид</label>
 <div class="col-sm-7">
 <select name="veriety" class="form-control">
 <option>Выберите вид</option>
 <c:forEach var="verietydeal" items="${verieties}">
 <option value="${verietydeal}">
 <c:out value="${verietydeal.getNameveriety()}"></c:out>
 </option>
 </c:forEach>
 </select>
 </div>
 </div>

 <div class="mb-3 row">
 <label for="currency"
 class="col-sm-3 col-form-label">Валюта</label>
 <div class="col-sm-7">
 <input type="text" class="form-control"
 id="staticcurrency" name="currency" />
 </div>
 </div>
 <p> <br>
 <button type="submit"
 class="btn btn-primary">Добавить</button>
 </p>
 </form>
 </div>
 </div>
 </div>
 <jsp:include page="/views/footer.jsp" />
 </div>
</body>
</html>