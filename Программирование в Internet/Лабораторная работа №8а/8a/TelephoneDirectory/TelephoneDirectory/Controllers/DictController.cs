using Microsoft.AspNetCore.Mvc;
using Microsoft.Extensions.Logging;
using Model;
using Model.Interface;
using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Linq;
using System.Threading.Tasks;
using TelephoneDirectory.Models;

namespace TelephoneDirectory.Controllers
{
    public class DictController : Controller
    {
        private readonly ILogger<DictController> _logger;
        private IPhoneDictionary _repository;

        public DictController(ILogger<DictController> logger, IPhoneDictionary repository)
        {
            _logger = logger;
            _repository = repository;
        }

        [HttpGet]
        public ActionResult Index()
        {
            ViewBag.PhoneRecords = _repository.GetCollection();
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
            _repository.AddElement(phoneRecord);
            _repository.SaveCollection();

            return Redirect("/Dict/Index");
        }

        [HttpGet]
        public ActionResult Update(int id)
        {
            ViewBag.Id = id;

            PhoneRecord updatedPhoneRecord = _repository.GetElement(id);
            ViewBag.LastName = updatedPhoneRecord.LastName;
            ViewBag.PhoneNumber = updatedPhoneRecord.PhoneNumber;

            return View(updatedPhoneRecord);
        }

        [HttpPost]
        public RedirectResult UpdateSave(PhoneRecord phoneRecord)
        {
            _repository.UpdateElement(phoneRecord);
            _repository.SaveCollection();

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
            _repository.DeleteElement(id);
            _repository.SaveCollection();

            return Redirect("/Dict/Index");
        }

        [ResponseCache(Duration = 0, Location = ResponseCacheLocation.None, NoStore = true)]
        public IActionResult Error()
        {
            return View(new ErrorViewModel { RequestId = Activity.Current?.Id ?? HttpContext.TraceIdentifier });
        }
    }
}
