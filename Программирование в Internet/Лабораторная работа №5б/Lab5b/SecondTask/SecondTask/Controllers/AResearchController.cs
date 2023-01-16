using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace SecondTask.Controllers
{
    public class AResearchController : Controller
    {
        [AAFilter]
        public ActionResult AA()
        {
            Response.Write("AA");
            return View();
        }

        [ARFilter]
        public ActionResult AR()
        {
            Response.Write("AR");
            return View();
        }

        [AEFilter]
        public ActionResult AE()
        {
            throw new Exception();
            return View();
        }
    }
}