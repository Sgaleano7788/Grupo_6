<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div id="tabla"></div>
<script src="https://d3js.org/d3.v4.min.js"></script>
<script>
d3.text("arch.csv", function(data) {
var parsedCSV = d3.csv.parseRows(data);
var container = d3.select("#tabla")
.append("productos")
.selectAll("tr")
.data(parsedCSV).enter()
.append("tr")
.selectAll("td")
.data(function(d) {return d;}).enter()
.append("td")
.text(function(d) {return d;});
});
</script>


</body>
</html>