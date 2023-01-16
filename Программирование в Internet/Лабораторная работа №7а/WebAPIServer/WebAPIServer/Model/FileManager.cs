using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text.Json;
using System.Web;

namespace WebAPIServer.Model
{
    public class FileManager
    {
        private static string _filePath = "d:/Учеба/TelephoneDirectory.txt";
        public static void WriteInFile(List<PhoneRecord> phoneRecords)
        {
            string jsonData = JsonSerializer.Serialize(phoneRecords);
            using (StreamWriter streamWriter = new StreamWriter(_filePath))
            {
                streamWriter.WriteLine(jsonData);
            }
        }

        public static List<PhoneRecord> ReadFromFile()
        {
            if (!File.Exists(_filePath))
            {
                using (StreamWriter streamWriter = new StreamWriter(_filePath))
                {
                    streamWriter.Write("");
                }
            }

            List<PhoneRecord> phoneRecords;
            using (StreamReader streamReader = new StreamReader(_filePath))
            {
                string fileData = streamReader.ReadToEnd();
                if (!string.IsNullOrEmpty(fileData))
                    phoneRecords = JsonSerializer.Deserialize<List<PhoneRecord>>(fileData);
                else
                    phoneRecords = new List<PhoneRecord>();
            }

            return phoneRecords;
        }
    }
}