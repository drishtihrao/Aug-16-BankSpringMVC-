<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>withdraw info</title>
</head>
<body>
	<div align="center">
		<form id="withdraw" action="withdrawPerform">
			<table>
				<tr>
					<td>Enter account Number: <input type="number" name="accountNum"
						min=101 required="required"></td>
				</tr>
				<tr>
					<td>Enter amount to be withdrawn: <input type="number"
						name="amount" min="0" required="required"></td>
				</tr>
				<tr>
					<td><input type="submit" value="Withdraw"></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>