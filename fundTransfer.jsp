<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<form id="fundTransfer" action="fundTransferPerform">
			<table>
				<tr>
					<td>Enter Sender account Number: <input type="number"
						name="senderAccountNum" min=101 required="required"></td>
				</tr>
				<tr>
					<td>Enter Reciever account Number: <input type="number"
						name="recieverAccountNum" min=101 required="required"></td>
				</tr>
				<tr>
					<td>Enter amount to be Transfered: <input type="number"
						name="amount" min="0" required="required"></td>
				</tr>
				<tr>
					<td><input type="submit" value="Transfer"></td>
				</tr>
			</table>
		</form>
	</div>

</body>
</html>