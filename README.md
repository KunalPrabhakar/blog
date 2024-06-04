Command to run docker = docker run --name mysql-container \   
  -e MYSQL_ROOT_PASSWORD=root_password \
  -e MYSQL_DATABASE=mydb \
  -e MYSQL_USER=myuser \
  -e MYSQL_PASSWORD=mypassword \
  -p 3307:3306 \
  -d mysql:latest

