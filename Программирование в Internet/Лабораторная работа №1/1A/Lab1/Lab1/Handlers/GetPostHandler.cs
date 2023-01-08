using System;
using System.IO;
using System.Web;

namespace Lab1.Handlers
{
    public class GetPostHandler : IHttpHandler
    {
        /// <summary>
        /// Вам потребуется настроить этот обработчик в файле Web.config вашего 
        /// веб-сайта и зарегистрировать его с помощью IIS, чтобы затем воспользоваться им.
        /// см. на этой странице: https://go.microsoft.com/?linkid=8101007
        /// </summary>
        #region Члены IHttpHandler

        public bool IsReusable
        {
            // Верните значение false в том случае, если ваш управляемый обработчик не может быть повторно использован для другого запроса.
            // Обычно значение false соответствует случаю, когда некоторые данные о состоянии сохранены по запросу.
            get { return true; }
        }

        public void ProcessRequest(HttpContext context)
        {
            if(context.Request.HttpMethod == "GET")
            {
                context.Response.ContentType = "text/html";
                context.Response.Write(File.ReadAllText("D:/Учеба/Программирование в Internet/Лабораторная работа №1/1A/Lab1/Lab1/html/Task5Page.html"));
                //context.Response.Write(File.ReadAllText("D:/Apps/Shedko/01/html/Task5Page.html"));

            }
            else
            {
                context.Response.Write(Convert.ToInt32(context.Request.Params["X"]) * Convert.ToInt32(context.Request.Params["Y"]));
            }
        }

        #endregion
    }
}
