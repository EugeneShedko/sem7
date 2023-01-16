using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ServiceHost
{
    class Program
    {
        static void Main(string[] args)
        {
            using (var host = new System.ServiceModel.ServiceHost(typeof(WCFService.Service)))
            {
                host.Open();
                Console.WriteLine("Start");
                Console.ReadLine();
            }
        }
    }
}
