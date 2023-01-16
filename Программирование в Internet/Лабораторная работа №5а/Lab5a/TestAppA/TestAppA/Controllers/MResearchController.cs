using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace TestAppA.Controllers
{
    public class MResearchController : System.Web.Mvc.Controller
    {
        public ActionResult M01()
        {
            string answer = "GET:M01";
            Response.Write(answer);

            return View();
        }

        public ActionResult M02()
        {
            string answer = "GET:M02";
            Response.Write(answer);

            return View();
        }

        public ActionResult M03()
        {
            string answer = "GET:M03";
            Response.Write(answer);

            return View();
        }

        public ActionResult MXX()
        {
            string answer = "MXX1";

            Response.Write(answer);

            return View();
        }
    }
}