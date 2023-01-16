using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace TelephoneDirectory.Controllers
{
    public class ErrorHandlingController : Controller
    {
        public ActionResult PageNotFound()
        {
            ActionResult result;

            object model;
            int index = Request.Url.AbsoluteUri.IndexOf('?');

            if (index < 0)
                model = Request.Url.AbsoluteUri;
            else
                model = Request.Url.AbsoluteUri.Substring(0, index);

            result = View(model);

            ViewBag.Uri = model;
            ViewBag.Method = Request.HttpMethod;

            return result;
        }
    }
}