#Use to run mysql db docker image, optional if you're not using a local mysqdb
#docker tun --name mysqldb -p 3306:3306 -e MYSQL_ALLOW_EMPTY_PASSWORD=yes -d mysql

# connect to mysql and run as root user
#Create databases
CREATE DATABASE sfg_dev;
CREATE DATABASE sfg_prod;

#Create database service accounts
CREATE USER 'sfg_dev_user'