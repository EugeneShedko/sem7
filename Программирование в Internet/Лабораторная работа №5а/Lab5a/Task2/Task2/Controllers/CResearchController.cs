using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Web;
using System.Web.Mvc;

namespace Task2.Controllers
{
    public class CResearchController : Controller
    {
        [AcceptVerbs("post", "get")]
        public ActionResult C01()
        {
            StringBuilder response = new StringBuilder();

            response.Append("Method: " + Request.HttpMethod + "</br>");

            var keys = Request.QueryString.AllKeys;
            if (keys.Length != 0)
            {
                StringBuilder queryParams = new StringBuilder();
                foreach (var item in Request.QueryString.AllKeys)
                {
                    queryParams.Append(item + "=" + Request.QueryString[item] + "; ");
                }
                response.Append("Parameters: " + queryParams.ToString() + "</br>");
            }

            response.Append("Uri: " + Request.Url.AbsoluteUri + "</br>");

            StringBuilder headers = new StringBuilder();
            foreach (var item in Request.Headers.AllKeys)
            {
                headers.Append("</br>" + item + ": " + Request.Headers[item]);
            }
            response.Append("Headers: " + headers.ToString() + "</br>");

            if(Request.HttpMethod.Equals("POST"))
            {
                string postBody;
                using(Stream stream = Request.InputStream)
                {
                    using(StreamReader streamReader = new StreamReader(stream))
                    {
                        streamReader.BaseStream.Position = 0;
                        postBody = streamReader.ReadToEnd();
                    }
                }

                response.Append("Body: " + postBody);
            }

            Response.Write(response.ToString());
            return View();
        }

        [AcceptVerbs("post", "get")]
        public ActionResult C02()
        {
            StringBuilder response = new StringBuilder();

            response.Append("Status code: " + Response.StatusCode + "</br>");

            StringBuilder headers = new StringBuilder();
            foreach (var item in Request.Headers.AllKeys)
            {
                headers.Append("</br>" + item + ": " + Request.Headers[item]);
            }
            response.Append("Headers: " + headers.ToString() + "</br>");

            string postBody;
            using (Stream stream = Request.InputStream)
            {
                using (StreamReader streamReader = new StreamReader(stream))
                {
                    streamReader.BaseStream.Position = 0;
                    postBody = streamReader.ReadToEnd();
                }
            }

            response.Append("Body: " + postBody);

            Response.Write(response.ToString());

            return View();
        }
    }
}