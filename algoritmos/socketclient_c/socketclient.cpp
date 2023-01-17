#include <arpa/inet.h>
#include <stdio.h>
#include <string.h>
#include <sys/socket.h>
#include <unistd.h>
#include <iostream>
#define PORT 4000
#define IP_ADDRESS "127.0.0.1"

using namespace std;

class socketclient {
	private: 
		int sock = 0, valread;
		struct sockaddr_in serv_addr;		

	public:
		void init() {
			if ((sock = socket(AF_INET, SOCK_STREAM, 0)) < 0) {
				printf("\n Socket creation error \n");
			}

			serv_addr.sin_family = AF_INET;
			serv_addr.sin_port = htons(PORT);

			if (inet_pton(AF_INET, IP_ADDRESS, &serv_addr.sin_addr)<= 0) {
				printf("\nInvalid address/ Address not supported \n");
			}

			if (connect(sock, (struct sockaddr*)&serv_addr,sizeof(serv_addr))< 0) {
				printf("\nConnection Failed \n");
			}
		}

		// alpha are numbers from 0 to 255
		void paintLine(int pRed, int pGreen, int pBlue, int pAlpha, int x0, int y0, int x1, int y1) {
			string message = "line,"+to_string(pRed)+","+to_string(pGreen)+","+to_string(pBlue)+","+to_string(pAlpha)+",";
			message += to_string(x0)+","+to_string(y0)+","+to_string(x1)+","+to_string(y1)+"\n";
			const char* msg = message.c_str();
			send(sock,msg, strlen(msg), 0);
		}

		void paintDot(int pRed, int pGreen, int pBlue, int pAlpha, int x0, int y0, int pRadius) {
			
			string message = "dot,"+to_string(pRed)+","+to_string(pGreen)+","+to_string(pBlue)+","+to_string(pAlpha)+",";
			message += to_string(x0)+","+to_string(y0)+","+to_string(pRadius)+"\n";
			const char* msg = message.c_str();
			send(sock,msg, strlen(msg), 0);
		}

		void clear() {
			char* msgclear = "clear\n";
			send(sock, msgclear, strlen(msgclear), 0);
		}

		void closeConnection() {
			close(sock);
		}
};

int main(int argc, char const* argv[])
{
	socketclient client;

	client.init();
	client.clear();
	client.paintLine(100, 25, 176, 255, 100, 100, 900, 700);
	client.paintDot(200, 0, 15, 200, 500, 600, 15);
	return 0;
}
