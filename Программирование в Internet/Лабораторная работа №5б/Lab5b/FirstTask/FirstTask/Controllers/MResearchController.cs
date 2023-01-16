using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace FirstTask.Controllers
{
    [RoutePrefix("it")]
    public class MResearchController : Controller
    {
        [Route("{n:int}/{str}")]
        [HttpGet]
        public ActionResult M01B(int n, string str)
        {
            Response.Write("GET:M01:/" + n + "/" + str);
            return View();
        }

        [Route("{b:bool}/{letters:regex(^[a-zA-Z]+$)}")]
        [AcceptVerbs("post", "get")]
        public ActionResult M02(bool b, string letters)
        {
            Response.Write(Request.HttpMethod + ":M02:/ " + b.ToString() + "/" + letters);
            return View();
        }

        [Route("{f:float}/{str:length(2, 5)}")]
        [AcceptVerbs("delete", "get")]
        public ActionResult M03(float f, string str)
        {
            Response.Write(Request.HttpMethod + ":M03:/ " + f + "/" + str);

            return View();
        }

        
        [HttpPut, Route("{letters:regex(^[a-zA-Z]+$):length(3,4)}/{n:min(100):max(200)}")]
        public ActionResult M04(string letters, int n)
        {
            Response.Write(Request.HttpMethod + ":M04:/ " + letters + "/" + n);
            return View();
        }

        [HttpPost, Route(@"{mail:regex(^([a-z0-9_-]+\.)*[a-z0-9_-]+@[a-z0-9_-]+(\.[a-z0-9_-]+)*\.[a-z]{2,6}$)}")]
        public ActionResult M05(string mail)
        {
            Response.Write(Request.HttpMethod + ":" + mail);
            return View();
        }
    }
}