using MVCEventCalendar.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using System.Diagnostics;



namespace MVCEventCalendar.Controllers
{

    public class HomeController : Controller
    {
        // GET: Home
        public ActionResult Index()
        {
            using (teamfourEntities dc = new teamfourEntities())
            {
                var docs = dc.Users.Where(i => i.Type == 1).Select(i => new ViewBag
                {
                    Username = i.Username,
                    FullName = i.FirstName + " " + i.LastName
                }).ToList();

                ViewData["Username"] = new SelectList(docs, "Username", "FullName");
                return View();
            }

        }

        public JavaScriptResult LoginAuth(string username, string password)
        {
            using (teamfourEntities dc = new teamfourEntities())
            {
                if (dc.Users.Where(i => i.Username == username && i.Password == password).ToList() != null)
                {
                    return JavaScript("alert('Login Success');");
                }
                return JavaScript("alert('Login Fail');");


            }
        }

        public ActionResult Register()
        {
            return View();
        }

        public ActionResult Login()
        {
            return View();
        }

        public ActionResult About()
        {
            return View();
        }

        public ActionResult Contact()
        {
            return View();
        }
        public ActionResult Reminder()
        {
            return View();
        }
        public JsonResult CreateUser_Click(string username, string password)
        {
            bool status = false;
            using (teamfourEntities dc = new teamfourEntities())
            {
                if (dc.Users.Where(i => i.Username == username).ToList() != null)
                {
                    User newUser = new User
                    {
                        FirstName = "",
                        LastName = "",
                        Username = username,
                        Password = password,
                        MiddleName = "",
                        Type = 2
                    };
                    dc.Users.Add(newUser);
                }

                dc.SaveChanges();
                status = true;

            }
            return new JsonResult { Data = new { status = status } };
        }

        public JsonResult GetEvents()
        {
            using (teamfourEntities dc = new teamfourEntities())
            {
                var events = dc.Events.ToList();
                return new JsonResult { Data = events, JsonRequestBehavior = JsonRequestBehavior.AllowGet };
            }
        }

        [HttpPost]
        public JsonResult SaveEvent(Event e)
        {
            var status = false;
            using (teamfourEntities dc = new teamfourEntities())
            {
                if (e.EventID > 0)
                {
                    //Update the event
                    var v = dc.Events.Where(a => a.EventID == e.EventID).FirstOrDefault();
                    if (v != null)
                    {
                        v.Doctor = e.Doctor;
                        v.DoctorName = e.DoctorName;
                        v.Start = e.Start;
                        v.End = e.End;
                        v.Description = e.Description;
                        v.IsFullDay = e.IsFullDay;
                        v.ThemeColor = e.ThemeColor;
                    }
                }
                else
                {
                    dc.Events.Add(e);
                }

                dc.SaveChanges();
                status = true;

            }
            return new JsonResult { Data = new { status = status } };
        }

        [HttpPost]
        public JsonResult DeleteEvent(int eventID)
        {
            var status = false;
            using (teamfourEntities dc = new teamfourEntities())
            {
                var v = dc.Events.Where(a => a.EventID == eventID).FirstOrDefault();
                if (v != null)
                {
                    dc.Events.Remove(v);
                    dc.SaveChanges();
                    status = true;
                }
            }
            return new JsonResult { Data = new { status = status } };
        }
    }
}