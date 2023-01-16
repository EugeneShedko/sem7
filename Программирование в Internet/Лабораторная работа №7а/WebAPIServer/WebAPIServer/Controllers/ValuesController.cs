using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Text.Json;
using System.Text.Json.Nodes;
using System.Web;
using System.Web.Http;
using WebAPIServer.Model;

namespace WebAPIServer.Controllers
{
    public class ValuesController : ApiController
    {
        private CollectionManager _collectionManager = new CollectionManager();
        // GET api/values
        public string Get()
        {
            JsonArray phoneRecords = new JsonArray();
            foreach (var item in _collectionManager.GetCollection())
            {
                phoneRecords.Add(item);
            }

            JsonObject jsonObject = new JsonObject();
            jsonObject.Add("phoneRecords", phoneRecords);

            string json = jsonObject.ToJsonString();
            return json;
        }

        [HttpPost]
        // POST api/values
        public async void Post(HttpRequestMessage request)
        {
            string body = await request.Content.ReadAsStringAsync();
            var phoneRecord = JsonSerializer.Deserialize<PhoneRecord>(body);

            _collectionManager.AddElement(phoneRecord);
            _collectionManager.SaveCollection();
        }

        [HttpPut]
        // PUT api/values/5
        public async void Put(int id, HttpRequestMessage request)
        {
            string body = await request.Content.ReadAsStringAsync();
            var phoneRecord = JsonSerializer.Deserialize<PhoneRecord>(body);

            _collectionManager.UpdateElement(new PhoneRecord(id, phoneRecord.LastName, phoneRecord.PhoneNumber));
            _collectionManager.SaveCollection();
        }

        // DELETE api/values/5
        public void Delete(int id)
        {
            _collectionManager.DeleteElement(id);
            _collectionManager.SaveCollection();
        }
    }
}
