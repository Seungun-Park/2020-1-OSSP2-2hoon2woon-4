/**
 * 2020-04-27 Seungun-Park
 * Server.cpp
 */
#include "ClientSocket.h"
#include "Server.h"

#include <thread>
#include <WS2tcpip.h>
#include <stdio.h>
#include <sstream>
#include <iomanip>
#include <iostream>

ClientSocket::ClientSocket(int _fd, sockaddr_in _addr, Server& _server)
    : client_fd(_fd), addr(_addr), server(_server), runable(true)
{	
	if (mysql_init(&sqlconn) == NULL)
		printf("mysql_init() error!");

	sqlconnection = mysql_real_connect(&sqlconn, sqlhost, sqluser, sqlpw, sqldb, 3306, (const char*)NULL, 0);
	if (sqlconnection == NULL)
		printf("%d error: %s, %d\n", mysql_errno(&sqlconn), mysql_error(&sqlconn));
	else
	{
		if (mysql_select_db(&sqlconn, sqldb))
			printf("%d error: %s, %d\n", mysql_errno(&sqlconn), mysql_error(&sqlconn));
	}
}

ClientSocket::~ClientSocket() 
{
	mysql_close(sqlconnection);
	closesocket(client_fd);
}

bool ClientSocket::isRunable()
{
	return runable;
}

void ClientSocket::run()
{
	while (1) 
	{
		std::fill(buf, buf + BUF_LEN, '\0');
		readLen = recv(client_fd, buf, BUF_LEN, 0);
		if (readLen < 1)
		{
			break;
		}
		printf_s("%s\n", buf);

		if (strcmp("login", buf)==0) login();
	};
	runable = false;
}

char* ClientSocket::ip()
{
	inet_ntop(AF_INET, &(addr.sin_addr), ipaddr, INET_ADDRSTRLEN);
	return ipaddr;
}

bool ClientSocket::login()
{
	printf("login request\n");

	std::fill(buf, buf + BUF_LEN, '\0');
	readLen = recv(client_fd, buf, BUF_LEN, 0);
	if (readLen < 1) return false;
	userid = buf;
	send(client_fd, buf, readLen, 0);

	std::fill(buf, buf + BUF_LEN, '\0');
	readLen = recv(client_fd, buf, BUF_LEN, 0);
	if (readLen < 1) return false;	
	std::stringstream ss;
	for (char e : buf)
		ss << std::hex << std::setw(2) << std::setfill('0') << (((int)e)&0x000000FF);
	pw = ss.str();
	std::cout << pw << std::endl;

	if (sqlconnection != NULL)
	{
		std::string query = "insert into tetrisDB.users(userid, password, name, email, major, admin) VALUES ('"+userid+"','"+pw+"','a','a','a',0)";
		if(mysql_query(sqlconnection, query.c_str()))
			printf("%d error: %s, %d\n", mysql_errno(&sqlconn), mysql_error(&sqlconn));
	}

	send(client_fd, "login request", 13, 0);
	return false;
}
