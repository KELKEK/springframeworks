<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<section id="section">
		<h2>����������</h2>
		<hr />
		<div class="user-info">
			<p>��ö��</p>
			<p>573-50-00882</p>
		</div>

		<div class="stats">
			<h3>���</h3>
			<div id="chart_div"></div>
			<script type="text/javascript"
				src="https://www.gstatic.com/charts/loader.js"></script>
			<script type="text/javascript">
				google.charts.load("current", {
					packages : [ "corechart" ]
				});
				google.charts.setOnLoadCallback(drawChart);
				function drawChart() {
					var data = google.visualization.arrayToDataTable([
							[ "��¥", "�����Ǽ�" ], [ "2024-05-01", 1 ],
							[ "2024-05-02", 2 ], [ "2024-05-03", 1 ],
							[ "2024-05-04", 3 ], [ "2024-05-05", 1 ],
							[ "2024-05-06", 4 ], [ "2024-05-07", 2 ], ]);

					var options = {
						title : "�����Ǽ�",
						curveType : "function",
						legend : {
							position : "bottom"
						},
					};

					var chart = new google.visualization.LineChart(document
							.getElementById("chart_div"));

					chart.draw(data, options);
				}
			</script>
		</div>
	</section>
</body>
</html>