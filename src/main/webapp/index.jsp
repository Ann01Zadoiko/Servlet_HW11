<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="style.css">
    <title>Time Zone</title>
</head>
<body>
    <div>
        <h1>Welcome to Time Zone!</h1>
    <h2>Here you can see a time that you want to know</h2>
    <form action="<%= request.getContextPath() %>/time" method="GET">
        <label for="timezone">Please, enter number of timezone</label></br>
        <input type="text" name="timezone"></input></br>
        <button type="submit">Submit</button>
    </form>
    </div>
</body>
</html>
