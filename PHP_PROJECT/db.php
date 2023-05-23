<html>
<body>
	<form method="POST">
		Enter UserName <input type="text" name="username" placeholder="Enter username"><br />
		Enter Password <input type="password" name="password" placeholder="Enter Password"><br />
		<input type="submit" name="btnSubmit" value="Login">
	</form>
</body>
</html>
<?php
	$conn = mysqli_connect("localhost","root","","college");


	if(count($_POST) >0)
	{
		if($_POST['btnSubmit'] == "Login")
		{
			$username = $_POST['username'];
			$password = $_POST['password'];
			$query = "select * from user where email = '$username'";
			$result = mysqli_query($conn,$query);
			$count = mysqli_num_rows($result);
			if($count>0)
			{
				$row = mysqli_fetch_assoc($result);
				if($password == $row['password'])
				{
					echo "<br />Logged in successfully";
				}
				else
				{
					echo "<br />Please check the password you have entered";
				}
			}
			else
			{
				echo "<br />Username doesnot match with the record";
			}
		}
	}
	else if($_POST['btnSubmit'] == "Register")
	{
		$query = "insert into users(username,password) VALUES('$username','$password')";
		if(mysqli_query($conn,$query))
		{
			echo "<br />Data Inserted Successfully";
		}
		else
		{
			echo "<br />Failed to insert data, Try Again!";
		}
	}
	mysqli_close($conn);
?>