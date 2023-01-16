using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using System.Web.Routing;

namespace TestAppA
{
    public class RouteConfig
    {
        public static void RegisterRoutes(RouteCollection routes)
        {
            routes.IgnoreRoute("{resource}.axd/{*pathInfo}");

            routes.MapRoute(
                name: "ForM02",
                url: "V2/{controller}/{action}/{id}",
                defaults: new { controller = "MResearch", action = "M02", id = UrlParameter.Optional }
            );

            routes.MapRoute(
                name: "ForM0333",
                url: "V3",
                defaults: new { controller = "MResearch", action = "M03" }
            );

            routes.MapRoute(
                name: "psev",
                url: "SomeCont/SomeAct",
                defaults: new { Controller = "MResearch", action = "M03"});

            routes.MapRoute(
                name: "ForM03",
                url: "V3/{controller}/X/{action}/{id}",
                defaults: new { controller = "MResearch", action = "M03", id = UrlParameter.Optional }
            );

            routes.MapRoute(
                name: "Default",
                url: "{controller}/{action}/{id}",
                defaults: new { controller = "MResearch", action = "M01", id = UrlParameter.Optional }
            );


        }
    }
}
