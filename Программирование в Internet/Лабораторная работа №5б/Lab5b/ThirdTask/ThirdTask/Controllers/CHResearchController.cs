using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace ThirdTask.Controllers
{
    public class CHResearchController : Controller
    {
        static int i = 0;

        [OutputCache(Duration = 5)]
        [HttpGet]
        public ActionResult AD()
        {
            i++;
            Response.Write(i);
            return View();
        }

        [OutputCache(Duration = 15, VaryByParam = "y")]
        [HttpPost, Route("{y:int}")]
        public ActionResult AP(int y)
        {
            i++;
            Response.Write(i);
            return View();
        }
    }
}