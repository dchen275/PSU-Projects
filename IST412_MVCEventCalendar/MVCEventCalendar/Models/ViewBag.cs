using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace MVCEventCalendar.Models
{
    public class ViewBag
    {
        public IEnumerable<SelectListItem> Users { get; set; }
        public string Username { get; set; }
        public string FullName { get; set; }
    }
}