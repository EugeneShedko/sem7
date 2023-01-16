using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using TelephoneDirectory.Models;

namespace TelephoneDirectory.Controllers
{
    public class DictController : Controller
    {
        [HttpGet]
        public ActionResult Index()
        {
            IEnumerable<PhoneRecord> phoneRecords = PhoneRecordStorage.GetCollection().OrderBy(i => i.LastName);

            ViewBag.PhoneRecords = phoneRecords;
            return View();
        }

        [HttpGet]
        public ActionResult Add()
        {
            return View();
        }

        [HttpPost]
        public RedirectResult AddSave(PhoneRecord phoneRecord)
        {
            PhoneRecordStorage.AddElement(phoneRecord);
            PhoneRecordStorage.SaveCollection();

            return Redirect("/Dict/Index");
        }

        [HttpGet]
        public ActionResult Update(int id)
        {
            ViewBag.Id = id;

            PhoneRecord updatedPhoneRecord = PhoneRecordStorage.GetElement(id);
            ViewBag.LastName = updatedPhoneRecord.LastName;
            ViewBag.PhoneNumber = updatedPhoneRecord.PhoneNumber;

            return View();
        }

        [HttpPost]
        public RedirectResult UpdateSave(PhoneRecord phoneRecord)
        {
            PhoneRecordStorage.UpdateElement(phoneRecord);
            PhoneRecordStorage.SaveCollection();

            return Redirect("/Dict/Index");
        }

        [HttpGet]
        public ActionResult Delete(int id)
        {
            ViewBag.Id = id;

            return View();
        }

        [HttpPost]
        public RedirectResult DeleteSave(int id)
        {
            PhoneRecordStorage.DeleteElement(id);
            PhoneRecordStorage.SaveCollection();

            return Redirect("/Dict/Index");
        }
    }
}