using System;
using System.IO;
using System.Web;

namespace WebApplication1.handlers
{
    public class IISHandler1 : IHttpHandler
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
            //context.Response.Write(File.ReadAllText("D:/Apps/Shedko/01B/html/HtmlPage1.html"));
            context.Response.Write(File.ReadAllText("D:/Учеба/Программирование в Internet/Лабораторная работа №1/1B/WebApplication1/WebApplication1/html/HtmlPage1.html"));
        }

        #endregion
    }
}
