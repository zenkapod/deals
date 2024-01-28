<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ page import="domain.VerietyDeal"%>


<!DOCTYPE html>
<html>
<meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
<title>Виды сделок</title>
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
 <div class="col-8 border bg-light px-4">
 <h3>Список видов</h3>
 <table class="table">
 <thead>
 <th scope="col">Код</th>
 <th scope="col">Вид сделки</th>
 <th scope="col"> Редактировать</th>
 <th scope="col">Удалить</th>
 </thead>
 <tbody>
 <c:forEach var="veriety" items="${verieties}">
 
 <tr>
 <td>${veriety.getId()}</td>
 <td>${veriety.getNameveriety()}</td>
 <td width="20">
  <a href="<c:url value="/editveriety?id=${veriety.getId()}" />" role="button" class="btn btn-outline-primary">
    <img alt="Редактировать" src="images/icon-edit.png" style="width: 18px; height: 18px;">
  </a>
</td>
<td width="20">
  <a href="<c:url value="/deleteveriety?id=${veriety.getId()}" />" role="button" class="btn btn-outline-primary">
    <img alt="Удалить" src="images/icon-delete.png" style="width: 16px; height: 16px;" 
    onclick="return confirm('Удалить должность с кодом:
'+${veriety.getId()}+'?')">
  </a>
</td>
 </tr>
 </c:forEach>
 </tbody>
 </table>
 </div>
 <div class="col-4 border px-4">
 <form method="POST" action="">
 <h3>Новый тип сделки</h3>
 <div class="mb-3">
 <br> <label for="inputVerietyDeal" class="col-sm-3 col-form-label">Вид</label>
 <div class="col-sm-6">
 <input type="text" name="inputVerietyDeal" class="form-control" id="dealVeriety" />
 </div>
 </div>
 <p>
 <br> <br> <br>
 <button type="submit"
 class="btn btn-primary">Добавить</button>
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