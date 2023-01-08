using System;
using System.IO;
using System.Net.WebSockets;
using System.Text;
using System.Threading;
using System.Threading.Tasks;
using System.Web;
using System.Web.WebSockets;

namespace WebSocketApp
{
    public class WebSocketHandler : IHttpHandler
    {
        WebSocket _socket;
 
        #region Члены IHttpHandler

        public bool IsReusable
        {
            get { return false; }
        }


        public void ProcessRequest(HttpContext context)
        {
            if (context.IsWebSocketRequest)
                context.AcceptWebSocketRequest(WebSocketRequest);
        }

        private async Task WebSocketRequest(AspNetWebSocketContext context)
        {
            _socket = context.WebSocket;
            string receivedData = await Receive();
            Send(receivedData);

            while(_socket.State == WebSocketState.Open)
            {
                Send(DateTime.Now.ToString("HH:mm:ss"));
                Thread.Sleep(2000);
            }

            return;
        }

        private async Task<string> Receive()
        {
            string receivedData = null;
            var buffer = new ArraySegment<byte>(new byte[512]);
            var result = await _socket.ReceiveAsync(buffer, CancellationToken.None);
            receivedData = Encoding.UTF8.GetString(buffer.Array, 0, result.Count);

            return receivedData;
        }

        private void Send(string sendingData)
        {
            var sendBuffer = new ArraySegment<byte>(Encoding.UTF8.GetBytes("Ответ: " + sendingData));
            _socket.SendAsync(sendBuffer, WebSocketMessageType.Text, true, CancellationToken.None);
        }
        #endregion
    }
}
