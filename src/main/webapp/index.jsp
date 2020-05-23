<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">

<title>Home</title>


</head>


<body>
<script>
// This code shows selected file name
$(".custom-file-input").on("change", function() {
  var fileName = $(this).val().split("\\").pop();
  $(this).siblings(".custom-file-label").addClass("selected").html(fileName);
});
</script>
	<nav class="navbar navbar-dark bg-primary">
		<div class="container">
			<a class="navbar-brand" href="#">Code Complexity Analyzer</a>
		</div>
		<a href="https://github.com/DinuwanB/Code-Complexity-Analyzer">
		<button class="btn btn" type="submit" id="inputGroupFileAddon04" >
			<i class="fab fa-github-square">GitHub</i>
		</button>
		</a>

	</nav>
	<br>
	<br>
	<div class="container">
		<form action="upload" method="POST" enctype="multipart/form-data">
			<div class="container">
			<div class="custom-file mb-3">
      <input type="file" class="custom-file-input" id="customFile"name="file" required>
      <label class="custom-file-label" for="customFile">Choose file</label>
    </div>
				
				<button type="submit" class="btn btn-secondary">Submit File</button>
			</div>
			
		</form>
	</div>
	
</body>
</html>
