<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset= UTF-8">
<title>Insert title here</title>
</head>
<body>
	<center>
		<h2>input products</h2>
		<form name="pro_form" method="post" action="Product_input">
			<table width="300" border="1">
				<tr>
					<th width="100">상품명</th>
					<td><input type="text" name="pro_name" size="15" /></td>
				</tr>
				<tr>
					<th width="100">가격</th>
					<td><input type="text" name="pro_price" size="15" /></td>
				</tr>
				<tr>
					<th width="100">수량</th>
					<td><input type="text" name="pro_count" size="15" /></td>
				</tr>
				<tr>
					<td colspan="2" align="right"><input type="submit"
						value="등록" /></td>
				</tr>
				</table>
		</form>

	</center>
</body>
</html>